package com.example.ex01LinkedList;

public class LinkedList<T> {
    private int length;
    private Node<T> head;
    private Node<T> tail;

    class Node<T> {
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
            next = null;
        }
    }

    public void append(T value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public Node<T> removeLast(){
        Node<T> result = null;
        if (length != 0) {
            Node<T> cursor = head;
            while (cursor.next != tail) {
                cursor = cursor.next;
            }
            result = tail;
            cursor.next = null;
            tail = cursor;
        }
        return result;
    }
}
