package com.katermar;

public class Main {

    public static void main(String[] args) {
        KthLastElement n = new KthLastElement(1);
        n.next = new KthLastElement(2);
        n.next.next = new KthLastElement(8);
        n.next.next.next = new KthLastElement(3);
        n.next.next.next.next = new KthLastElement(7);
        n.next.next.next.next.next = new KthLastElement(8);
        n.next.next.next.next.next.next = new KthLastElement(4);

        System.out.println(n.findKth(2, n));

        CompareStringPermutation s = new CompareStringPermutation();
        System.out.println(s.compare("Listen", "Silent"));
        System.out.println(s.compare("Gred", "rgd"));
    }
}
