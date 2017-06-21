package com.katermar.assignment4;

/**
 * Created by katermar on 6/21/2017.
 */
public class IslandCounter {
    private char a[][];

    public IslandCounter(char[][] a) {
        this.a = a;
    }

    /*counts number of islands in an array
    @return number of islands
    */
    public int countIslands() {
        int row = a.length;
        int column = a[0].length;

        DisjointSet disjointSet = new DisjointSet(row * column);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                // If cell water we don't need to union it with something
                if (a[i][j] == 'F') {
                    continue;
                }
                int current = i * column + j;
                //check 4 neighbors and union, if it is land
                if (i + 1 < row && a[i + 1][j] == 'T') {
                    disjointSet.union((i + 1) * column + j, current);
                }
                if (i - 1 >= 0 && a[i - 1][j] == 'T') {
                    disjointSet.union((i - 1) * column + j, current);
                }
                if (j + 1 < column && a[i][j + 1] == 'T') {
                    disjointSet.union(i * column + (j + 1), current);
                }
                if (j - 1 >= 0 && a[i][j - 1] == 'T') {
                    disjointSet.union(j * column + (j - 1), current);
                }
            }
        }
        int[] frequencyOfSets = new int[column * row];
        int numberOfIslands = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (a[i][j] == 'T') {
                    int place = disjointSet.find(i * column + j);

                    if (frequencyOfSets[place] == 0) {
                        numberOfIslands++;
                        frequencyOfSets[place]++;
                    }
                }
            }
        }
        return numberOfIslands;
    }
}
