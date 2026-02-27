package com.calculator;

import java.util.Vector;

/**
 * @param <T>
 */
public class VectorStack<T> extends AbstractStack<T> {

    private Vector<T> internalVector;

    public VectorStack() {
        internalVector = new Vector<>();
    }

    @Override
    public void push(T item) {
        internalVector.add(item);
    }

    @Override
    public T pop() {
        if (empty()) {
            return null;
        }
        return internalVector.remove(internalVector.size() - 1);
    }

    @Override
    public T peek() {
        if (empty()) {
            return null;
        }
        return internalVector.get(internalVector.size() - 1);
    }

    @Override
    public int size() {
        return internalVector.size();
    }
}