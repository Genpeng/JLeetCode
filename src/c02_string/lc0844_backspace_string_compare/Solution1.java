package c02_string.lc0844_backspace_string_compare;

import java.util.Stack;

/**
 * This is the solution of No. 844 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/backspace-string-compare/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given two strings S and T, return if they are equal when both are typed into empty text editors.
 * `#` means a backspace character.
 *
 * Example 1:
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 *
 * Example 2:
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 *
 * Example 3:
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 *
 * Example 4:
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 *
 * Note:
 * - 1 <= S.length <= 200
 * - 1 <= T.length <= 200
 * - S and T only contain lowercase letters and '#' characters.
 *
 * Follow up:
 * Can you solve it in O(N) time and O(1) space?
 * ==========================================================================================================
 *
 * Tags: string;stack;two pointers;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 * @date    2019/04/10
 */
public class Solution1 {
    /**
     * Approach 1: Simulation (by using stack)
     * Time Complexity: O(m + n)
     * Space Complexity: O(m + n)
     *
     * Result of Submission:
     * Runtime: 2 ms, faster than 35.71% of Java online submissions for Backspace String Compare.
     * Memory Usage: 38.2 MB, less than 6.06% of Java online submissions for Backspace String Compare.
     *
     * @param s1 String, one input string
     * @param s2 String, the other input string
     * @return boolean, true if they are equal when both are typed into empty text editors
     */
    public boolean backspaceCompareV1(String s1, String s2) {
        return restoreV1(s1).equals(restoreV1(s2));
    }

    private String restoreV1(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c != '#') {
                stack.push(c);
            } else if (!stack.isEmpty()) {
                stack.pop();
            }
        }
        return String.valueOf(stack);
    }

    /**
     * Approach 1: Simulation (by using `StringBuilder`, faster than using stack)
     * Time Complexity: O(m + n)
     * Space Complexity: O(m + n)
     *
     * Result of Submission:
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Backspace String Compare.
     * Memory Usage: 37.6 MB, less than 6.06% of Java online submissions for Backspace String Compare.
     *
     * @param s1 String, one input string
     * @param s2 String, the other input string
     * @return boolean, true if they are equal when both are typed into empty text editors
     */
    public boolean backspaceCompareV2(String s1, String s2) {
        return restoreV2(s1).equals(restoreV2(s2));
    }

    private String restoreV2(String s) {
        StringBuilder sb = new StringBuilder();
        if (s == null || s.isEmpty()) {
            return sb.toString();
        }
        for (char c : s.toCharArray()) {
            if (c != '#') {
                sb.append(c);
            } else if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String S = "ab#c", T = "ad#c";
        System.out.println((new Solution1()).backspaceCompareV1(S, T));
    }
}