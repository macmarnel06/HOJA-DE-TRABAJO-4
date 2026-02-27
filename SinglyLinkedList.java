package com.calculator;

/**
 * @param <T>
 */
public class SinglyLinkedList<T> extends ListAbstract<T> {
    private Node<T> head;

    public SinglyLinkedList() {
        super();
        head = null;
    }

    @Override
    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next() != null) {
                current = current.next();
            }
            current.setNext(newNode);
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

        Node<T> current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next();
        }

        T data = current.next().data();
        current.setNext(current.next().next());
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
        count--;
        return data;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + count);
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next();
        }
        return current.data();
    }
}