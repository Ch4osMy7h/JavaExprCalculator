import javafx.fxml.FXMLLoader;

import javax.swing.*;
import java.lang.reflect.Field;
import java.util.Optional;
import java.util.Stack;





public class Calculator {
    /*
    优先符号表来源于THU_DSA Courses
     */
    private final char[][] pri = { //运算符优先等级 [栈顶] [当前]
        /*              |-------------------- 当 前 运 算 符 --------------------| */
        /*              +      -      *      /      ^      !      (      )      # */
        /* --  + */    {'>',   '>',   '<',   '<',   '<',   '<',   '<',   '>',   '>'},
        /* |   - */    {'>',   '>',   '<',   '<',   '<',   '<',   '<',   '>',   '>'},
        /* 栈  * */    {'>',   '>',   '>',   '>',   '<',   '<',   '<',   '>',   '>'},
        /* 顶  / */    {'>',   '>',   '>',   '>',   '<',   '<',   '<',   '>',   '>'},
        /* 运  ^ */    {'>',   '>',   '>',   '>',   '>',   '<',   '<',   '>',   '>'},
        /* 算  ! */    {'>',   '>',   '>',   '>',   '>',   '>',   ' ',   '>',   '>'},
        /* 符  ( */    {'<',   '<',   '<',   '<',   '<',   '<',   '<',   '=',   ' '},
        /* |   ) */    {' ',   ' ',   ' ',   ' ',   ' ',   ' ',   ' ',   ' ',   ' '},
        /* --  # */    {'<',   '<',   '<',   '<',   '<',   '<',   '<',   ' ',   '='}
    };



    String text; //所要计算的表达式
    Stack<Double> opnd;  //运算数栈
    Stack<Character> optr;//运算符栈

    public Calculator(String text) {
        this.text = text;
        this.opnd = new Stack<>();
        this.optr = new Stack<>();
    };

    public double calcRes() throws Exception {
        optr.push('#'); //判断是否结束
        text += "#";
        int index = 0;
        while(!optr.empty() ) {
            if(Character.isDigit(text.charAt(index))) {
                opnd.push((double)text.charAt(index) - '0');
                while(Character.isDigit(text.charAt(++index)) ) {
                    opnd.push(opnd.pop() * 10 + (text.charAt(index) - '0'));
                }
                if(text.charAt(index) == '.') {
                    float fraction = 1;
                    while(Character.isDigit(text.charAt(++index))) {
                        opnd.push(opnd.pop() + (text.charAt(index) - '0') * (fraction /= 10) );
                    }
                }
            } else {
                switch (priorityBetween(optr.peek(), text.charAt(index))) {
                    case '<':
                        optr.push(text.charAt(index++));
                        break;
                    case '=':
                        optr.pop(); index++;
                        break;
                    case '>':
                        char op = optr.pop();
                        double valFirst = opnd.pop();
                        double valSecond = opnd.pop();
                        //相反
                        opnd.push(calc(valSecond, op, valFirst));
                        break;
                     default:
                         throw new Exception("表达式错误");
                }
            }
        }
        return opnd.peek();
    }

    private Double calc(double valFirst, char op, double valSecond) throws Exception {
        switch (op) {
            case '+' : return valFirst + valSecond;
            case '-' : return valFirst - valSecond;
            case '*' : return valFirst * valSecond;
            case '/' : if ( 0 == valSecond ) throw new Exception("除数为0"); return valFirst/valSecond;
            case '^' : return Math.pow ( valFirst, valSecond );
            default  : throw new Exception("错误运算符");
        }
    }

    private char priorityBetween(Character op1, Character op2) throws Exception {
        return pri[optrToRank(op1)][optrToRank(op2)];
    }

    private char optrToRank(Character op) throws Exception {
        switch (op) {
            case '+' : return 0; //加
            case '-' : return 1; //减
            case '*' : return 2; //乘
            case '/' : return 3; //除
            case '^' : return 4; //乘方
            case '!' : return 5; //阶乘
            case '(' : return 6; //左括号
            case ')' : return 7; //右括号
            case '#': return 8; //起始符与终止符
            default: throw new Exception("未知的运算符");
        }
    }


    public static void main(String[] args) throws Exception {
        Calculator test = new Calculator("1*2");
        System.out.println(test.calcRes());
    }

    public double calcTan() throws Exception {
        return Math.tan(calcRes());
    }

    public double calcSin() throws Exception {
        return Math.sin(calcRes());
    }
    public double calcCos() throws Exception {
        return Math.cos(calcRes());
    }

    public void setText(String text) {
        this.text = text;
    }

}
