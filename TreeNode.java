package com.katermar.assignment1;

/**
 * Created by katermar on 5/23/2017.
 */
public class TreeNode {
    private int value;
    private TreeNode left, right, nextRight;

    TreeNode(int item) {
        value = item;
        left = right = nextRight = null;
    }

    public int getValue() {
        return value;
    }

    public TreeNode getLeft() {
        return left;
    }
    public TreeNode getRight() {
        return right;
    }

    public TreeNode getNextRight() {
        return nextRight;
    }
}
