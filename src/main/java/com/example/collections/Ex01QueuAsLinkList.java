package com.example.collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Ex01QueuAsLinkList {

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);   // Head-> [1]
        queue.offer(2); // Head-> [1, 2]
        queue.add(3);   // Head-> [1, 2, 3]
        queue.offer(4); // Head-> [1, 2, 3, 4]
        // element() retrieves but does not remove the head of the queue (throws exception if queue empty)
        // peek() retrieves but does not remove the head of the queue (returns null if queue empty)
        System.out.println(queue.element());// 1
        System.out.println(queue.peek());   // 1
        System.out.println(queue);          // [1, 2, 3, 4]
        // remove() - Retrieves and removes the head of this queue (throws exception if queue empty)
        // poll() - Retrieves and removes the head of this queue (returns null if this queue is empty)
        System.out.println(queue.remove()); // 1   Head-> [2, 3, 4]
        System.out.println(queue.poll());   // 2   Head-> [3, 4]
        System.out.println(queue);          // [3, 4]

        Deque<Integer> deque =  new ArrayDeque<>();
        deque.offer(1);
        deque.offerFirst(2);
        deque.offerLast(4);

        deque.pollFirst();


    }
}
