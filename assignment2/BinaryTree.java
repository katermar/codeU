package com.katermar.assignment2;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by katermar on 5/23/2017.
 */
public class BinaryTree {
    TreeNode root;

    /*Inner class for Binary Tree node
    * @field value stores integer value
    * @field left, right store left and right subtrees*/
    public static class TreeNode {
        private final int value;
        private TreeNode left;
        private TreeNode right;

        TreeNode(int item) {
            value = item;
        }

        public int getValue() {
            return value;
        }

        public TreeNode getLeft() {
            return left;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            TreeNode treeNode = (TreeNode) o;

            return value == treeNode.value;
        }

        @Override
        public String toString() {
            return String.format("TreeNode = %d", this.value);
        }

        public TreeNode getRight() {
            return right;
        }


        /*Traverse tree in preorder*/
        public void preorderTraversal() { //метод для обхода в ширину
            if (this != null) {
                System.out.print(this.getValue() + " ");
                this.left.preorderTraversal();
                this.right.preorderTraversal();
            }
        }

    }

    /* Function to print all ancestors of purposed value
    * @param node - root node
    * @param value - value of the node on which we want to print ancestors
    * @return true, if value exists in this tree, otherwise - false*/
    boolean findAllAncestors(List<TreeNode> list, TreeNode node, int value) {
        //if tree is empty returns false
        if (node == null) {
            return false;
        }

        //if value exist in a tree
        if (node.getValue() == value) {
            return true;
        }

        //if value is present in left/right subtree
        // then we'll print it
        if (findAllAncestors(list, node.left, value) || findAllAncestors(list, node.right, value)) {
            list.add(node);
            return true;
        }

        //else return false
        return false;
    }


    /*Populates tree with the array in order
    * @param array - array which will fill the tree*/
    public void populateTree(int[] array) {
        for (int i = 0; i < array.length; i++) {
            this.insert(array[i]);
        }
    }

    /*@param value - value to insert*/
    public void insert(int value) {
        root = insert(root, value);
    }

    /*Inserts value to the tree
    * @param node - root
    * @param value - value to insert
    * @return root*/
    private static TreeNode insert(TreeNode node, int value) {
        if (node == null) {
            return new TreeNode(value);
        }
        if (value < node.value) {
            node.left = insert(node.left, value);
        } else if (value > node.value) {
            node.right = insert(node.right, value);
        }
        return node;
    }

    /*
    * @param a - first node value
    * @param b - second node value
    * @return lowest common ancestor if both nodes are present
    * in the tree, if one is not present - returns existing node, as LCA
    * if both don't exist - returns null
    * if a key is ancestor of other, then the ancestor key becomes LCA*/
    public TreeNode findLowestCommonAncestor(int a, int b) {
        return findLowestCommonAncestorHelper(root, a, b);
    }

    /*Finds lowest common ancestor of two nodes
    * @param root
    * @param a - first node value
    * @param b - second node value
    * @return lowest common ancestor if both nodes are present
    * in the tree, if one is not present - returns existing node, as LCA
    * if both don't exist - returns null
    * if a key is ancestor of other, then the ancestor key becomes LCA*/
    public TreeNode findLowestCommonAncestorHelper(TreeNode root, int a, int b) {

        // Base case
        if (root == null) {
            return null;
        }

        //if one of values is root - root is LCA
        if (root.value == a || root.value == b) {
            return root;
        }

        // Look for keys in left and right subtrees
        TreeNode rightLCA = findLowestCommonAncestorHelper(root.right, a, b);
        TreeNode leftLCA = findLowestCommonAncestorHelper(root.left, a, b);

        // If both of the above calls return Non-NULL, then one key
        // is present in once subtree and other is present in other,
        // So this node is the LCA
        if (rightLCA != null && leftLCA != null) {
            return root;
        }

        if (leftLCA != null) {
            return leftLCA;
        }

        if (rightLCA != null) {
            return rightLCA;
        }

        return null;
    }
}
