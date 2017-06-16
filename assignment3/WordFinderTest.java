package com.katermar.assignment3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by katermar on 6/9/2017.
 */
public class WordFinderTest {

    public static void main(String args[]) {
        char grid[][] = {
                {'A', 'A', 'R'},
                {'T', 'C', 'D'}
        };
        String dictArray[] = {"CAR", "CARD", "CART", "CAT"};
//        String prefixArray[] = {"C", "CA", "CAR", "CARD", "CART", "CAT"};
        Dictionary dictionary = new Dictionary(dictArray);
        String expectedResultArray[] = {"CAR", "CARD", "CAT"};

        testWordFinder(new HashSet<String>(Arrays.asList(expectedResultArray)), dictionary, grid);
        testWordFinder(new HashSet<String>(), dictionary, grid);
        char emptyGrid[][] = {{}, {}};
        testWordFinder(new HashSet<String>(Arrays.asList(expectedResultArray)), dictionary, emptyGrid);
    }

    public static void testWordFinder(HashSet<String> expectedResult, Dictionary dictionary, char grid[][]) {
        WordFinder wordFinder = new WordFinder(dictionary);
        if (wordFinder.findWords(grid) == null) {
            System.out.println("No Words found <----- ERROR! Test FAILED");
            return;
        }
        System.out.print(wordFinder.findWords(grid).toString());
        if (wordFinder.findWords(grid).equals(expectedResult)) {
            System.out.println(" <----- Grats! Test PASSED");
        } else {
            System.out.println(" <----- ERROR! Test FAILED");
        }
    }
}
