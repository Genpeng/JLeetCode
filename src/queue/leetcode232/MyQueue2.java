package queue.leetcode232;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

/**
 * This is the solution of No. 232 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/implement-queue-using-stacks/
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2018/11/29
 */
public class MyQueue2 {
    /**
     * The stack used to implement enqueue functionality
     */
    private Stack<Integer> inStack;
    /**
     * The stack used to implement dequeue functionality
     */
    private Stack<Integer> outStack;
    /**
     * The front element in the stack `inStack` 's queue
     */
    private int front;

    /** Initialize your data structure here. */
    public MyQueue2() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (inStack.empty()) {
            front = x;
        }
        inStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (empty()) {
            throw new IllegalArgumentException("[ERROR] The queue is empty!");
        }

        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (empty()) {
            throw new IllegalArgumentException("[ERROR] The queue is empty!");
        }

        if (!outStack.isEmpty()) {
            return outStack.peek();
        } else {
            return front;
        }
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    public static void main(String[] args) {
        int n = 10000;
        MyQueue2 queue = new MyQueue2();
        Random random = new Random();

        long startTime = System.nanoTime();

        for (int i = 0; i < n; ++i) {
            queue.push(random.nextInt(Integer.MAX_VALUE));
        }

        List<Integer> res = new LinkedList<>();
        while (!queue.empty()) {
            res.add(queue.pop());
        }

        long endTime = System.nanoTime();
        System.out.format("The time consumed is %f seconds.", (endTime - startTime) / 1000000000.0);
    }
}
