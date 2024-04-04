package c02_string.lc0394_decode_string;

/**
 * This is the solution of No. 394 problem in the LeetCode,
 * the website of the problem is as follows:
 * https://leetcode.com/problems/decode-string
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an encoded string, return its decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.
 * Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc.
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k.
 * For example, there will not be input like 3a or 2[4].
 *
 * The test cases are generated so that the length of the output will never exceed 10^5.
 *
 * Example 1:
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 *
 * Example 2:
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 *
 * Example 3:
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 *
 * Constraints:
 * - 1 <= s.length <= 30
 * - s consists of lowercase English letters, digits, and square brackets '[]'.
 * - s is guaranteed to be a valid input.
 * - All the integers in s are in the range [1, 300].
 * ==========================================================================================================
 *
 * Difficulty: Medium
 * Tags: string;stack;
 *
 * @author  Lukas (xgp1227atgmail.com)
 */
public class Solution2 {
    private int idx;

    public String decodeString(String s) {
        // 解法2：递归
        // 时间复杂度：O(L_encoded)
        // 空间复杂度：O(L_encoded)

        idx = 0;
        return decode(s).toString();
    }

    private StringBuilder decode(String s) {
        int multi = 0;
        StringBuilder res = new StringBuilder();
        while (idx < s.length()) {
            char c = s.charAt(idx);
            if (c >= '0' && c <= '9') {
                multi = multi * 10 + c - '0';
            } else if (c == '[') {
                ++idx;
                StringBuilder tmp = decode(s);
                for (; multi > 0; --multi) {
                    res.append(tmp);
                }
            } else if (c == ']') {
                break;
            } else {
                // c >= 'a' && c <= 'z'
                res.append(c);
            }
            ++idx;
        }
        return res;
    }
}