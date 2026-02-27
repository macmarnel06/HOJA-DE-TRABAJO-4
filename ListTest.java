package com.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListTest {

    private SinglyLinkedList<Integer> singlyList;
    private DoublyLinkedList<Integer> doublyList;

    @BeforeEach
    void setUp() {
        singlyList = new SinglyLinkedList<>();
        doublyList = new DoublyLinkedList<>();
    }

    @Test
    void testSinglyLinkedList() {
        assertTrue(singlyList.isEmpty());
        singlyList.add(10);
        singlyList.add(20);
        singlyList.add(30);

        assertEquals(3, singlyList.size());
        assertEquals(20, singlyList.get(1));

        int removed = singlyList.remove(1);
        assertEquals(20, removed);
        assertEquals(2, singlyList.size());
        assertEquals(30, singlyList.get(1));

        assertEquals(10, singlyList.removeFirst());
        assertEquals(1, singlyList.size());
    }

    @Test
    void testDoublyLinkedList() {
        assertTrue(doublyList.isEmpty());
        doublyList.add(10);
        doublyList.add(20);
        doublyList.add(30);
        doublyList.add(40);

        assertEquals(4, doublyList.size());
        assertEquals(30, doublyList.get(2));

        int removed = doublyList.remove(2);
        assertEquals(30, removed);
        assertEquals(3, doublyList.size());
        assertEquals(40, doublyList.get(2));

        assertEquals(10, doublyList.removeFirst());
        assertEquals(2, doublyList.size());
    }
}