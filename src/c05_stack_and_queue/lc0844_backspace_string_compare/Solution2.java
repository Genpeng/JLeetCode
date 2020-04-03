package c05_stack_and_queue.lc0844_backspace_string_compare;

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
     * 解法2：Two Pointers
     * 时间复杂度：O(min(m, n))
     * 空间复杂度：O(1)
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Backspace String Compare.
     * Memory Usage: 37.7 MB, less than 6.06% of Java online submissions for Backspace String Compare.
     *
     * @param s1 String, one input string
     * @param s2 String, the other input string
     * @return boolean, true true if they are equal when both are typed into empty text editors
     */
    public boolean backspaceCompare(String s1, String s2) {
        int i = s1.length() - 1, j = s2.length() - 1;
        int skip1 = 0, skip2 = 0;
        while (i >= 0 || j >= 0) {
            // 找到S对应结果字符串的下一个字符（还原退格符的影响）
            while (i >= 0) {
                if (s1.charAt(i) == '#') {
                    --i;
                    ++skip1;
                } else if (skip1 > 0) {
                    --i;
                    --skip1;
                } else {
                    break;
                }
            }

            // 找到T对应结果字符串的下一个字符
            while (j >= 0) {
                if (s2.charAt(j) == '#') {
                    --j;
                    ++skip2;
                } else if (skip2 > 0) {
                    --j;
                    --skip2;
                } else {
                    break;
                }
            }

            // 如果S和T对应的结果字符串的当前字符不相同
            if ((i >= 0) && (j >= 0) && (s1.charAt(i) != s2.charAt(j))) {
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