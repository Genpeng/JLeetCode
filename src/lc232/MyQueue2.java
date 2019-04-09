package lc232;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * This is the solution of No. 232 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/implement-queue-using-stacks/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Implement the following operations of a queue using stacks.
 *
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 *
 * Example:
 * MyQueue1 queue = new MyQueue1();
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // returns 1
 * queue.pop();   // returns 1
 * queue.empty(); // returns false
 *
 * Notes:
 * - You must use only standard operations of a stack -- which means only push to top,
 *   peek/pop from top, size, and is empty operations are valid.
 * - Depending on your language, stack may not be supported natively. You may simulate a stack by
 *   using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
 * - You may assume that all operations are valid (for example, no pop or peek operations
 *   will be called on an empty queue).
 * ==========================================================================================================
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2019/04/09
 */
public class MyQueue2<E> {
    /**
     * The input stack
     */
    private Stack<E> inStack;
    /**
     * The output stack
     */
    private Stack<E> outStack;
    /**
     * The the head of the queue in the input stack
     */
    private E front;

    /** Initialize your data structure here. */
    public MyQueue2() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(E e) {
        if (inStack.isEmpty()) {
            front = e;
        }
        inStack.push(e);
    }

    /** Removes the element from in front of queue and returns that element. */
    public E pop() {
        if (empty()) {
            throw new NoSuchElementException("[ERROR] The queue is empty!!!");
        }
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }

    /** Get the front element. */
    public E peek() {
        if (empty()) {
            throw new NoSuchElementException("[ERROR] The queue is empty!!!");
        }
        return outStack.isEmpty() ? front : outStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue2<Integer> myQueue = new MyQueue2<>();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
    }
}

