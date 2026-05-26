package com.example.future;


import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

import static java.lang.String.format;


record Deal(List<Long> customers, List<Long> orders) {}
public class Ex04Applicative {
    public static CompletableFuture<List<Long>> getCustomersByRegion(Long regionId) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return Arrays.asList(1L, 2L, 3L);
        });
    }

    public static CompletableFuture<List<Long>> getVendorsByRegion(Long regionId) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return Arrays.asList(4L, 5L, 6L);
        });
    }


    public static CompletableFuture<Deal> fetchActors(Long regionId) {
        return getCustomersByRegion(regionId).thenCompose(customers ->
                getVendorsByRegion(regionId).thenApply(vendors ->
                        new Deal(customers, vendors)
                )
        );
    }

    // 2. Parallel execution (Equivalent to the Scala Applicative map2)
    public static CompletableFuture<Deal> fetchActorsWithApplicative(Long regionId) {
        CompletableFuture<List<Long>> customersFuture = getCustomersByRegion(regionId);
        CompletableFuture<List<Long>> vendorsFuture = getVendorsByRegion(regionId);

        return customersFuture.thenCombine(vendorsFuture, Deal::new);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        var startTime = System.currentTimeMillis();
        //fetchActors(1L).thenAccept(d -> System.out.println(d)).get();
        fetchActorsWithApplicative(1L).thenAccept(d -> System.out.println(d)).get();
        var endTime = System.currentTimeMillis();
        System.out.println(format("Done in %d", endTime - startTime));
    }
}
