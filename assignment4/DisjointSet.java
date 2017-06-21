package com.katermar.assignment4;

/**
 * Created by katermar on 6/20/2017.
 */
public class DisjointSet {
    private int[] rank;
    private int[] parent;

    public DisjointSet(int n) {
        rank = new int[n];
        parent = new int[n];
        makeSet();
    }

    //Store indexes in an parent array
    public void makeSet() {
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    //Recursive find
    public int find(int x) {
        if (parent[x] != x) {
            return find(parent[x]);
        }
        return x;
    }

    //Unite sets with x and y
    public void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);

        //no need to unit the same elements
        if (xRoot == yRoot) {
            return;
        }

        //join the two sets by pointing the root of one at the root of the other
        if (rank[xRoot] < rank[yRoot]) {
            parent[xRoot] = yRoot;
        } else {
            parent[yRoot] = xRoot;
            if (rank[xRoot] == rank[yRoot]) {
                rank[xRoot] = rank[xRoot] + 1;
            }
        }
    }
}
