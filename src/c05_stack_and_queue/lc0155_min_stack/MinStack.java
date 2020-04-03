package c05_stack_and_queue.lc0155_min_stack;

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
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class MinStack {
    private Stack<Integer> stack;
    private int minElem;

    /** initialize your data structure here. */
    public MinStack() {
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
        if (stack.pop() == minElem) {
            minElem = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minElem;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // -3
        minStack.pop();
        System.out.println(minStack.top());  // 0
        System.out.println(minStack.getMin()); // -2
    }
}