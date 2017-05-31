package com.katermar.assignment2;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by USER on 5/31/2017.
 */
public class BinaryTreeTest {

    public static void main(String args[])
    {
        BinaryTree tree = new BinaryTree();

        /* Construct the following binary tree
                  2
                /   \
               1     4
                    /  \
                   3    5
                         \
                          7
        */
        int[] array = {2, 1, 4, 3, 5, 7};
        tree.populateTree(array);
        System.out.println();

        List<BinaryTree.TreeNode> ancestorList = new LinkedList<>();
        if (!tree.findAllAncestors(ancestorList, tree.root, 7)) {
            System.out.println("Element doesn't exist");
        } else {
            System.out.println("Ancestors - " + ancestorList);
        }

        System.out.println();
        checkLCA(4, tree, 7, 3);
        checkLCA(2, tree, 2, 1);
        checkLCA(10, tree, 2, 1);
    }

    public static String findLCAtest(BinaryTree tree, int a, int b) {

        BinaryTree.TreeNode LCA = tree.findLowestCommonAncestor(tree.root, a, b);
        if (LCA == null) {
            return "Tree or both of nodes don't exist";
        }
        if (LCA.getValue() == a || LCA.getValue() == b) {
            return LCA + " - One of the nodes is LCA";
        }
        if (LCA.getValue() == tree.root.getValue()) {
            return LCA + " - LCA is a root";
        }
        else {
            return LCA + " - is LCA";
        }
    }

    public static void checkLCA(int expectedResult, BinaryTree tree, int a, int b) {

        System.out.print(findLCAtest(tree, a, b));
        if (tree.findLowestCommonAncestor(tree.root, a, b).getValue() == expectedResult) {
            System.out.println(" <----- Grats! Test PASSED");
        } else {
            System.out.println(" <----- ERROR! Test FAILED");
        }
    }
}
