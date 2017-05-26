package com.katermar;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by katermar on 5/15/2017.
 */
public class CompareStringPermutation {

    public boolean compare(String first, String last) {
        char[] a = first.toLowerCase().toCharArray();
        char[] b = last.toLowerCase().toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a, b);
    }
}
