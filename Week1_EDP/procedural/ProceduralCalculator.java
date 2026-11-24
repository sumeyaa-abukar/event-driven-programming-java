
import java.util.Scanner;

public class ProceduralCalculator {

    public static void main(String[] args) {

        // Try-with-resources automatically closes the Scanner
        try (Scanner input = new Scanner(System.in)) {

            double num1, num2, result;
            String operator;

            // Get the first number
            System.out.print("Enter the first number: ");
            num1 = input.nextDouble();

            // Get the operator
            System.out.print("Enter an operator (+, -, *, /): ");
            operator = input.next();

            // Get the second number
            System.out.print("Enter the second number: ");
            num2 = input.nextDouble();

            // Perform the calculation
            switch (operator) {
                case "+" -> result = num1 + num2;
                case "-" -> result = num1 - num2;
                case "*" -> result = num1 * num2;
                case "/" -> {
                    if (num2 == 0) {
                        System.out.println("Error: Cannot divide by zero.");
                        return;
                    }
                    result = num1 / num2;
                }
                default -> {
                    System.out.println("Invalid operator. Please use +, -, *, or /.");
                    return;
                }
            }

            // Display the result
            System.out.println("Result: " + result);

        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid numbers.");
        }
    }
}
