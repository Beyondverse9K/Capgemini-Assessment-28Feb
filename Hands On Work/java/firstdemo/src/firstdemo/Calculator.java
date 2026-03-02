package firstdemo;

import java.util.Scanner;

class SimpleCalculator {
    public void calculate(String... tokens) {
        if (tokens == null || tokens.length == 0) return;
        try {
            double result = Double.parseDouble(tokens[0]);
            for (int i = 1; i < tokens.length; i += 2) {
                String operator = tokens[i];
                if (operator.equals("=")) {
                    break;
                }
                if (i + 1 >= tokens.length) break;
                double nextNumber = Double.parseDouble(tokens[i + 1]);
                switch (operator) {
                    case "+": result += nextNumber; break;
                    case "-": result -= nextNumber; break;
                    case "*": result *= nextNumber; break;
                    case "/": result /= nextNumber; break;
                    default:  System.out.println("Unknown operator: " + operator); return;
                }
            }

            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleCalculator calc = new SimpleCalculator();
        System.out.println("Enter expression");
        if (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            String[] tokens = input.split(" ");
            calc.calculate(tokens);
        }
        scanner.close();
    }
}