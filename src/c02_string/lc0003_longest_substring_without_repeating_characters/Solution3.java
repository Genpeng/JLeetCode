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
     * 复杂度分析
     * 时间复杂度：O(L)
     * 空间复杂度：O(L)
     * 其中，L 表示字符串的长度
     *
     * @param s String, the input string
     * @return int, the length of longest substring without repeating characters
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

        final int L = s.length();
        int maxLen = 0;
        Map<Character, Integer> idxMap = new HashMap<>(L);
        for (int li = 0, ri = 0; ri < L; ++ri) {
            char c = s.charAt(ri);
            if (idxMap.containsKey(c) && li <= idxMap.get(c)) {
                // 如果子串存在重复字符，一定满足两个条件：
                // 1. 字符在 map 中已经存在
                // 2. 左边界小于等于右边界字符上一次的位置（注意！）
                // 例如：
                // a b b a
                //     l r
                // 右边界字符a虽然已经出现过，但是窗口的子串并不重复
                li = idxMap.get(c) + 1;
            } else {
                maxLen = Math.max(ri - li + 1, maxLen);
            }
            idxMap.put(c, ri);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution3 solu = new Solution3();
        System.out.println(solu.lengthOfLongestSubstring("abcabcbb") == 3);
        System.out.println(solu.lengthOfLongestSubstring("bbbbb") == 1);
        System.out.println(solu.lengthOfLongestSubstring("pwwkew") == 3);
    }
}
