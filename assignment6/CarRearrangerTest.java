package com.katermar.assignment6;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by katermar on 7/21/2017.
 */
public class CarRearrangerTest {
    public static void main(String[] args) {
        int[] actual = {1, 2, 0, 3};
        int[] result = {3, 1, 2, 0};
        String[] strings = {"move from 0 to 2", "move from 3 to 0", "move from 1 to 3", "move from 2 to 1", "move from 3 to 2"};
        testCarRearranger(Arrays.asList(strings), actual, result);
        testCarRearranger(new LinkedList<String>(), actual, actual);
        testCarRearranger(null, null, result);
        testCarRearranger(null, result, null);
    }

    public static void testCarRearranger(List<String> expectedResult, int[] actual, int[] result) {
        CarRearranger carRearranger = new CarRearranger();
        if (carRearranger.rearrangeCars(actual, result).equals(expectedResult)) {
            if (expectedResult.isEmpty()) {
                System.out.println("No need to rearrange cars <----- Grats! Test PASSED");
            } else {
                System.out.println(" ^----- Grats! Test PASSED");
            }
        } else {
            System.out.println(" ^----- ERROR! Test FAILED");
        }
    }
}
