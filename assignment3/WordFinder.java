package com.katermar.assignment3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by katermar on 6/8/2017.
 */

/*
class WordFinder to find words in a char grid
 */
public class WordFinder {
    private Dictionary dictionary;

    public WordFinder(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

    public void setDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    /*A recursive helper function that finds all words in a char grid
      using dictionary, acts like DFS
      --------------------------------------------------------
      @param result     -- set to collect found words
      @param grid       -- char grid
      @param visited    -- 2dim boolean array of visited cells
      @param i          -- i-th row
      @param j          -- j-th column
      @param sample     -- string to find
      --------------------------------------------------------
     */
    public void findWordsHelper(Set<String> result, char grid[][], boolean visited[][],
                                int i, int j, String sample) {

        // check current cell as visited and append current character
        visited[i][j] = true;
        sample = sample + grid[i][j];


        // if sample is present in dictionary, then add it into result set
        if (dictionary.isWord(sample)) {
            result.add(sample);
        }

        // here we are traversing through 8 adjacent cells of grid[i][j]
        for (int row = i - 1; row <= i + 1 && row < visited.length; row++) {
            for (int col = j - 1; col <= j + 1 && col < visited[0].length; col++) {
                if (row >= 0 && col >= 0 && !visited[row][col] && dictionary.isPrefix(sample)) {
                    findWordsHelper(result, grid, visited, row, col, sample);
                }
            }
        }

        // delete character from string and mark visited
        // of current cell as false
        sample = sample.substring(0, sample.length() - 1);
        visited[i][j] = false;
    }

    /*A recursive function that finds all words in a char grid
      using dictionary, acts like DFS
      --------------------------------------------------------
      @param grid       -- char grid
      --------------------------------------------------------
      @return result set of words
     */
    public Set<String> findWords(char grid[][]) {
        //initialize array, which marks all cells non-visited by default
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        HashSet<String> result = new HashSet<>();
        String sample = "";

        //looks through all the characters in a grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                findWordsHelper(result, grid, visited, i, j, sample);
            }
        }
        return result;
    }
}

