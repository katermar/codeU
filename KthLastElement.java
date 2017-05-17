package com.katermar;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by USER on 5/15/2017.
 */
public class KthLastElement {

    private Node list;

    public KthLastElement(Node list) {
        this.list = list;
    }

    public Node findKth(Integer k) {
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
