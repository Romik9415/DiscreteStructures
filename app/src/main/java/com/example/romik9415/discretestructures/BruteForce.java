package com.example.romik9415.discretestructures;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BruteForce {

    final int min;
    final int max;
    final int stringLength;

    /**
     * One more element than <i>stringLength</i>,
     * to efficiently check for overflow.
     */
    private final int[] chars;

    public BruteForce(int min, int  max, int len) {
        this.min = min;
        this.max = max;
        this.stringLength = len;

        chars = new int[stringLength + 1];
        Arrays.fill(chars, 1, chars.length, min);
    }

    public List<int[]> getBruteforceList() {
        List<int[]> res = new ArrayList<>();

        while (chars[0] == 0) {
            //print();
            increment();
            res.add(chars.clone());
        }
        return res;
    }

    private void increment() {
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] < max) {
                chars[i]++;
                return;
            }
            chars[i] = min;
        }
    }

    private void print() {
        //for (int i = 1; i < chars.length; i++) {
        //    (char) chars[i];
        //}
        Log.d("C_BF",Arrays.toString(chars));
        //System.out.println();
    }
}
