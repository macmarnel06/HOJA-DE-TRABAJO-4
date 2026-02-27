package com.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;
    private IStack<Character> charStack;
    private IStack<Integer> intStack;

    @BeforeEach
    void setUp() {
        calculator = Calculator.getInstance();

        charStack = new ArrayListStack<>();
        intStack = new ArrayListStack<>();
    }

    @Test
    void testInfixToPostfix() {
        String infix = "(10+20)*9";

        String postfix = calculator.infixToPostfix(infix, charStack);

        assertEquals("10 20 + 9 *", postfix);
    }

    @Test
    void testEvaluatePostfix() {
        String postfix = "10 20 + 9 *";
        int result = calculator.evaluatePostfix(postfix, intStack);
        assertEquals(270, result);
    }
}