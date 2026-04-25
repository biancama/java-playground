package com.example.streams;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.lang.String.format;

record Cat(String name, Integer age){}

public class Ex01StreamOnFiles {

    public static void main(String[] args) throws URISyntaxException, IOException {
        var uri = Ex01StreamOnFiles.class.getClassLoader().getResource("Cats.txt").toURI();

        Files.lines(Path.of(uri))
                .forEach(line -> {
                        var entry = line.split("/");
                        var c = new Cat(entry[0], Integer.valueOf(entry[1]));
                            System.out.println(format("Cat: %s", c));
                        });

    }
}
