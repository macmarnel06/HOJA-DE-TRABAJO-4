package com.calculator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StackFactory<Character> charStackFactory = new StackFactory<>();
        StackFactory<Integer> intStackFactory = new StackFactory<>();

        try {
            while (true) {
                System.out.println("\n==================================================");
                System.out.println("Infix Evaluator");
                System.out.println("Select the Stack Implementation:");
                System.out.println("1. ArrayList");
                System.out.println("2. Vector");
                System.out.println("3. List");
                System.out.println("4. Exit");

                int stackChoice = 0;
                int listChoice = 0;

                System.out.print("Choice: ");
                String input = scanner.nextLine();
                stackChoice = Integer.parseInt(input.trim());

                if (stackChoice == 4) {
                    System.out.println("Exiting program...");
                    break;
                }

                if (stackChoice == 3) {
                    System.out.println("Select the List Implementation:");
                    System.out.println("1. Singly Linked List");
                    System.out.println("2. Doubly Linked List");
                    System.out.print("Choice: ");
                    String listInput = scanner.nextLine();
                    listChoice = Integer.parseInt(listInput.trim());
                }

                IStack<Character> conversionStack = charStackFactory.getStack(stackChoice, listChoice);
                IStack<Integer> evaluationStack = intStackFactory.getStack(stackChoice, listChoice);

                String filePath = "datos.txt";
                try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                    String line;
                    Calculator calculator = Calculator.getInstance();

                    while ((line = br.readLine()) != null) {
                        if (line.trim().isEmpty())
                            continue;
                        System.out.println("--------------------------------------------------");
                        System.out.println("Infix Expression: " + line);

                        try {
                            String postfix = calculator.infixToPostfix(line, conversionStack);
                            System.out.println("Postfix Expression: " + postfix);

                            int result = calculator.evaluatePostfix(postfix, evaluationStack);
                            System.out.println("Result: " + result);
                        } catch (Exception e) {
                            System.out.println("Error evaluating expression: " + e.getMessage());
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Error reading the file 'datos.txt': " + e.getMessage());
                }
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid. Please enter a valid number.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}