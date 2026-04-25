package com.example.lambda;

interface MyPredicate<T> {
    boolean evaluate(T elem);
}
public class Ex02MyPredicate {




    public static void main(String[] args) {
        MyPredicate<Integer> myPredicate = elem -> {
            return elem%2 == 0;
        };

        var p =  myPredicate.evaluate(10);
        System.out.println(p);
    }


}
