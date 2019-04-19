package stack_and_queue.lc0225_implement_stack_using_queues;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * This is the solution of No. 225 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/implement-stack-using-queues/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Implement the following operations of a stack_and_queue using queues.
 * push(x) -- Push element x onto stack_and_queue.
 * pop() -- Removes the element on top of the stack_and_queue.
 * top() -- Get the top element.
 * empty() -- Return whether the stack_and_queue is empty.
 *
 * Example:
 * MyStack stack_and_queue = new MyStack();
 * stack_and_queue.push(1);
 * stack_and_queue.push(2);
 * stack_and_queue.top();   // returns 2
 * stack_and_queue.pop();   // returns 2
 * stack_and_queue.empty(); // returns false
 *
 * Notes:
 * - You must use only standard operations of a queue -- which means only push to back,
 *   peek/pop from front, size, and is empty operations are valid.
 * - Depending on your language, queue may not be supported natively. You may simulate a queue
 *   by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
 * - You may assume that all operations are valid (for example, no pop or top operations
 *   will be called on an empty stack_and_queue).
 * ==========================================================================================================
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2019/04/08
 */
public class MyStack1<E> {
    /**
     * The main queue for storing elements.
     */
    private Queue<E> q1;
    /**
     * The auxiliary queue for popping a element from stack_and_queue top.
     */
    private Queue<E> q2;
    /**
     * Tail of the queue, which is the stack_and_queue top element.
     */
    private E top;

    /** Initialize your data structure here. */
    public MyStack1() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    /** Push element x onto stack_and_queue. */
    public void push(E e) {
        top = e;
        q1.add(e);
    }

    /** Removes the element on top of the stack_and_queue and returns that element. */
    public E pop() {
        if (empty()) {
            throw new EmptyStackException();
        }

        E ret;
        if (q1.size() == 1) {
            ret = q1.remove();
            top = null;
        } else {
            while (q1.size() > 1) {
                top = q1.remove();
                q2.add(top);
            }
            ret = q1.remove();
        }
        // swap two references
        Queue<E> tmp = q1;
        q1 = q2;
        q2 = tmp;
        return ret;
    }

    /** Get the top element. */
    public E top() {
        if (empty()) {
            throw new EmptyStackException();
        }
        return top;
    }

    /** Returns whether the stack_and_queue is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        MyStack1<Integer> myStack = new MyStack1<>();
        myStack.push(1);
        System.out.println(myStack.pop());
        System.out.println(myStack.top());
    }
}
