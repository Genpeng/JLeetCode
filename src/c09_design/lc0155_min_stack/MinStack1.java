package c09_design.lc0155_min_stack;

import java.util.EmptyStackException;
import java.util.Stack;

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
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class MinStack1 {
    private Stack<Integer> stack;
    private int minElem;

    /** initialize your data structure here. */
    public MinStack1() {
        stack = new Stack<>();
        minElem = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if (x <= minElem) {
            stack.push(minElem);
            minElem = x;
        }
        stack.push(x);
    }

    public void pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        if (stack.pop() == minElem) {
            minElem = stack.pop();
        }
    }

    public int top() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.peek();
    }

    public int getMin() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return minElem;
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        MinStack1 minStack = new MinStack1();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // -3
        minStack.pop();
        System.out.println(minStack.top());  // 0
        System.out.println(minStack.getMin()); // -2
    }
}