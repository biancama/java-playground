package com.example.filter;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class Ex01Test {

    @Test
    public void testEx01Imperative01() {
        var  tasks = Arrays.asList(
                new Task("task01", TYPE.CALL, 53),
                new Task("task02", TYPE.VIDEO, 50),
                new Task("task03", TYPE.VIDEO, 51),
                new Task("task04", TYPE.VIDEO, 43),
                new Task("task05", TYPE.CHAT, 33),
                new Task("task06", TYPE.CHAT, 22)
        );

        var actualLst = Ex01.getTasksWithHigherFrequencyImperative(tasks);

        assertThat(actualLst.stream().map(Task::name).collect(Collectors.toSet())).isEqualTo(Set.of("task02", "task03", "task04"));
    }

    @Test
    public void testEx01Imperative02() {
        var  tasks = Arrays.asList(
                new Task("task01", TYPE.CALL, 53),
                new Task("task07", TYPE.CHAT, 22),
                new Task("task02", TYPE.VIDEO, 50),
                new Task("task03", TYPE.VIDEO, 51),
                new Task("task04", TYPE.VIDEO, 43),
                new Task("task05", TYPE.CHAT, 33),
                new Task("task06", TYPE.CHAT, 22)
        );

        var actualLst = Ex01.getTasksWithHigherFrequencyImperative(tasks);

        assertThat(actualLst.stream().map(Task::name).collect(Collectors.toSet())).isEqualTo(Set.of("task07", "task05", "task06"));
    }


    @Test
    public void testEx01Functional01() {
        var  tasks = Arrays.asList(
                new Task("task01", TYPE.CALL, 53),
                new Task("task02", TYPE.VIDEO, 50),
                new Task("task03", TYPE.VIDEO, 51),
                new Task("task04", TYPE.VIDEO, 43),
                new Task("task05", TYPE.CHAT, 33),
                new Task("task06", TYPE.CHAT, 22)
        );

        var actualLst = Ex01.getTasksWithHigherFrequencyFunctional(tasks);

        assertThat(actualLst.stream().map(Task::name).collect(Collectors.toSet())).isEqualTo(Set.of("task02", "task03", "task04"));
    }

    @Test
    public void testEx01Functional02() {
        var  tasks = Arrays.asList(
                new Task("task01", TYPE.CALL, 53),
                new Task("task07", TYPE.CHAT, 22),
                new Task("task02", TYPE.VIDEO, 50),
                new Task("task03", TYPE.VIDEO, 51),
                new Task("task04", TYPE.VIDEO, 43),
                new Task("task05", TYPE.CHAT, 33),
                new Task("task06", TYPE.CHAT, 22)
        );

        var actualLst = Ex01.getTasksWithHigherFrequencyFunctional(tasks);

        assertThat(actualLst.stream().map(Task::name).collect(Collectors.toSet())).isEqualTo(Set.of("task07", "task05", "task06"));
    }
}
