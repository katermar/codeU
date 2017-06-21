package com.katermar.assignment4;

import java.util.Arrays;

/**
 * Created by katermar on 6/21/2017.
 */
public class IslandCounterTest {

    public static void main(String args[]) {
        char map[][] = {{'F', 'T', 'F', 'T'},
                        {'T', 'T', 'F', 'F'},
                        {'F', 'F', 'T', 'F'},
                        {'F', 'F', 'T', 'F'}};
        char emptyArray[][] = {{}, {}};
        testIslandCounter(3, map);
        testIslandCounter(2, map);
        testIslandCounter(0, emptyArray);
    }

    public static void testIslandCounter(int expectedResult, char map[][]) {
        char checkEmpty[][] = new char[map.length][map[0].length];
        if (Arrays.deepEquals(map, checkEmpty)) {
            System.out.println("ERROR! Array is EMPTY! Test FAILED!");
            return;
        }
        IslandCounter islandCounter = new IslandCounter(map);
        System.out.print("Number of islands: " + islandCounter.countIslands());
        if (islandCounter.countIslands() == expectedResult) {
            System.out.println(" <----- Grats! Test PASSED");
        } else {
            System.out.println(" <----- ERROR! Test FAILED");
        }
    }
}
