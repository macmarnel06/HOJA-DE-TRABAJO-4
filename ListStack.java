package com.calculator;

/**
 * @param <T>
 */
public class ListStack<T> extends AbstractStack<T> {

    private IList<T> internalList;

    /**
     * @param listImplementation
     */
    public ListStack(IList<T> listImplementation) {
        this.internalList = listImplementation;
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