package stack.leetcode20;

import java.util.Stack;

/**
 * This is the solution of No. 20 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/valid-parentheses/description/
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 */
public class Solution2 {
    public boolean isValid(String s) {
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
}
