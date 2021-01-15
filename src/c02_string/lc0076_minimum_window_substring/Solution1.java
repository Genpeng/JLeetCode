package c02_string.lc0076_minimum_window_substring;

/**
 * This is the solution of No. 76 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/minimum-window-substring/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given two strings s and t, return the minimum window in s which will contain all the characters in t.
 * If there is no such window in s that covers all characters in t, return the empty string "".
 *
 * Note that If there is such a window, it is guaranteed that there will always be only one unique minimum window in s.
 *
 * Example 1:
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 *
 * Example 2:
 * Input: s = "a", t = "a"
 * Output: "a"
 *
 * Constraints:
 * - 1 <= s.length, t.length <= 105
 * - s and t consist of English letters.
 *  
 * Follow up: Could you find an algorithm that runs in O(n) time?
 * ==========================================================================================================
 *
 * Difficulty: Hard
 * Tags: string;sliding window;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
class Solution1 {
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        if (m < n || n == 0) {
            return "";
        }
        // 步骤1：统计 t 中所有字符的频次
        int[] freqMap = new int[128];
        for (char c : t.toCharArray()) {
            ++freqMap[c];
        }
        // 步骤2：采用一个可变的窗口向右滑动，一开始右边界尽可能向右滑动，
        // 直到窗口包含 t 中所有字符，然后开始搜索左边界，找出最短的子串
        int count = n;
        int startIndex = -1, minLen = Integer.MAX_VALUE;
        char c;
        for (int li = 0, ri = 0; ri < m; ++ri) {
            c = s.charAt(ri);
            if (freqMap[c]-- > 0) {
                --count;
            }
            while (count == 0) {
                if (ri - li + 1 < minLen) {
                    startIndex = li;
                    minLen = ri - li + 1;
                }
                c = s.charAt(li++);
                if (++freqMap[c] > 0) {
                    ++count;
                }
            }
        }
        return startIndex == -1 ? "" : s.substring(startIndex, startIndex + minLen);
    }
}