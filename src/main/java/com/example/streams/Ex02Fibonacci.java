package com.example.streams;

import java.math.BigInteger;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class Ex02Fibonacci {

    public static void main(String[] args) {

        var fib = Stream.iterate(new BigInteger[]{BigInteger.ZERO, BigInteger.ONE},
                arr -> new BigInteger[]{arr[1], arr[1].add(arr[0])}
        );




        fib.limit(7).forEach( arr -> System.out.println(arr[0]));
    }

}
