package com.example.filter;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return null;
    }
}


