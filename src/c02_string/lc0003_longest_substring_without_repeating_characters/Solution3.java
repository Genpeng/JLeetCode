package c02_string.lc0003_longest_substring_without_repeating_characters;

import java.util.HashMap;
import java.util.Map;

/**
 * This is the solution of No. 003 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * ==========================================================================================================
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2018/12/10
 */
public class Solution3 {
    /**
     * 方法3：滑动窗口（优化）
     * 方法3是对方法2的改进。方法2在最坏的情况下，需要2n次操作（比如字符串s为bbbbbb的情况）。
     * 当窗口中存在重复字符时，方法2每次只将左边界向右滑动一个字符，但是有时候需要滑动多个字符
     * 才能保证子串中不存在重复字符。
     *
     * 为了解决这个问题，采用一个map用于保存字符的位置。遍历字符串的每个字符，当遇到重复字符时，
     * 比较重复字符上一次的位置和左边界的位置，如果上一次的位置大于等于左边界的位置（子串存在
     * 重复），则将左边界移动到上一次位置的下一个字符；如果上一次的位置小于左边界的位置，此时，
     * 窗口的子串不重复，计算子串的长度并保存最长子串的长度。如此循环往复直到遍历完字符串的
     * 所有字符。记得，每次遍历时，还需要更新map中字符的位置。
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(min(n, m))，其中，n表示字符串的长度，m是不重复字符的数目
     *
     * @param s String, 输入的字符串
     * @return int, 无重复字符的最长子串
     */
    public int lengthOfLongestSubstring(String s) {
//        int ans = 0;
//        Map<Character, Integer> map = new HashMap<>();
//        for (int i = 0, j = 0; j < s.length(); ++j) {
//            if (map.containsKey(s.charAt(j))) {
//                i = Math.max(map.get(s.charAt(j)), i);
//            }
//            ans = Math.max(j - i + 1, ans);
//            map.put(s.charAt(j), j + 1);
//        }
//        return ans;

        int maxLen = 0;
        Map<Character, Integer> char2Pos = new HashMap<>();
        for (int left = 0, right = 0; right < s.length(); ++right) {
            char c = s.charAt(right);
            if (char2Pos.containsKey(c) && left <= char2Pos.get(c)) {
                // 如果子串存在重复字符，一定满足两个条件：
                // 1. 字符在map中已经存在
                // 2. 左边界小于等于右边界字符上一次的位置（注意！）
                // 例如：
                // a b b a
                //     l r
                // 右边界字符a虽然已经出现过，但是窗口的子串并不重复
                left = char2Pos.get(c) + 1;
            } else {
                maxLen = Math.max(right - left + 1, maxLen);
            }
            char2Pos.put(c, right);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abba";
        System.out.println((new Solution3()).lengthOfLongestSubstring(s));
    }
}
