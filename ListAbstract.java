package com.calculator;

/**
 * @param <T>
 */
public abstract class ListAbstract<T> implements IList<T> {
    protected int count;

    public ListAbstract() {
        count = 0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}