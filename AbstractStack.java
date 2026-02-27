package com.calculator;

/**
 * @param <T>
 */
public abstract class AbstractStack<T> implements IStack<T> {

    @Override
    public boolean empty() {
        return size() == 0;
    }
}