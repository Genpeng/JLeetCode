package lc844_r;

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
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int sSkip = 0, tSkip = 0;
        while (i >= 0 || j >= 0) {
            // 找到S对应结果字符串的下一个字符（还原退格符的影响）
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    --i;
                    ++sSkip;
                } else if (sSkip > 0) {
                    --i;
                    --sSkip;
                } else {
                    break;
                }
            }

            // 找到T对应结果字符串的下一个字符
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    --j;
                    ++tSkip;
                } else if (tSkip > 0) {
                    --j;
                    --tSkip;
                } else {
                    break;
                }
            }

            // 如果S和T对应的结果字符串的当前字符不相同
            if ((i >= 0) && (j >= 0) && (S.charAt(i) != T.charAt(j))) {
                return false;
            }

            // 如果S和T中有一个字符串先遍历完
            if ((i >= 0) != (j >= 0)) {
                return false;
            }

            --i;
            --j;
        }
        return true;
    }

    public static void main(String[] args) {
        String S = "ab##", T = "c#d#";
        System.out.println((new Solution2()).backspaceCompare(S, T));
    }
}