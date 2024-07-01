package com.syedwaliullah.calculator;

import java.util.Scanner;

public class Application {
    /**
     * Main method to run the application. It checks for command-line arguments
     * and processes them if present; otherwise, it prompts the user for input.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        if (args.length > 0) {
            // Process CLI arguments
            String operation = args[0];
            if (args.length == 3) {
                try {
                    double num1 = Double.parseDouble(args[1]);
                    double num2 = Double.parseDouble(args[2]);
                    performOperation(operation, num1, num2);
                } catch (NumberFormatException e) {
                    System.out.println("Please provide valid numbers.");
                }
            } else {
                System.out.println("Please provide an operation followed by two numbers.");
            }
        } else {
            // No CLI arguments, ask for user input
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter operation (e.g., add, subtract, multiply, divide, factorial):");
            String operation = scanner.next();
            System.out.println("Enter the first number:");
            double num1 = scanner.nextDouble();
            double num2 = 0;
            if (!operation.equalsIgnoreCase("factorial")) {
                System.out.println("Enter the second number:");
                num2 = scanner.nextDouble();
            }
            performOperation(operation, num1, num2);
        }
    }

    /**
     * Performs the specified operation using the provided numbers and prints the result.
     *
     * @param operation The operation to perform (e.g., add, subtract, multiply, divide, factorial)
     * @param num1 The first number
     * @param num2 The second number (ignored for factorial)
     */
    private static void performOperation(String operation, double num1, double num2) {
        switch (operation.toLowerCase()) {
            case "add":
                System.out.println("Result: " + add(num1, num2));
                break;
            case "subtract":
                System.out.println("Result: " + subtract(num1, num2));
                break;
            case "multiply":
                System.out.println("Result: " + multiply(num1, num2));
                break;
            case "divide":
                if (num2 != 0) {
                    System.out.println("Result: " + divide(num1, num2));
                } else {
                    System.out.println("Cannot divide by zero.");
                }
                break;
            case "factorial":
                System.out.println("Result: " + factorial(num1));
                break;
            default:
                System.out.println("Unknown operation.");
        }
    }

    /**
     * Adds two numbers.
     *
     * @param a The first number
     * @param b The second number
     * @return The sum of a and b
     */
    public static double add(double a, double b) {
        return a + b;
    }

    /**
     * Subtracts the second number from the first number.
     *
     * @param a The first number
     * @param b The second number
     * @return The difference of a and b
     */
    public static double subtract(double a, double b) {
        return a - b;
    }

    /**
     * Multiplies two numbers.
     *
     * @param a The first number
     * @param b The second number
     * @return The product of a and b
     */
    public static double multiply(double a, double b) {
        return a * b;
    }

    /**
     * Divides the first number by the second number.
     *
     * @param a The first number
     * @param b The second number
     * @return The quotient of a and b
     */
    public static double divide(double a, double b) {
        return a / b;
    }

    /**
     * Calculates the factorial of a number using recursion.
     *
     * @param n The number to calculate the factorial of
     * @return The factorial of n
     */
    public static double factorial(double n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
