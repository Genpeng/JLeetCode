package c02_string.lc0678_valid_parenthesis_string;

/**
 * This is the solution of No. 678 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/valid-parenthesis-string/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a string containing only three types of characters: '(', ')' and '*', write a function to check
 * whether this string is valid. We define the validity of a string by these rules:
 * 1. Any left parenthesis '(' must have a corresponding right parenthesis ')'.
 * 2. Any right parenthesis ')' must have a corresponding left parenthesis '('.
 * 3. Left parenthesis '(' must go before the corresponding right parenthesis ')'.
 * 4. '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string.
 * 5. An empty string is also valid.
 *
 * Example 1:
 * Input: "()"
 * Output: True
 *
 * Example 2:
 * Input: "(*)"
 * Output: True
 *
 * Example 3:
 * Input: "(*))"
 * Output: True
 *
 * Note:
 * - The string size will be in the range [1, 100].
 * ==========================================================================================================
 *
 * Tags: string;greedy algorithm;dp;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution2 {
    /**
     * Approach 2: Dynamic Programming
     * Time Complexity: O(N ^ 3)
     * Space Complexity: O(N)
     *
     * @param s String, an input string
     * @return boolean, true if the input string satisfies the rules
     */
    public boolean checkValidString(String s) {
        // TODO: finish it
        return true;
    }
}