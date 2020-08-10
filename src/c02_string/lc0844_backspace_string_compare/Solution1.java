package c02_string.lc0844_backspace_string_compare;

import java.util.ArrayList;
import java.util.List;
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
 * Difficulty: Easy
 * Tags: string;stack;two pointers;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
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
     * @param S String, one input string
     * @param T String, the other input string
     * @return boolean, true if they are equal when both are typed into empty text editors
     */
    public boolean backspaceCompareV1(String S, String T) {
//        if (S == null || T == null) {
//            throw new IllegalArgumentException("[ERROR] The input strings can not be null!!!");
//        }
        return restoreV1(S).equals(restoreV1(T));
    }

    private String restoreV1(String s) {
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
     * @param S String, one input string
     * @param T String, the other input string
     * @return boolean, true if they are equal when both are typed into empty text editors
     */
    public boolean backspaceCompareV2(String S, String T) {
//        if (S == null || T == null) {
//            throw new IllegalArgumentException("[ERROR] The input strings can not be null!!!");
//        }
        return restoreV2(S).equals(restoreV2(T));
    }

    private String restoreV2(String s) {
        StringBuilder sb = new StringBuilder();
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
        List<String[]> testCases = new ArrayList<>();
        List<Boolean> answers = new ArrayList<>();
        testCases.add(new String[] {"", ""});
        answers.add(true);
        testCases.add(new String[] {"ab#c", "ad#c"});
        answers.add(true);
        testCases.add(new String[] {"abc", "adc"});
        answers.add(false);
        Solution2 solu = new Solution2();
        for (int i = 0; i < testCases.size(); ++i) {
            String[] strs = testCases.get(i);
            String S = strs[0];
            String T = strs[1];
            boolean ans = answers.get(i);
            if (solu.backspaceCompare(S, T) != ans) {
                System.out.format("S: %s, T: %s\n", S, T);
            }
        }
    }
}