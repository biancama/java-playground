package com.example.ex03Queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Ex01ParenthesesBalanced {

    public static boolean isBalancedParentheses(String check) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < check.length(); i++) {
            var c = check.charAt(i);
            if (c == '(') {
                stack.addFirst(c);
            } else { // c == ) )
                if(!stack.isEmpty() && stack.getLast() == '(') {
                    stack.removeLast();
                } else {
                    return false;
                }
            }
        }
        if (stack.size() == 0)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        System.out.println(Ex01ParenthesesBalanced.isBalancedParentheses(")"));
    }
}
