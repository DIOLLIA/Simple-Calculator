/*Created by Andre 09.01.2018
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EzCalculator {

    //initiation  window's components
    JButton button0 = new JButton("0");
    JButton button1 = new JButton("1");
    JButton button2 = new JButton("2");
    JButton button3 = new JButton("3");
    JButton button4 = new JButton("4");
    JButton button5 = new JButton("5");
    JButton button6 = new JButton("6");
    JButton button7 = new JButton("7");
    JButton button8 = new JButton("8");
    JButton button9 = new JButton("9");
    JButton buttonPoint = new JButton(".");
    JButton buttonEqual = new JButton("=");
    JButton buttonPlus = new JButton("+");
    JButton buttonMinus = new JButton("-");
    JButton buttonDivide = new JButton("/");
    JButton buttonMultiply = new JButton("*");

    JTextField display = new JTextField(20);
    JPanel window = new JPanel();

    EzCalculator() {
        BorderLayout borderLayout = new BorderLayout();        //init location manager
        window.setLayout(borderLayout);
        window.add("North", display);
        JPanel p1 = new JPanel();
        GridLayout g1 = new GridLayout(4, 3);
        p1.setLayout(g1);
        p1.add(button0);
        p1.add(button1);
        p1.add(button2);
        p1.add(button3);
        p1.add(button4);
        p1.add(button5);
        p1.add(button6);
        p1.add(button7);
        p1.add(button8);
        p1.add(button9);
        p1.add(buttonPoint);
        p1.add(buttonEqual);
        window.add("Center", p1); // panel with number, . and = marks

        JPanel p2 = new JPanel();
        p2.add(buttonPlus);
        p2.add(buttonMinus);
        p2.add(buttonDivide);
        p2.add(buttonMultiply);
        GridLayout g2 = new GridLayout(4, 1);
        p2.setLayout(g2);
        window.add("East", p2);

        JFrame jFrame = new JFrame("Calculator");//create frame and
        jFrame.setContentPane(window);              //set window into
        jFrame.pack(); // size to fit frame with component
        jFrame.setVisible(true);

        //creating exemplar of listener and register it for all button
        CalculatorCP calculatorCP = new CalculatorCP(this);
        button0.addActionListener(calculatorCP);
        button1.addActionListener(calculatorCP);
        button2.addActionListener(calculatorCP);
        button3.addActionListener(calculatorCP);
        button4.addActionListener(calculatorCP);
        button5.addActionListener(calculatorCP);
        button6.addActionListener(calculatorCP);
        button7.addActionListener(calculatorCP);
        button8.addActionListener(calculatorCP);
        button9.addActionListener(calculatorCP);
        buttonPoint.addActionListener(calculatorCP);
        buttonEqual.addActionListener(calculatorCP);
        buttonPlus.addActionListener(calculatorCP);
        buttonMinus.addActionListener(calculatorCP);
        buttonDivide.addActionListener(calculatorCP);
        buttonMultiply.addActionListener(calculatorCP);
    }

    public class CalculatorCP implements ActionListener {

        EzCalculator ezCalculator; // reference to calc window
        char selectedAction = ' '; // for + - * / symbols
        double currentResult = 0;

        CalculatorCP(EzCalculator ezCalculator) {

            this.ezCalculator = ezCalculator;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            JButton clickedButton = (JButton) e.getSource();// getting the source of
            String displayFieldText = ezCalculator.display.getText();
            double displayValue = 0;
            if (!"".equals(displayFieldText)) {
                displayValue = Double.parseDouble(displayFieldText);//getting the number from calc display
            }
            Object sour = e.getSource();
            if (sour == ezCalculator.buttonPlus) {
                selectedAction = '+';
                currentResult = displayValue;
                ezCalculator.display.setText("");
            } else if (sour == ezCalculator.buttonMinus) {
                selectedAction = '-';
                currentResult = displayValue;
                ezCalculator.display.setText("");
            } else if (sour == ezCalculator.buttonDivide) {
                selectedAction = '/';
                currentResult = displayValue;
                ezCalculator.display.setText("");
            } else if (sour == ezCalculator.buttonMultiply) {
                selectedAction = '*';
                currentResult = displayValue;
                ezCalculator.display.setText("");
            } else if (sour == ezCalculator.buttonEqual) {
                if (selectedAction == '+') {
                    currentResult += displayValue;
                    ezCalculator.display.setText("" + currentResult);
                } else if (selectedAction == '-') {
                    currentResult -= displayValue;
                    ezCalculator.display.setText("" + currentResult);
                } else if (selectedAction == '/') {
                    currentResult /= displayValue;
                    ezCalculator.display.setText("" + currentResult);
                } else if (selectedAction == '*') {
                    currentResult *= displayValue;
                    ezCalculator.display.setText("" + currentResult);
                }
            } else {
                String clickedButtonLable = clickedButton.getText();
                ezCalculator.display.setText(displayFieldText + clickedButtonLable);
            }

        }

    }

    public static void main(String[] args) {

        EzCalculator ezCalculator = new EzCalculator();
    }
}
