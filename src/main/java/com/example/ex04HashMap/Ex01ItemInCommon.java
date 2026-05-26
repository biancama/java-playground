package com.example.ex04HashMap;

import java.util.HashSet;
import java.util.Set;

public class Ex01ItemInCommon {

    public static boolean itemInCommon(int[] array1, int[] array2){
        Set<Integer> set = new HashSet<>();
        for (int i : array1) {
            set.add(i);
        }
        for (int i: array2) {
            if (set.contains(i)) {
                return true;
            }
        }
        return false;
    }
}
