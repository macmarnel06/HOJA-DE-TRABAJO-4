package com.calculator;

import java.util.ArrayList;

/**
 * @param <T>
 */
public class ArrayListStack<T> extends AbstractStack<T> {

    private ArrayList<T> internalList;

    public ArrayListStack() {
        internalList = new ArrayList<>();
    }

    @Override
    public void push(T item) {
        internalList.add(item);
    }

    @Override
    public T pop() {
        if (empty()) {
            return null;
        }
        return internalList.remove(internalList.size() - 1);
    }

    @Override
    public T peek() {
        if (empty()) {
            return null;
        }
        return internalList.get(internalList.size() - 1);
    }

    @Override
    public int size() {
        return internalList.size();
    }
}