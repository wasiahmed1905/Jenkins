import java.util.Scanner;

public class Any {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean keepRunning = true;

        System.out.println("=== Java Console Calculator ===");

        while (keepRunning) {
            System.out.print("\nEnter first number: ");
            double num1 = getValidNumber(scanner);

            System.out.print("Enter an operator (+, -, *, /): ");
            char operator = scanner.next().charAt(0);

            System.out.print("Enter second number: ");
            double num2 = getValidNumber(scanner);

            double result;
            boolean validOperation = true;

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        System.out.println("Error: Division by zero is not allowed.");
                        validOperation = false;
                        result = 0;
                    } else {
                        result = num1 / num2;
                    }
                    break;
                default:
                    System.out.println("Error: Invalid operator entered.");
                    validOperation = false;
                    result = 0;
            }

            if (validOperation) {
                System.out.printf("Result: %.2f %c %.2f = %.2f%n", num1, operator, num2, result);
            }

            System.out.print("\nDo you want to perform another calculation? (yes/no): ");
            String response = scanner.next().trim().toLowerCase();
            if (!response.equals("yes") && !response.equals("y")) {
                keepRunning = false;
                System.out.println("Exiting calculator. Good!");
            }
        }

        scanner.close();
    }

    /**
     * Helper method to ensure valid numeric input.
     */
    private static double getValidNumber(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. Please enter a valid number: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }
}
