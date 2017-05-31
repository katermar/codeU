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
        public String toString() {
            return String.format("TreeNode = %d", this.value);
        }

        public TreeNode getRight() {
            return right;
        }

    }

    /* Function to print all ancestors of purposed value
    * @param node - root node
    * @param value - value of the node on which we want to print ancestors
    * @return true, if value exists in this tree, otherwise - false*/
    boolean findAllAncestors(List<TreeNode> list, TreeNode node, int value)
    {
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

    /*Traverse tree in preorder
    * @param root - tree root*/
    public void preorderTraversal (TreeNode root){ //метод для обхода в ширину
        if (root != null){
            System.out.print(root.getValue() + " ");
            preorderTraversal (root.left);
            preorderTraversal (root.right);
        }
    }

    /*Populates tree with the array in order
    * @param array - array which will fill the tree*/
    public boolean populateTree(int[] array) {
        for (int i = 0; i < array.length; i++) {
            this.insert(array[i]);
        }

        return true;
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

    /*Finds lowest common ancestor of two nodes
    * @param root
    * @param a - first node value
    * @param b - second node value
    * @return lowest common ancestor if both nodes are present
    * in the tree, if one is not present - returns existing node, as LCA
    * if both don't exist - returns null
    * if a key is ancestor of other, then the ancestor key becomes LCA*/
    public TreeNode findLowestCommonAncestor(TreeNode root, int a, int b) {

        // Base case
        if (root == null) {
            return null;
        }

        //if one of values is root - root is LCA
        if (root.value == a || root.value == b) {
            return root;
        }

        // Look for keys in left and right subtrees
        TreeNode rightLCA = findLowestCommonAncestor(root.right, a, b);
        TreeNode leftLCA  = findLowestCommonAncestor(root.left, a, b);

        // If both of the above calls return Non-NULL, then one key
        // is present in once subtree and other is present in other,
        // So this node is the LCA
        if (rightLCA != null && leftLCA != null)  {
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

//    /* Driver program to test above functions */
//    public static void main(String args[])
//    {
//        BinaryTree tree = new BinaryTree();
//
//        /* Construct the following binary tree
//                  2
//                /   \
//               1     4
//                    /  \
//                   3    5
//                         \
//                          7
//        */
//        int[] array = {2, 1, 4, 3, 5, 7};
//        tree.populateTree(array);
//        System.out.println();
//
//        List<TreeNode> ancestorList = new LinkedList<>();
//        if (!tree.findAllAncestors(ancestorList, tree.root, 7)) {
//            System.out.println("Element doesn't exist");
//        } else {
//            System.out.println("Ancestors - " + ancestorList);
//        }
//
//        System.out.println();
//        System.out.print(tree.findLCAtest(7, 3));
//    }
//
//    public String findLCAtest(int a, int b) {
//
//        TreeNode LCA = this.findLowestCommonAncestor(this.root, a, b);
//        if (LCA == null) {
//            return "Tree or both of nodes don't exist";
//        }
//        if (LCA.getValue() == a || LCA.getValue() == b) {
//            return LCA + " - One of the nodes is LCA";
//        }
//        if (LCA.getValue() == this.root.getValue()) {
//            return LCA + " - LCA is a root";
//        }
//        else {
//            return LCA + " - is LCA";
//        }
//    }
}
