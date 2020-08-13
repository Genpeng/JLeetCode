package c09_design.lc0155_min_stack;

import java.util.EmptyStackException;

/**
 * This is the solution of No. 155 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/min-stack/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *
 * Example:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 * ==========================================================================================================
 *
 * Difficulty: Easy
 * Tags: design;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class MinStack2 {
    private int size;
    private Node top;

    /** initialize your data structure here. */
    public MinStack2() {
        size = 0;
        top = null;
    }

    public void push(int x) {
        if (top == null) {
            top = new Node(x, x);
        } else {
            top = new Node(x, Math.min(x, top.min), top);
        }
        ++size;
    }

    public void pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        top = top.next;
        --size;
    }

    public int top() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.val;
    }

    public int getMin() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.min;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    class Node {
        int val, min;
        Node next;

        Node(int val, int min) {
            this(val, min, null);
        }

        Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        MinStack2 minStack = new MinStack2();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // -3
        minStack.pop();
        System.out.println(minStack.top());  // 0
        System.out.println(minStack.getMin()); // -2
    }
}