package string.leetcode003;

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
     * 方法3是对方法2的改进。方法2在最坏的情况下，只需要2(n-1)步（比如字符串s为bbbbb的情况）。
     * 当窗口中存在重复字符时，方法2每次只向右滑动一个字符，但是有时候需要滑动多个字符才能保证
     * 子串中不存在重复字符。例如：字符串abcdcba，当j=5,i=0时，子串abcdc中存在重复字符c，但是
     * 字符c位于索引2处，i需要滑动到索引3处，才能保证子串中不存在重复字符。
     *
     * 为了解决这个问题，采用一个map用于保存字符的位置。遍历字符串的每个字符，当遇到重复字符时，
     * 比较重复字符上一次的位置和i当前的值，如果上一次位置的索引大于i当前的值，则将上一次位置的
     * 索引赋值给i，反之，则不改变i的值；如果遍历的字符不在map中，则计算当前子串的长度，并保留
     * 最长的长度，同时，将字符的位置保存到map中。如此循环往复直到遍历完字符串的所有字符。
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
