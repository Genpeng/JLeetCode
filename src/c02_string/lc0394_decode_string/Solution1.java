package c02_string.lc0394_decode_string;

import java.util.ArrayDeque;
import java.util.Deque;

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
public class Solution1 {
    public String decodeString(String s) {
        // 解法1：栈
        // 时间复杂度：O(L_encoded + L_decoded)
        // 空间复杂度：O(L_decoded)
        // 其中，L_encoded 表示编码后的字符串，L_decoded 表示解码后的字符串

        Deque<Integer> multiStack = new ArrayDeque<>();
        Deque<StringBuilder> resStack = new ArrayDeque<>();
        int multi = 0;
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                res.append(c);
            } else if (c >= '0' && c <= '9') {
                multi = multi * 10 + c - '0';
            } else if (c == '[') {
                multiStack.push(multi);
                resStack.push(res);
                multi = 0;
                res = new StringBuilder();
            } else {
                StringBuilder tmp = new StringBuilder();
                int currMulti = multiStack.pop();
                for (int i = 0; i < currMulti; ++i) {
                    tmp.append(res);
                }
                res = resStack.pop().append(tmp);
            }
        }
        return res.toString();
    }
}