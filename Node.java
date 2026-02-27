package com.calculator;

/**
 * Node for a singly linked list.
 * @param <T> type of data held by the node
 */
public class Node<T> {
    private T data;
    private Node<T> next;

    public Node(T data) {
        this(data, null);
    }

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public T data() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> next() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}