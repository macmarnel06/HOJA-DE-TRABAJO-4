package com.calculator;

public class StackFactory<T> {

    /**
     * @param stackChoice
     * @param listChoice
     * @return
     */
    public IStack<T> getStack(int stackChoice, int listChoice) {
        switch (stackChoice) {
            case 1:
                return new ArrayListStack<>();
            case 2:
                return new VectorStack<>();
            case 3:
                IList<T> list;
                if (listChoice == 1) {
                    list = new SinglyLinkedList<>();
                } else if (listChoice == 2) {
                    list = new DoublyLinkedList<>();
                } else {
                    throw new IllegalArgumentException("Invalid List choice.");
                }
                return new ListStack<>(list);
            default:
                throw new IllegalArgumentException("Invalid Stack choice.");
        }
    }
}