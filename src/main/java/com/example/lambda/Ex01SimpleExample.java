package com.example.lambda;

@FunctionalInterface
interface MyInterface{
    void m();
}

public class Ex01SimpleExample {
    public static void main(String[] args) {

        MyInterface i = () -> System.out.println("Hello World");

        i.m();

    }
}
