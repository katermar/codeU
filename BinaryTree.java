package com.katermar;

/**
 * Created by katermar on 5/23/2017.
 */
public class BinaryTree {
    TreeNode root;

    /*Inner class for Binary Tree node
    * @field value stores integer value
    * @field left, right store left and right subtrees*/
    public static class TreeNode {
        private int value;
        private TreeNode left, right;

        TreeNode(int item) {
            value = item;
            left = right = null;
        }

        public int getValue() {
            return value;
        }

        public TreeNode getLeft() {
            return left;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "value=" + value +
                    '}';
        }

        public TreeNode getRight() {
            return right;
        }

    }

    /* Function to print all ancestors of purposed value
    * @param node - root node
    * @param value - value of the node on which we want to print ancestors
    * @return true, if value exists in this tree, otherwise - false*/
    boolean printAllAncestors(TreeNode node, int value)
    {
         //if tree is empty returns false
        if (node == null)
            return false;

        //if value exist in a tree
        if (node.getValue() == value)
            return true;

        //if value is present in left/right subtree
        // then we'll print it
        if (printAllAncestors(node.left, value) || printAllAncestors(node.right, value))
        {
            System.out.print(node.value + " ");
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
        if (root == null) return null;

        //if one of values is root - root is LCA
        if (root.value == a || root.value == b)
            return root;

        // Look for keys in left and right subtrees
        TreeNode rightLCA = findLowestCommonAncestor(root.right, a, b);
        TreeNode leftLCA  = findLowestCommonAncestor(root.left, a, b);

        // If both of the above calls return Non-NULL, then one key
        // is present in once subtree and other is present in other,
        // So this node is the LCA
        if (rightLCA != null && leftLCA != null)  return root;

        if (leftLCA != null) return leftLCA;
        if (rightLCA != null) return rightLCA;

        return null;
    }

    /* Driver program to test above functions */
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
        tree.preorderTraversal(tree.root);
        System.out.println();

        if (!tree.printAllAncestors(tree.root, 4))
            System.out.println("Element doesn't exist");

        System.out.println();
        System.out.println(tree.findLowestCommonAncestor(tree.root, 4, 10));
    }
}
