package c05_stack_and_queue.lc0232_implement_queue_using_stacks;

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
 * MyQueue queue = new MyQueue();
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // returns 1
 * queue.pop();   // returns 1
 * queue.empty(); // returns false
 *
 * Notes:
 * - You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size,
 *   and is empty operations are valid.
 * - Depending on your language, stack may not be supported natively. You may simulate a stack by using a list
 *   or deque (double-ended queue), as long as you use only standard operations of a stack.
 * - You may assume that all operations are valid (for example, no pop or peek operations will be
 *   called on an empty queue).
 * ==========================================================================================================
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2019/04/09
 */
public class MyQueue1<E> {
    /**
     * The main stack for storing elements
     */
    private Stack<E> s1;
    /**
     * The auxiliary stack for adjusting the order of elements
     */
    private Stack<E> s2;

    /** Initialize your data structure here. */
    public MyQueue1() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(E e) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s1.push(e);
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public E pop() {
        if (empty()) {
            throw new NoSuchElementException("[ERROR] The queue is empty!!!");
        }
        return s1.pop();
    }

    /** Get the front element. */
    public E peek() {
        if (empty()) {
            throw new NoSuchElementException("[ERROR] The queue is empty!!!");
        }
        return s1.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue1<Integer> myQueue = new MyQueue1<>();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
    }
}

