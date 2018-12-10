package stack.leetcode225;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * This is the solution of No. 225 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/implement-stack-using-queues/
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2018/12/02
 */
public class MyStack3 {
    private Queue<Integer> queue;

    /** Initialize your data structure here. */
    public MyStack3() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
        for (int i = 0; i < queue.size() - 1; ++i) {
            queue.add(queue.remove());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (queue.isEmpty()) {
            throw new NoSuchElementException("[ERROR] The stack is empty!");
        }

        return queue.remove();
    }

    /** Get the top element. */
    public int top() {
        if (queue.isEmpty()) {
            throw new NoSuchElementException("[ERROR] The stack is empty!");
        }

        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        MyStack3 stack = new MyStack3();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
