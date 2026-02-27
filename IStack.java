package com.calculator;

/**
 * @param <T>
 */
public interface IStack<T> {

    /**
     * @param item
     */
    void push(T item);

    /**
     * @return
     */
    T pop();

    /**
     * @return
     */
    T peek();

    /**
     * @return
     */
    boolean empty();

    /**
     * @return
     */
    int size();
}