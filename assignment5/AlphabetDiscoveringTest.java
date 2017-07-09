package com.katermar.assignment5;

import java.util.Arrays;
import java.util.List;

/**
 * Created by USER on 7/8/2017.
 */
public class AlphabetDiscoveringTest {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("art", "rat", "cat", "car");
        List<Character> expectedResult = Arrays.asList('t', 'a', 'r', 'c');
        testAlphabetDiscovering(expectedResult, words);
    }

    public static void testAlphabetDiscovering(List<Character> expectedResult, List<String> words) {
        AlphabetDiscovering.Ordering partialOrdering = AlphabetDiscovering.Ordering.seedWords(words);
        System.out.print("Discovered Alphabet: " + partialOrdering.topologicalOrdering());
        if (partialOrdering.topologicalOrdering().equals(expectedResult)) {
            System.out.println(" <----- Grats! Test PASSED");
        } else {
            System.out.println(" <----- ERROR! Test FAILED");
        }
    }
}
