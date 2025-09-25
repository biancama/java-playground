package com.example.filter;


import java.util.*;
import java.util.stream.Collectors;

public class Ex01 {
    public static List<Task> getTasksWithHigherFrequencyImperative(List<Task> tasks) {
       var map = new HashMap<TYPE, List<Task>>();
        for (Task task : tasks) {
            map.computeIfAbsent(task.type(), t -> new ArrayList<>());
            map.get(task.type()).add(task);
        }
        int maxLength = 0;
        TYPE maxType = TYPE.VIDEO;
        List<Task> res = null;
        for (Map.Entry<TYPE, List<Task>> typeListEntry : map.entrySet()) {
            if (typeListEntry.getValue().size() > maxLength || typeListEntry.getValue().size() == maxLength && typeListEntry.getKey().compareTo(maxType) < 0) {
                maxLength = typeListEntry.getValue().size();
                res = typeListEntry.getValue();
                maxType = typeListEntry.getKey();
            }
        }
        return res;
    }



    public static List<Task> getTasksWithHigherFrequencyFunctional(List<Task> tasks) {
        var map = tasks.stream().collect(Collectors.groupingBy(Task::type));
        var e =  map.entrySet().stream().max(  (entry1, entry2) -> {
            if (entry1.getValue().size() == entry2.getValue().size()) {
                return -1 * entry1.getKey().compareTo(entry2.getKey());
            } else  {
                return entry1.getKey().compareTo(entry2.getKey());
            }
        } );
       return e.get().getValue();
    }
}


