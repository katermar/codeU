package com.katermar.assignment3;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Created by katermar on 6/9/2017.
 */
public class WordFinderTest {

    public static void main(String args[]) {
        char grid[][] = {
                {'A', 'A', 'R'},
                {'T', 'C', 'D'}
        };
        Dictionary dictionary = new Dictionary();
        String dictArray[] = {"CAR", "CARD", "CART", "CAT"};
        String prefixArray[] = {"C", "CA", "CAR", "CARD", "CART", "CAT"};
        String expectedResultArray[] = {"CAR", "CARD", "CAT"};
        dictionary.setDictionary(new HashSet<String>(Arrays.asList(dictArray)));
        dictionary.setPrefixes(new HashSet<String>(Arrays.asList(prefixArray)));

        testWordFinder(new HashSet<String>(Arrays.asList(expectedResultArray)), dictionary, grid);
        testWordFinder(new HashSet<String>(), dictionary, grid);
    }

    public static void testWordFinder(HashSet<String> expectedResult, Dictionary dictionary, char grid[][]) {
        WordFinder wordFinder = new WordFinder(dictionary);
        System.out.print(wordFinder.findWords(grid).toString());
        if (wordFinder.findWords(grid).equals(expectedResult)) {
            System.out.println(" <----- Grats! Test PASSED");
        } else {
            System.out.println(" <----- ERROR! Test FAILED");
        }
    }
}
