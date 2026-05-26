package com.example.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class Ex03VirtualThread {

    private static void handleUserRequest() {
        System.out.println("Starting thread: " + Thread.currentThread());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Ending thread: " + Thread.currentThread());

    }
    public static void createSimple() throws InterruptedException {
        var thread = Thread.startVirtualThread(Ex03VirtualThread::handleUserRequest);
        thread.join();
    }

    public static void createWithBuilder() throws InterruptedException, ExecutionException {
        var thread = Thread.ofVirtual().name("userthread", 0).factory();
        try(ExecutorService es = Executors.newThreadPerTaskExecutor(thread)) {
            es.submit(Ex03VirtualThread::handleUserRequest);
            es.submit(Ex03VirtualThread::handleUserRequest);
        }
    }

    public static void createWithCompletableFuture() throws InterruptedException, ExecutionException {
        var thread = Thread.ofVirtual().name("userthread", 0).factory();
        try(ExecutorService es = Executors.newThreadPerTaskExecutor(thread)) {
            String output = CompletableFuture.supplyAsync(() -> "test", es)
                    .thenCombine(CompletableFuture.supplyAsync(() -> "", es), (res1, res2) -> {
                        return "[" + res1 + ", " + res2 + "]";
                    }).join();
            System.out.println(output);
        }
    }


    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //ExecutorService es = Executors.newFixedThreadPool(8);
        //createSimple();
        createWithBuilder();
        //es.shutdown();
    }
}
