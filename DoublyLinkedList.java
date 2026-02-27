package com.calculator;

/**
 * @param <T>
 */
public class DoublyLinkedList<T> extends AbstractList<T> {
    private DoubleNode<T> head;
    private DoubleNode<T> tail;

    public DoublyLinkedList() {
        super();
        head = null;
        tail = null;
    }

    @Override
    public void add(T element) {
        DoubleNode<T> newNode = new DoubleNode<>(element);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setPrevious(tail);
            tail.setNext(newNode);
            tail = newNode;
        }
        count++;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + count);
        }

        if (index == 0) {
            return removeFirst();
        }

        if (index == count - 1) {
            T data = tail.data();
            tail = tail.previous();
            tail.setNext(null);
            count--;
            return data;
        }

        DoubleNode<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next();
        }

        T data = current.data();
        current.previous().setNext(current.next());
        current.next().setPrevious(current.previous());
        count--;
        return data;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        T data = head.data();
        head = head.next();
        if (head != null) {
            head.setPrevious(null);
        } else {
            tail = null;
        }
        count--;
        return data;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + count);
        }

        DoubleNode<T> current = head;

        if (index < count / 2) {
            for (int i = 0; i < index; i++) {
                current = current.next();
            }
        } else {
            current = tail;
            for (int i = count - 1; i > index; i--) {
                current = current.previous();
            }
        }
        return current.data();
    }
}