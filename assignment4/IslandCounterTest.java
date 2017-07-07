package com.katermar.assignment4;

import java.util.Arrays;

/**
 * Created by katermar on 6/21/2017.
 */
public class IslandCounterTest {

    public static void main(String args[]) {
        boolean map[][] = {{false, true, false, true},
                        {true, true, false, false},
                        {false, false, true, false},
                        {false, false, true, false}};
        boolean emptyArray[][] = {{}, {}};
        boolean moreEmptyArray[][] = {};
        testIslandCounter(3, map);
        testIslandCounter(0, emptyArray);
        testIslandCounter(0, moreEmptyArray);
    }

    public static void testIslandCounter(int expectedResult, boolean map[][]) {

        if (map.length == 0 || map[0].length == 0) {
            System.out.println("ERROR! Array is EMPTY! ");
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
