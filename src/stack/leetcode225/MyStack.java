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
public class MyStack {
    /**
     * The main queue using to store all the elements in the stack
     */
    private Queue<Integer> q1;
    /**
     * The auxiliary queue using to implement `pop` operation
     */
    private Queue<Integer> q2;
    /**
     * The top element in the stack
     */
    private int top;

    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        top = x;
        q1.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (q1.size() == 0) {
            throw new NoSuchElementException("[ERROR] The stack is empty!");
        }

        while (q1.size() > 1) {
            top = q1.remove();
            q2.add(top);
        }
        int res = q1.remove();

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return res;
    }

    /** Get the top element. */
    public int top() {
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
