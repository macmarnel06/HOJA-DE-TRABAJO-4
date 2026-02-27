package com.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void testArrayListStack() {
        IStack<Integer> stack = new ArrayListStack<>();
        testStackImplementation(stack);
    }

    @Test
    void testVectorStack() {
        IStack<Integer> stack = new VectorStack<>();
        testStackImplementation(stack);
    }

    @Test
    void testSinglyListStack() {
        IStack<Integer> stack = new ListStack<>(new SinglyLinkedList<>());
        testStackImplementation(stack);
    }

    @Test
    void testDoublyListStack() {
        IStack<Integer> stack = new ListStack<>(new DoublyLinkedList<>());
        testStackImplementation(stack);
    }

    private void testStackImplementation(IStack<Integer> stack) {
        assertTrue(stack.empty());

        stack.push(5);
        stack.push(10);
        stack.push(15);

        assertEquals(3, stack.size());
        assertFalse(stack.empty());
        assertEquals(15, stack.peek());
        assertEquals(3, stack.size());

        assertEquals(15, stack.pop());
        assertEquals(2, stack.size());
        assertEquals(10, stack.pop());
        assertEquals(5, stack.pop());

        assertTrue(stack.empty());
        assertNull(stack.pop());
    }
}