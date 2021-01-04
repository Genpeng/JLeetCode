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
 * Difficulty: Medium
 * Tags: string;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution3 {
    /**
     * 方法3：滑动窗口（优化）
     * 方法3是对方法2的改进。方法2在最坏的情况下，需要 2*L 次操作（比如字符串 s 为 bbbbbb 的情况）。
     * 当窗口中存在重复字符时，方法2每次只将左边界向右滑动一个字符，但是有时候需要滑动多个字符才能保证
     * 子串中不存在重复字符。
     *
     * 为了解决这个问题，采用一个 map 用于保存字符的位置。遍历字符串的每个字符，当遇到重复字符时，
     * 比较重复字符上一次出现的位置和左边界的位置，如果上一次出现的位置大于等于左边界的位置（窗口存在
     * 重复），则将左边界移动到上一次位置的下一个字符；否则，窗口的子串不重复，计算子串的长度并保存
     * 最长子串的长度。如此循环往复直到遍历完字符串的所有字符。
     *
     * 记得，每次遍历时，还需要更新 map 中字符的位置。
     *
     * Complexity Analysis:
     * Time Complexity: O(L)
     * Space Complexity: O(L)
     * where L represents the length of the string.
     *
     * @param s String, the input string
     * @return int, the length of longest substring without repeating characters
     */
    public int lengthOfLongestSubstringV1(String s) {
        final int L = s.length();
        Map<Character, Integer> idxMap = new HashMap<>(L);
        int maxLen = 0;
        for (int li = 0, ri = 0; ri < L; ++ri) {
            char c = s.charAt(ri);
            if (idxMap.containsKey(c) && idxMap.get(c) >= li) {
                li = idxMap.get(c) + 1;
            } else {
                // 如果不包含该字符，或者出现过该字符但是不在窗口中
                maxLen = Math.max(maxLen, ri - li + 1);
            }
            idxMap.put(c, ri);
        }
        return maxLen;
    }

    public int lengthOfLongestSubstringV2(String s) {
        final int L = s.length();
        Map<Character, Integer> idxMap = new HashMap<>(L);
        int maxLen = 0;
        for (int li = 0, ri = 0; ri < L; ++ri) {
            char c = s.charAt(ri);
            li = Math.max(li, idxMap.getOrDefault(c, 0));
            maxLen = Math.max(maxLen, ri - li + 1);
            idxMap.put(c, ri + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution3 solu = new Solution3();
        System.out.println(solu.lengthOfLongestSubstringV1("abcabcbb") == 3);
        System.out.println(solu.lengthOfLongestSubstringV1("bbbbb") == 1);
        System.out.println(solu.lengthOfLongestSubstringV1("pwwkew") == 3);
        System.out.println(solu.lengthOfLongestSubstringV1("tmmzuxt") == 5);
    }
}
