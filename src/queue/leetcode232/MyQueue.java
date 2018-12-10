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
public class MyQueue {
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s1.push(x);
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (s1.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] The queue is empty!");
        }

        return s1.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (s1.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] The queue is empty!");
        }

        return s1.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty();
    }

    public static void main(String[] args) {
        int n = 10000;
        MyQueue queue = new MyQueue();
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
