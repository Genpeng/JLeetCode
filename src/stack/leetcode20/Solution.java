package stack.leetcode20;

import java.util.Stack;

/**
 * This is the solution of No. 20 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/valid-parentheses/description/
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 */
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.empty()) {
                    return false;
                }

                char topChar = stack.pop();
                if (c == ')' && topChar != '(') {
                    return false;
                }
                if (c == ']' && topChar != '[') {
                    return false;
                }
                if (c == '}' && topChar != '{') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
