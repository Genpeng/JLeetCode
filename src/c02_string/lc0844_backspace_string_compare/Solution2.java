package c02_string.lc0844_backspace_string_compare;

import java.util.ArrayList;
import java.util.List;

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
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2019/04/10
 */
public class Solution2 {
    /**
     * Approach 2: Two Pointers
     * Time Complexity: O(min(m, n))
     * Space Complexity: O(1)
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Backspace String Compare.
     * Memory Usage: 37.7 MB, less than 6.06% of Java online submissions for Backspace String Compare.
     *
     * @param s1 String, one input string
     * @param s2 String, the other input string
     * @return boolean, true true if they are equal when both are typed into empty text editors
     */
    public boolean backspaceCompare(String s1, String s2) {
//        if (s1 == null || s2 == null) {
//            throw new IllegalArgumentException("[ERROR] The input strings contain null!!!");
//        }
        int i = s1.length() - 1, j = s2.length() - 1;
        while (i >= 0 || j >= 0) {
            i = findRealIdx(s1, i);
            j = findRealIdx(s2, j);
            if ((i >= 0) != (j >= 0)) {
                return false;
            }
            if (i >= 0 && j >= 0 && s1.charAt(i) != s1.charAt(j)) {
                return false;
            }
            --i;
            --j;
        }
        return true;
    }

    private int findRealIdx(String s, int idx) {
        int skip = 0;
        while (idx >= 0) {
            if (s.charAt(idx) == '#') {
                --idx;
                ++skip;
            } else if (skip > 0) {
                --idx;
                --skip;
            } else {
                break;
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        List<String[]> testCases = new ArrayList<>();
        testCases.add(new String[] {"", ""});
        testCases.add(new String[] {"ab#c", "ad#c"});
        testCases.add(new String[] {"abc", "adc"});
        Solution2 solution = new Solution2();
        for (String[] testCase : testCases) {
            String s1 = testCase[0];
            String s2 = testCase[1];
            if (!solution.backspaceCompare(s1, s2)) {
                System.out.format("s1 = %s, s2 = %s\n", s1, s2);
            }
        }
    }
}