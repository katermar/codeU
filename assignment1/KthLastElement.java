package com.katermar.assignment1;

/**
 * Created by katermar on 5/15/2017.
 */
public class KthLastElement {

    private Node list;

    public KthLastElement(Node list) {
        this.list = list;
    }

    /*
    method to find k-th last element in the linked list
    @param k - which element to find
    @return found node of the linked list, if it exists
            or null if not
     */
    public Node findKth(int k) {
        Node current = list;
        Node before = list;

        if (k < 0 || current == null) {
            return current;
        }

        for (int i = 0; i < k; i++) {
            current = current.getNext();
            if (current == null) {
                return current;
            }
        }

        while (current.getNext() != null) {
            before = before.getNext();
            current = current.getNext();
        }

        return before;
    }

    public Node getList() {
        return list;
    }

    public void setList(Node list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "KthLastElement{ " +
                "list = " + list.showList() +
                '}';
    }
}
