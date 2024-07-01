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
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEnter operation (add, subtract, multiply, divide, pow, sqrt, log, log10, sin, cos, tan, factorial, permutation) or 'exit' to quit:");
            String operation = scanner.next();

            if (operation.equalsIgnoreCase("exit")) {
                System.out.println("Exiting calculator...");
                break;
            }

            // For operations requiring two inputs
            if (operation.equalsIgnoreCase("permutation")) {
                System.out.print("Enter total number of items: ");
                int total = scanner.nextInt();
                System.out.print("Enter number of items to select: ");
                int select = scanner.nextInt();
                try {
                    System.out.println("Result (recursive): " + permutationRecursive(total, select));
                    System.out.println("Result (iterative): " + permutationIterative(total, select));
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } else if (!operation.equalsIgnoreCase("sqrt") && !operation.equalsIgnoreCase("log") && !operation.equalsIgnoreCase("log10") &&
                !operation.equalsIgnoreCase("sin") && !operation.equalsIgnoreCase("cos") && !operation.equalsIgnoreCase("tan") &&
                !operation.equalsIgnoreCase("factorial")) {
                System.out.print("Enter first number: ");
                double num1 = scanner.nextDouble();
                System.out.print("Enter second number: ");
                double num2 = scanner.nextDouble();

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
                        System.out.println("Result: " + divide(num1, num2));
                        break;
                    case "pow":
                        System.out.println("Result: " + power(num1, num2));
                        break;
                    default:
                        System.out.println("Invalid operation.");
                        break;
                }
            } else {
                // For operations requiring one input
                System.out.print("Enter number: ");
                double num = scanner.nextDouble();

                switch (operation.toLowerCase()) {
                    case "sqrt":
                        System.out.println("Result: " + sqrt(num));
                        break;
                    case "log":
                        System.out.println("Result: " + log(num));
                        break;
                    case "log10":
                        System.out.println("Result: " + log10(num));
                        break;
                    case "sin":
                        System.out.println("Result: " + sin(Math.toRadians(num)));
                        break;
                    case "cos":
                        System.out.println("Result: " + cos(Math.toRadians(num)));
                        break;
                    case "tan":
                        System.out.println("Result: " + tan(Math.toRadians(num)));
                        break;
                    case "factorial":
                        System.out.println("Result: " + factorial((int) num));
                        break;
                    default:
                        System.out.println("Invalid operation.");
                        break;
                }
            }
        }

        scanner.close();
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
                System.out.println("Result: " + factorial((int) num1));
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
    public static long factorial(int n) {
        if (n < 0) {
            System.out.println("Factorial of negative number is undefined.");
            return 0;
        }
        return factorialHelper(n, n);
    }

    private static long factorialHelper(int originalNum, int num) {
        if (num <= 1) {
            System.out.println("\rCalculating factorial: 100%");
            return 1;
        }
        int progress = (int) (((originalNum - num + 1) / (double) originalNum) * 100);
        System.out.print("\rCalculating factorial: " + progress + "%");
        return num * factorialHelper(originalNum, num - 1);
    }

    // Exponentiation
    public static double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    // Square root
    public static double sqrt(double number) {
        return Math.sqrt(number);
    }

    // Natural logarithm
    public static double log(double number) {
        return Math.log(number);
    }

    // Base-10 logarithm
    public static double log10(double number) {
        return Math.log10(number);
    }

    // Sine function
    public static double sin(double angleRadians) {
        return Math.sin(angleRadians);
    }

    // Cosine function
    public static double cos(double angleRadians) {
        return Math.cos(angleRadians);
    }

    // Tangent function
    public static double tan(double angleRadians) {
        return Math.tan(angleRadians);
    }

    // Permutation Recursive
    public static long permutationRecursive(int total, int select) {
        if (select > total || total < 0 || select < 0 || total > 100) {
            throw new IllegalArgumentException("Invalid input values.");
        }
        if (select == 0) {
            return 1;
        }
        return total * permutationRecursive(total - 1, select - 1);
    }

    // Permutation Iterative
    public static long permutationIterative(int total, int select) {
        if (select > total || total < 0 || select < 0 || total > 100) {
            throw new IllegalArgumentException("Invalid input values.");
        }
        long result = 1;
        for (int i = 0; i < select; i++) {
            result *= total - i;
        }
        return result;
    }
}
