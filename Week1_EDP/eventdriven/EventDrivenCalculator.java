package eventdriven;
import java.awt.*;
import javax.swing.*;

public class EventDrivenCalculator extends JFrame {

    private JTextField display;
    private double firstOperand = 0;
    private String operator = "";
    private boolean startNewNumber = true;

    public EventDrivenCalculator() {

        // Window setup
        setTitle("Event-Driven Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        // Display field
        display = new JTextField("0");
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 28));
        display.setBackground(Color.WHITE);
        add(display, BorderLayout.NORTH);

        // Button panel
        JPanel buttonPanel = new JPanel(new GridLayout(4, 4, 5, 5));
        buttonPanel.setBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Row 1: 7, 8, 9, /
        buttonPanel.add(createNumberButton("7"));
        buttonPanel.add(createNumberButton("8"));
        buttonPanel.add(createNumberButton("9"));
        buttonPanel.add(createOperatorButton("/"));

        // Row 2: 4, 5, 6, *
        buttonPanel.add(createNumberButton("4"));
        buttonPanel.add(createNumberButton("5"));
        buttonPanel.add(createNumberButton("6"));
        buttonPanel.add(createOperatorButton("*"));

        // Row 3: 1, 2, 3, -
        buttonPanel.add(createNumberButton("1"));
        buttonPanel.add(createNumberButton("2"));
        buttonPanel.add(createNumberButton("3"));
        buttonPanel.add(createOperatorButton("-"));

        // Row 4: 0, C, =, +
        buttonPanel.add(createNumberButton("0"));
        buttonPanel.add(createClearButton("C"));
        buttonPanel.add(createEqualsButton("="));
        buttonPanel.add(createOperatorButton("+"));

        add(buttonPanel, BorderLayout.CENTER);

        // Window settings
        setSize(350, 450);
        setLocationRelativeTo(null);
    }

    // Creates number buttons
    private JButton createNumberButton(String text) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Arial", Font.BOLD, 20));

        // Event handler for number buttons
        btn.addActionListener(e -> {
            if (startNewNumber || display.getText().equals("Error")) {
                display.setText(text);
                startNewNumber = false;
            } else {
                String current = display.getText();

                if (current.equals("0")) {
                    display.setText(text);
                } else {
                    display.setText(current + text);
                }
            }
        });

        return btn;
    }

    // Creates operator buttons
    private JButton createOperatorButton(String op) {
        JButton btn = new JButton(op);
        btn.setFont(new Font("Arial", Font.BOLD, 20));

        // Event handler for operators
        btn.addActionListener(e -> {
            try {
                firstOperand = Double.parseDouble(display.getText());
                operator = op;
                startNewNumber = true;
            } catch (NumberFormatException ex) {
                clearCalculator();
            }
        });

        return btn;
    }

    // Creates the equals button
    private JButton createEqualsButton(String text) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Arial", Font.BOLD, 20));
        btn.setBackground(new Color(100, 200, 100));

        // Event handler for calculation
        btn.addActionListener(e -> {
            if (operator.isEmpty() || display.getText().equals("Error")) {
                return;
            }

            try {
                double secondOperand =
                        Double.parseDouble(display.getText());
                double result;

                switch (operator) {
                    case "+":
                        result = firstOperand + secondOperand;
                        break;

                    case "-":
                        result = firstOperand - secondOperand;
                        break;

                    case "*":
                        result = firstOperand * secondOperand;
                        break;

                    case "/":
                        if (secondOperand == 0) {
                            display.setText("Error");
                            operator = "";
                            startNewNumber = true;
                            return;
                        }
                        result = firstOperand / secondOperand;
                        break;

                    default:
                        return;
                }

                // Display whole numbers without .0
                if (Double.isFinite(result)
                        && result == Math.rint(result)
                        && Math.abs(result) < 1.0e16) {
                    display.setText(
                            String.valueOf((long) result));
                } else {
                    display.setText(String.valueOf(result));
                }

                operator = "";
                startNewNumber = true;

            } catch (NumberFormatException ex) {
                display.setText("Error");
                operator = "";
                startNewNumber = true;
            }
        });

        return btn;
    }

    // Resets the calculator
    private JButton createClearButton(String text) {
        JButton btn = new JButton(text);
        btn.setFont(new Font("Arial", Font.BOLD, 20));
        btn.setBackground(new Color(255, 150, 150));

        // Event handler for clear button
        btn.addActionListener(e -> clearCalculator());

        return btn;
    }

    // Shared clear method
    private void clearCalculator() {
        display.setText("0");
        firstOperand = 0;
        operator = "";
        startNewNumber = true;
    }

    public static void main(String[] args) {

        // Start Swing applications on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> {
            new EventDrivenCalculator().setVisible(true);
        });
    }
}
