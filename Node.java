package com.katermar;

/**
 * Created by USER on 5/17/2017.
 */
public class Node {

    private Node next;
    private int value;

    public Node(int value) {
        this.value = value;
    }

    public void add(int value) {
        this.next = new Node(value);
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{ " +
                "value = " + value +
                '}';
    }

    public String showList() {
        StringBuilder sb = new StringBuilder();
        Node current = this;
        do {
            sb.append(current.getValue() + " ");
            current = current.next;
        } while (current != null);
        return sb.toString();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void fill(int[] array) {
        Node current = this;
        for (int i = 0; i < array.length; i++) {
            current.add(array[i]);
            current = current.next;
        }
    }
}
