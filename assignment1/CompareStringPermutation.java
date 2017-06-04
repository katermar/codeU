package com.katermar.assignment1;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by katermar on 5/15/2017.
 */
public class CompareStringPermutation {

    /*
    compare strings method
    @param first - first string
    @param last - second string
    makes character arrays from the strings to sort them
    then compares them
    @return boolean result of equals method
     */
    public boolean compare(String first, String last) {
        char[] a = first.toLowerCase().toCharArray();
        char[] b = last.toLowerCase().toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a, b);
    }
}
