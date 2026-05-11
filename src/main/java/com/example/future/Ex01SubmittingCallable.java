package com.example.future;

import java.util.ArrayList;
import java.util.concurrent.*;

public class Ex01SubmittingCallable {

    public static void invokeAll() throws InterruptedException, ExecutionException {
        ExecutorService es = Executors.newFixedThreadPool(4);

        var callables = new ArrayList<Callable<String>>();
        callables.add(() -> {
            Thread.sleep(1000);
            return "A";
        });
        callables.add(() -> {
            Thread.sleep(500);
            return "B";
        });
        callables.add(() -> {
            Thread.sleep(250);
            return "C";
        });
        callables.add(() -> {
            Thread.sleep(1225);
            return "D";
        });

        var futureList = es.invokeAll(callables);
        for (Future<String> stringFuture : futureList) {
          System.out.println(stringFuture.get());
        }

        es.shutdown();
    }

    public static void invokeAny() throws InterruptedException, ExecutionException {
        ExecutorService es = Executors.newFixedThreadPool(8);

        var callables = new ArrayList<Callable<String>>();
        callables.add(() -> {
            Thread.sleep(1000);
            return "A";
        });
        callables.add(() -> {
            Thread.sleep(500);
            return "B";
        });
        callables.add(() -> {
            Thread.sleep(250);
            return "C";
        });
        callables.add(() -> {
            Thread.sleep(125);
            return "D";
        });

        var future = es.invokeAny(callables);
        System.out.println(future);

        es.shutdown();
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //invokeAll();
        invokeAny();
    }
}
