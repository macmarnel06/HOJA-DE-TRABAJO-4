package com.calculator;

/**
 * Singleton Calculator that evaluates Infix and Postfix expressions.
 */
public class Calculator {

    private static Calculator instance;

    private Calculator() {
    }

    public static Calculator getInstance() {
        if (instance == null) {
            instance = new Calculator();
        }
        return instance;
    }

    /**
     * @param infix the infix expression string
     * @param stack the stack instance to use
     * @return the postfix expression string
     */
    public String infixToPostfix(String infix, IStack<Character> stack) {
        StringBuilder postfix = new StringBuilder();

        // Push special character 
        stack.push('#');

        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);

            // Skip spaces
            if (ch == ' ') {
                continue;
            }

            if (Character.isLetterOrDigit(ch)) {
                postfix.append(ch).append(" ");
                
                while (i + 1 < infix.length() && Character.isDigit(infix.charAt(i + 1))) {
                    postfix.deleteCharAt(postfix.length() - 1); 
                    postfix.append(infix.charAt(++i)).append(" ");
                }
            } else if (ch == '(') {
                stack.push('(');
            } else if (ch == '^') {
                stack.push('^');
            } else if (ch == ')') {
                while (!stack.empty() && stack.peek() != '(' && stack.peek() != '#') {
                    postfix.append(stack.pop()).append(" ");
                }
                if (!stack.empty() && stack.peek() == '(') {
                    stack.pop(); 
                }
            } else if (isOperator(ch)) {
                while (!stack.empty() && stack.peek() != '#' && precedence(ch) <= precedence(stack.peek())) {
                    postfix.append(stack.pop()).append(" ");
                }
                stack.push(ch);
            }
        }

        while (!stack.empty() && stack.peek() != '#') {
            char p = stack.pop();
            if (p != '(') {
                postfix.append(p).append(" ");
            }
        }

        
        if (!stack.empty() && stack.peek() == '#') {
            stack.pop();
        }

        return postfix.toString().trim();
    }

    /**
     * @param postfix
     * @param stack
     * @return
     */
    public int evaluatePostfix(String postfix, IStack<Integer> stack) {
        String[] tokens = postfix.split("\\s+");

        for (String token : tokens) {
            if (token.isEmpty())
                continue;

            if (isNumeric(token)) {
                stack.push(Integer.parseInt(token));
            } else if (isOperator(token.charAt(0))) {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Invalid postfix expression: not enough.");
                }
                int op2 = stack.pop();
                int op1 = stack.pop();
                int result = performOperation(token.charAt(0), op1, op2);
                stack.push(result);
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid postfix expression: to many.");
        }

        return stack.pop();
    }

    private boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
    }

    private int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }

    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private int performOperation(char op, int op1, int op2) {
        switch (op) {
            case '+':
                return op1 + op2;
            case '-':
                return op1 - op2;
            case '*':
                return op1 * op2;
            case '/':
                if (op2 == 0)
                    throw new ArithmeticException("Division by zero.");
                return op1 / op2;
            case '^':
                return (int) Math.pow(op1, op2);
            default:
                throw new IllegalArgumentException("Unknown operator: " + op);
        }
    }
}