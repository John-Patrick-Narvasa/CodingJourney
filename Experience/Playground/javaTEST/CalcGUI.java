package Experience.Playground.javaTEST;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Calculator {
    private JFrame frame;
    private JTextField textField;

    public Calculator() {
        createGUI();
    }

    private void createGUI() {
        frame = new JFrame("Calculator");
        frame.setSize(200, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        textField = new JTextField(16);
        frame.add(textField);

        createButtons();
        frame.setVisible(true);
    }

    private void createButtons() {
        String[] buttonLabels = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "+", "-", "*", "/", "=", "C"};
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(new ButtonListener());
            frame.add(button);
        }
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("=")) {
                try {
                    double result = eval(textField.getText());
                    textField.setText(String.valueOf(result));
                } catch (Exception ex) {
                    textField.setText("Error");
                }
            } else if (command.equals("C")) {
                textField.setText("");
            } else {
                textField.setText(textField.getText() + command);
            }
        }
    }

    private double eval(String expression) {
        return new ExpressionParser(expression).parse();
    }

    private class ExpressionParser {
        private String expression;
        private int pos = -1;
        private char ch;

        public ExpressionParser(String expression) {
            this.expression = expression;
        }

        public double parse() {
            nextChar();
            double v = parseExpression();
            if (ch != -1) {
                throw new RuntimeException("Unexpected: " + (char) ch);
            }
            return v;
        }

        private void nextChar() {
            ch = (++pos < expression.length()) ? expression.charAt(pos) : -1;
        }

        private boolean eat(int charToEat) {
            while (ch == ' ') {
                nextChar();
            }
            if (ch == charToEat) {
                nextChar();
                return true;
            }
            return false;
        }

        private double parseExpression() {
            double v = parseTerm();
            while (true) {
                if (eat('+')) {
                    v += parseTerm(); // addition
                } else if (eat('-')) {
                    v -= parseTerm(); // subtraction
                } else {
                    break;
                }
            }
            return v;
        }

        private double parseTerm() {
            double v = parseFactor();
            while (true) {
                if (eat('*')) {
                    v *= parseFactor(); // multiplication
                } else if (eat('/')) {
                    v /= parseFactor(); // division
                } else {
                    break;
                }
            }
            return v;
        }

        private double parseFactor() {
            double v;
            int startPos = pos;

            if (eat('+')) {
                v = parseFactor(); // unary plus
            } else if (eat('-')) {
                v = -parseFactor(); // unary minus
            } else if (eat('(')) {
                v = parseExpression();
                eat(')');
            } else if ((ch >= '0' && ch <= '9') || ch == '.') {
                /* parse the number */
                while ((ch >= '0' && ch <= '9') || ch == '.') {
                    nextChar();
                }
                v = Double.parseDouble(expression.substring(startPos, pos));
            } else if (ch >= 'a' && ch <= 'z') {
                /* parse the variable */
                while (ch >= 'a' && ch <= 'z') {
                    nextChar();
                }
                String var = expression.substring(startPos, pos);
                v = 0; // TODO: implement variable
            } else {
                throw new RuntimeException("Unexpected: " + (char) ch);
            }

            return v;
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}