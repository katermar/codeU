package com.katermar;

public class Main {

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 9};
        Node list = new Node(12);
        list.fill(array);

        KthLastElement kthLastElement = new KthLastElement(list);
        System.out.println(kthLastElement);
        System.out.println(kthLastElement.findKth(0));

        CompareStringPermutation s = new CompareStringPermutation();
        System.out.println(s.compare("Listen", "Silent"));
        System.out.println(s.compare("Gred", "rgd"));
    }
}
