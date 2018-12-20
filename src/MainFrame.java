import org.w3c.dom.Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.nio.DoubleBuffer;


public class MainFrame extends JFrame{
    private final JButton buttonLeftBracket;
    private final JTextField textField; //显示区域
    private final JButton buttonRightBracket;
    private final JButton buttonSub;
    private final JButton buttonEqual;
    private final JTextField textFieldOutput;
    private JButton buttonSqrt;
    private JButton buttonClear;
    private JButton back;
    private JButton button_1;
    private JButton button_2;
    private JButton button_3;
    private JButton button_4;
    private JButton button_5;
    private JButton button_6;
    private JButton button_7;
    private JButton button_8;
    private JButton button_9;
    private JButton button_0;
    private JButton buttonAdd;
    private JButton buttionSub;
    private JButton buttonMulti;
    private JButton buttonDiv;
    private JButton buttonDoublePoint;
    private JButton buttonSin;
    private JButton buttonCos;
    private JButton buttonExp;
    private JButton buttonTan;
    private JButton buttonDel;
    private Calculator calculator; //计算表达式结果


    //表达式内容
    private String text = "";


    public MainFrame() {
        try {
            this.setUndecorated(false);
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "LOAD UI FAILED");
        }


        calculator = new Calculator(text);

        //根据分辨率设置窗口大小
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLayout(new GridLayout(6, 1));
        this.setSize(450, 400);
        textField = new JTextField(30);
        textField.setEditable(false);
        this.add(textField);

        textFieldOutput = new JTextField(30);
        textFieldOutput.setEditable(false);
        this.add(textFieldOutput);


        JPanel panelFirst = new JPanel();
        panelFirst.setLayout(new GridLayout(1, 5, 4, 4));
        button_7 = new JButton("7");
        button_7.addActionListener(e-> {
            onPushButton7Clicked();
        });
        button_8 = new JButton("8");
        button_8.addActionListener(e-> {
            onPushButton8Clicked();
        });
        button_9 = new JButton("9");
        button_9.addActionListener(e-> {
            onPushButton9Clicked();
        });
        buttonAdd = new JButton("+");
        buttonAdd.addActionListener(e-> {
            onPushButtonAddClicked();
        });
        buttonDel = new JButton("del");
        buttonDel.addActionListener(e-> {
            onPushButtonDelClicked();
        });
        buttonLeftBracket = new JButton("(");
        buttonLeftBracket.addActionListener(e-> {
            onPushButtonLeftBracketClicked();
        });
        panelFirst.add(button_7);
        panelFirst.add(button_8);
        panelFirst.add(button_9);
        panelFirst.add(buttonAdd);
        panelFirst.add(buttonDel);
        panelFirst.add(buttonLeftBracket);
        this.add(panelFirst);

        JPanel panelSecond = new JPanel();
        panelSecond.setLayout(new GridLayout(1, 5, 4, 4));
        button_4 = new JButton("4");
        button_4.addActionListener(e->{
            onPushButton4Clicked();
        });
        button_5 = new JButton("5");
        button_5.addActionListener(e->{
            onPushButton5Clicked();
        });
        button_6 = new JButton("6");
        button_6.addActionListener(e->{
            onPushButton6Clicked();
        });
        buttonSub = new JButton("-");
        buttonSub.addActionListener(e->{
            onPushButtonSubClicked();
        });
        buttonExp = new JButton("^");
        buttonExp.addActionListener(e->{
            onPushButtonExpClicked();
        });
        buttonRightBracket = new JButton(")");
        buttonRightBracket.addActionListener(e->{
            onPushButtonRightBracketClicked();
        });
        panelSecond.add(button_4);
        panelSecond.add(button_5);
        panelSecond.add(button_6);
        panelSecond.add(buttonSub);
        panelSecond.add(buttonExp);
        panelSecond.add(buttonRightBracket);
        this.add(panelSecond);

        JPanel panelThird = new JPanel();
        panelThird.setLayout(new GridLayout(1, 5, 4, 4));
        button_1 = new JButton("1");
        button_1.addActionListener(e->{
            onPushButton1Clicked();
        });
        button_2 = new JButton("2");
        button_2.addActionListener(e->{
            onPushButton2Clicked();
        });
        button_3 = new JButton("3");
        button_3.addActionListener(e->{
            onPushButton3Clicked();
        });
        buttonMulti = new JButton("*");
        buttonMulti.addActionListener(e->{
            onPushButtonMultiClicked();
        });
        buttonSin = new JButton("sin");
        buttonSin.addActionListener(e-> {
            onPushButtonSinClicked();
        });
        buttonCos = new JButton("cos");
        buttonCos.addActionListener(e-> {
            onPushButtonCosClicked();
        });
        panelThird.add(button_1);
        panelThird.add(button_2);
        panelThird.add(button_3);
        panelThird.add(buttonMulti);
        panelThird.add(buttonSin);
        panelThird.add(buttonCos);
        this.add(panelThird);

        JPanel panelFourth = new JPanel();
        panelFourth.setLayout(new GridLayout(1, 5, 4, 4));
        buttonDoublePoint = new JButton(".");
        buttonDoublePoint.addActionListener(e -> {
            onPushButtonPointClicked();
        });
        button_0 = new JButton("0");
        button_0.addActionListener(e -> {
            onPushButton0Clicked();
        });
        buttonEqual = new JButton("=");
        buttonEqual.addActionListener(e-> {
            onPushButtonEqualClicked();
        });
        buttonDiv = new JButton("/");
        buttonDiv.addActionListener(e->{
            onPushButtonDivClicked();
        });
        buttonClear = new JButton("AC");
        buttonClear.addActionListener(e->{
            onPushButtonClearClicked();
        });
        buttonTan = new JButton("tan");
        buttonTan.addActionListener(e->{
            onPushButtonTanClicked();
        });
        panelFourth.add(buttonDoublePoint);
        panelFourth.add(button_0);
        panelFourth.add(buttonEqual);
        panelFourth.add(buttonDiv);
        panelFourth.add(buttonClear);
        panelFourth.add(buttonTan);
        this.add(panelFourth);
    }

    private void onPushButtonTanClicked() {
        calculator.setText(text);
        try {
            double res = calculator.calcTan();
            textFieldOutput.setText("=" + Double.toString(res));
        } catch (Exception ex) {
            // String wrong = ex.getMessage();
            text = "";
            textField.setText(text);
            textFieldOutput.setText("表达式错误");

        }
    }

    private void onPushButtonClearClicked() {
        text = "";
        textField.setText(text);
        textFieldOutput.setText(text);
    }

    private void onPushButtonDivClicked() {
        text+='/';
        textField.setText(text);
    }

    private void onPushButtonEqualClicked() {
        calculator = new Calculator(text);
        try {
            Double res = calculator.calcRes();
            textFieldOutput.setText("=" + Double.toString(res));
        } catch (Exception ex) {
           // String wrong = ex.getMessage();
            text = "";
            textField.setText(text);
            textFieldOutput.setText("表达式错误");

        }
    }

    private void onPushButtonPointClicked() {
        text += '.';
        textField.setText(text);
    }

    private void onPushButtonCosClicked() {
        calculator.setText(text);
        try {
            double res = calculator.calcCos();
            textFieldOutput.setText("1231313");
            textFieldOutput.setText("=" + Double.toString(res));
        } catch (Exception ex) {
            // String wrong = ex.getMessage();
            text = "";
            textField.setText(text);
            textFieldOutput.setText("表达式错误");

        }
    }

    private void onPushButtonSinClicked() {
//        text = Calculator.sinCalc(text);
        calculator.setText(text);
        try {
            double res = calculator.calcSin();
            textFieldOutput.setText("=" + Double.toString(res));
        } catch (Exception ex) {
            // String wrong = ex.getMessage();
            text = "";
            textField.setText(text);
            textFieldOutput.setText("表达式错误");
        }
    }

    private void onPushButtonMultiClicked() {
        text += '*';
        textField.setText(text);
    }

    private void onPushButtonRightBracketClicked() {
        text += ')';
        textField.setText(text);
    }

    private void onPushButtonExpClicked() {
        text += '^';
        textField.setText(text);
    }

    private void onPushButtonSubClicked() {
        text += "-";
        textField.setText(text);
    }

    private void onPushButtonLeftBracketClicked() {
        text += "(";
        textField.setText(text);
    }

    private void onPushButtonDelClicked() {
        int len = text.length();
        if(len == 0) return;
        text = text.substring(0, len - 1);
        textField.setText(text);
    }

    private void onPushButtonAddClicked() {
        text += "+";
        textField.setText(text);
    }

    private void onPushButton0Clicked() {
        text += "0";
        textField.setText(text);
    }
    private void onPushButton1Clicked() {
        text += "1";
        textField.setText(text);
    }
    private void onPushButton2Clicked() {
        text += "2";
        textField.setText(text);
    }
    private void onPushButton3Clicked() {
        text += "3";
        textField.setText(text);
    }
    private void onPushButton4Clicked() {
        text += "4";
        textField.setText(text);
    }
    private void onPushButton5Clicked() {
        text += "5";
        textField.setText(text);
    }
    private void onPushButton6Clicked() {
        text += "6";
        textField.setText(text);
    }
    private void onPushButton7Clicked() {
        text += "7";
        textField.setText(text);
    }
    private void onPushButton8Clicked() {
        text += "8";
        textField.setText(text);
    }
    private void onPushButton9Clicked() {
        text += "9";
        textField.setText(text);
    }
}

