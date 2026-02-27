package com.calculator;

/**
 * @param <T>
 */
public interface IList<T> {
    /** 
     * @param element
     */
    void add(T element);

    /**
     * @param index
     * @return
     */
    T remove(int index);

    /**
     * @return
     */
    T removeFirst();

    /**
     * @param index
     * @return
     */
    T get(int index);

    /**
     * @return
     */
    int size();

    /**
     * @return
     */
    boolean isEmpty();
}