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
 * - Can you solve it in O(N) time and O(1) space?
 * ==========================================================================================================
 *
 * Tags: string;stack;two pointers;
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
     * @param S String, one input string
     * @param T String, the other input string
     * @return boolean, true true if they are equal when both are typed into empty text editors
     */
    public boolean backspaceCompare(String S, String T) {
//        if (S == null || T == null) {
//            throw new IllegalArgumentException("[ERROR] The input strings can not be null!!!");
//        }
        int i = S.length() - 1, j = T.length() - 1;
        while (true) {
            i = findRealIdx(S, i);
            j = findRealIdx(T, j);
            if (i >= 0 && j >= 0 && S.charAt(i) == T.charAt(j)) {
                --i;
                --j;
            } else {
                break;
            }
        }
        return i == -1 && j == -1;
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