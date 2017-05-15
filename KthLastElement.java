package com.katermar;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by USER on 5/15/2017.
 */
public class KthLastElement {

    private Integer value;
    public KthLastElement next;

    public KthLastElement(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "KthLastElement{" +
                "value=" + value +
                '}';
    }

    public KthLastElement findKth(Integer k, KthLastElement head) {
        KthLastElement current = head, before = head;

        if (k < 1 || current == null) {
            return current;
        }

        for (int i = 0; i < k - 1; i++) {
            current = current.next;
            if (current == null) {
                return current;
            }
        }

        while (current.next != null) {
            before = before.next;
            current = current.next;
        }

        return before;
    }
}
