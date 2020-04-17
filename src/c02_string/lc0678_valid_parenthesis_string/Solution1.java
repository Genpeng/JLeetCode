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
public class Solution1 {
    /**
     * Approach 1: Brute Force (Recursion)
     * The idea is to count all the possible number of unpaired left brackets, and if there exists the case of
     * 0, the string is valid.
     *
     * Time Complexity: O(3 ^ N)
     * Space Complexity: O(N)
     *
     * Result of Submission:
     * Runtime: 470 ms, faster than 9.29% of Java online submissions for Valid Parenthesis String.
     * Memory Usage: 37.2 MB, less than 5.00% of Java online submissions for Valid Parenthesis String.
     *
     * @param s String, an input string
     * @return boolean, true if the input string satisfies the rules
     */
    public boolean checkValidString(String s) {
        if (s == null) {
            throw new IllegalArgumentException("[ERROR] The input string is null!!!");
        }
        return isValid(s, 0, 0);
    }

    private boolean isValid(String s, int i, int lefts) {
        if (i == s.length()) {
            return lefts == 0;
        }
        if (lefts < 0) { // prune
            return false;
        }
        char c = s.charAt(i);
        if (c == '(') {
            return isValid(s, i+1, lefts+1);
        } else if (c == ')') {
            return isValid(s, i+1, lefts-1);
        } else { // c == '*'
            return isValid(s, i+1, lefts+1) || isValid(s, i+1, lefts-1) || isValid(s, i+1, lefts);
        }
    }

    public static void main(String[] args) {
        String[] testCases = {"(*)", "((*)", "*)", "()"};
        boolean[] results = {true, true, true, true};
        Solution1 solu = new Solution1();
        for (int i = 0; i < testCases.length; ++i) {
            String s = testCases[i];
            boolean result = results[i];
            if (result != solu.checkValidString(s)) {
                System.out.format("s: %s", s);
            }
        }
    }
}