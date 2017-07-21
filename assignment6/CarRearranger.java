package com.katermar.assignment6;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by katermar on 7/21/2017.
 */
public class CarRearranger {
    //List of messages just for testing
    private final LinkedList<String> resultMessages = new LinkedList<>();

    /*
     * Method to rearrange the actual array of cars to look like result array
     * ----------------------------------------------------------------------
     * @param actual -- given array of cars
     * @param result -- result array of car how they have to stand
     * ----------------------------------------------------------------------
     * @return list of printed messages
     * ----------------------------------------------------------------------
     */
    public LinkedList<String> rearrangeCars(int[] actual, int[] result) {
        Map<Integer, Integer> actualMap = makeIndexMap(actual);

        if (actual.length == 0) {
            throw new IllegalArgumentException("Actual array is empty. No cars can be rearranged.");
        }

        if (result.length == 0) {
            throw new IllegalArgumentException("Result array is empty. No possible rearranging can be done.");
        }

        // if actual array already looks like result there is no need to rearrange the cars
        if (actual.equals(result)) {
            return resultMessages;
        }

        for (int i = 0; i < actual.length; i++) {
            // if current car isn't at the result place
            if (actualMap.get(i) != result[i]) {
                // if the current place isn't empty make it empty and print the swap
                if (actual[i] != 0) {
                    int emptyPlace = actualMap.get(0);

                    actualMap.put(actual[i], emptyPlace);
                    actual[emptyPlace] = actual[i];

                    actualMap.put(0, i);
                    actual[i] = 0;

                    printSwap(i, emptyPlace);
                }
                // swap car, which have to stand at the current place
                int resultPlace = actualMap.get(result[i]);

                actualMap.put(0, resultPlace);
                actual[resultPlace] = 0;

                actualMap.put(result[i], i);
                actual[i] = result[i];

                printSwap(resultPlace, i);
            }
        }

        return resultMessages;
    }

    /*
     * method to make an index map
     * ------------------------------------------------------
     * @param array -- given array
     * ------------------------------------------------------
     * @return map where value is a key and index is a value
     * ------------------------------------------------------
     */
    private Map<Integer, Integer> makeIndexMap(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], i);
        }
        return map;
    }

    /*
     * Prints a swap and stores printed massage in the list of messages
     * -----------------------------------------------------------------
     * @param from
     * @param to
     */
    private void printSwap(int from, int to) {
        System.out.printf("move from %d to %d\n", from, to);
        resultMessages.add("move from " + from + " to " + to);
    }
}
