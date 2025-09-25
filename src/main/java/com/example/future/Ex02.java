package com.example.future;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

import static java.lang.String.format;

public class Ex02 {

    public static CompletableFuture<Person> savePerson(Person person) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CompletableFuture<Person> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(format("[%s] Saved %s", Thread.currentThread().getName(), person.name()));
            return person;
        }, executorService);

        return future;
    }

    public static CompletableFuture<List<Person>> savePersons(List<Person> persons) {
        var futures = persons.stream().map(p -> savePerson(p)).collect(Collectors.toList());

        return CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenApply(v -> futures.stream().map(CompletableFuture::join).collect(Collectors.toList()));
    }

    public static void main(String[] args) {
        Person massimo = new Person("massimo", 35);
        Person pablo = new Person("pablo", 25);

        //savePerson(massimo).join();

        savePersons(Arrays.asList(massimo, pablo)).join();
        System.out.println("Saved");
        System.exit(0);
    }

}

record Person(String name, Integer age) {}
