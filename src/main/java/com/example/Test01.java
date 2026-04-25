package com.example;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test01 {
    public static record Channel(String uniqueName, int capacity) {}



    public static void main(String[] args) {
        var channels = List.of(new Channel("pippo", 1), new Channel("pluto", 1), new Channel("pippo", 3));
        Map<String, Integer> allowedChannels = channels.stream()
                .collect(Collectors.toMap(
                        wc -> wc.uniqueName(),
                        Channel::capacity
                ));

        System.out.println(allowedChannels);
    }
    
}
