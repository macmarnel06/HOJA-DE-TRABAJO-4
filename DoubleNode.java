package com.calculator;

/**
 * @param <T>
 */
public class DoubleNode<T> {
    private T data;
    private DoubleNode<T> next;
    private DoubleNode<T> previous;

    public DoubleNode(T data) {
        this(data, null, null);
    }

    public DoubleNode(T data, DoubleNode<T> next, DoubleNode<T> previous) {
        this.data = data;
        this.next = next;
        this.previous = previous;
    }

    public T data() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public DoubleNode<T> next() {
        return next;
    }

    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }

    public DoubleNode<T> previous() {
        return previous;
    }

    public void setPrevious(DoubleNode<T> previous) {
        this.previous = previous;
    }
}