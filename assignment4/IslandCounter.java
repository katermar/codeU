package com.katermar.assignment4;

/**
 * Created by katermar on 6/21/2017.
 */
public class IslandCounter {
    private final boolean map[][];

    public IslandCounter(boolean[][] map) {
        this.map = map;
    }

    /*counts number of islands in an array
    @return number of islands
    */
    public int countIslands() {
        if (map.length == 0) {
            return 0;
        }

        int row = map.length;
        int column = map[0].length;

        DisjointSet disjointSet = new DisjointSet(row * column);

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                // If cell water we don't need to union it with something
                if (map[i][j] == false) {
                    continue;
                }
                int current = i * column + j;
                //check 4 neighbors and union, if it is land
                if (i + 1 < row && map[i + 1][j] == true) {
                    disjointSet.union(calculateKey(i+1, j, column), current);
                }
                if (i - 1 >= 0 && map[i - 1][j] == true) {
                    disjointSet.union(calculateKey(i-1, j, column), current);
                }
                if (j + 1 < column && map[i][j + 1] == true) {
                    disjointSet.union(calculateKey(i, j+1, column), current);
                }
                if (j - 1 >= 0 && map[i][j - 1] == true) {
                    disjointSet.union(calculateKey(i, j-1, column), current);
                }
            }
        }
        int[] frequencyOfSets = new int[column * row];
        int numberOfIslands = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (map[i][j] == true) {
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

    private int calculateKey(int i, int j, int column) {
        return i* column + j;
    }
}
