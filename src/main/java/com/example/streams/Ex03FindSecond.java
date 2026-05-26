package com.example.streams;

import java.util.Arrays;
import java.util.Comparator;

public class Ex03FindSecond {


    public static void main(String[] args) {
        var arr = Arrays.asList(4, 2, 6, 1, 8);

        var second =
                arr.stream()
                        .sorted((o1, o2) -> o2 - o1)
                        .skip(1)
                        .findFirst();

        System.out.println(second.get());
    }

}
