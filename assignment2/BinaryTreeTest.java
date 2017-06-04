package com.katermar.assignment2;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by USER on 5/31/2017.
 */
public class BinaryTreeTest {

    public static void main(String args[]) {
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

        List<BinaryTree.TreeNode> expectedAncestorList = new LinkedList<>();
        expectedAncestorList.add(new BinaryTree.TreeNode(5));
        expectedAncestorList.add(new BinaryTree.TreeNode(4));
        expectedAncestorList.add(new BinaryTree.TreeNode(2));

        findAllAncestorsTest(expectedAncestorList, tree, 7);

        System.out.println();
        checkLCA(4, tree, 7, 3);
        checkLCA(2, tree, 2, 1);
        checkLCA(10, tree, 2, 1);
    }

    public static String findLCAtest(BinaryTree tree, int a, int b) {

        BinaryTree.TreeNode LCA = tree.findLowestCommonAncestor(a, b);
        if (LCA == null) {
            return "Tree or both of nodes don't exist";
        }
        if (LCA.getValue() == a || LCA.getValue() == b) {
            return LCA + " - One of the nodes is LCA";
        }
        if (LCA.getValue() == tree.root.getValue()) {
            return LCA + " - LCA is a root";
        } else {
            return LCA + " - is LCA";
        }
    }

    private static void checkLCA(int expectedResult, BinaryTree tree, int a, int b) {

        System.out.print(findLCAtest(tree, a, b));
        if (tree.findLowestCommonAncestor(a, b).getValue() == expectedResult) {
            System.out.println(" <----- Grats! Test PASSED");
        } else {
            System.out.println(" <----- ERROR! Test FAILED");
        }
    }

    public static void findAllAncestorsTest(List<BinaryTree.TreeNode> expectedList, BinaryTree tree, int value) {
        List<BinaryTree.TreeNode> ancestorList = new LinkedList<>();
        if (!tree.findAllAncestors(ancestorList, tree.root, value)) {
            System.out.print("Element doesn't exist");
        } else {
            System.out.print("Ancestors - " + ancestorList);
        }

        if (ancestorList.equals(expectedList)) {
            System.out.println(" <----- Grats! Test PASSED");
        } else {
            System.out.println(" <----- ERROR! Test FAILED");
        }
    }
}
