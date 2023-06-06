package c02_string.lc0020_valid_parentheses;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * This is the solution of No. 20 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/valid-parentheses/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 *
 * An input string is valid if:
 * - Open brackets must be closed by the same type of brackets.
 * - Open brackets must be closed in the correct order.
 *
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 * Input: "()"
 * Output: true
 *
 * Example 2:
 * Input: "()[]{}"
 * Output: true
 *
 * Example 3:
 * Input: "(]"
 * Output: false
 *
 * Example 4:
 * Input: "([)]"
 * Output: false
 *
 * Example 5:
 * Input: "{[]}"
 * Output: true
 * ==========================================================================================================
 *
 * Tags: string;stack;
 *
 * @author Genpeng Xu (xgp1227atgmai.com)
 */
public class Solution1 {
    /**
     * All possible scenarios are shown below:
     *
     * - left brackets (push)
     *
     *                  |- stack is empty (return false)
     *                  |
     * - right brackets |
     *                  |                     |- two characters is same (pop)
     *                  |- stack is not empty |
     *                                        |- two characters is different (return false)
     *
     * @param s String, the input string
     * @return boolean, true if the input string is valid
     */
    public boolean isValid(String s) {
        if (s == null) {
            throw new IllegalArgumentException("[ERROR] The input string is null!!!");
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    /**
     * Approach 1: Stack
     * Iterate the string from left to right, if current character in open brackets, then push corresponding
     * close bracket into the stack; otherwise, if current character is close bracket, then pop the stack,
     * and find if two character is same
     *
     * Complexity Analysis:
     * - Time Complexity: O(L)
     * - Space Complexity: O(L)
     * where L represents the length of the string
     *
     * @param s String, the input string
     * @return boolean, true if the input string is valid
     */
    public boolean isValidV2(String s) {
        if (s == null) {
            throw new IllegalArgumentException("input string is null");
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println((new Solution1()).isValid(null));
    }
}
