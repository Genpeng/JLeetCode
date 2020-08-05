package c02_string.lc0003_longest_substring_without_repeating_characters;

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
public class Solution4 {
    /**
     * 方法4：滑动窗口（已知字符集）
     * 方法4和方法3的做法是一致的，方法4可以看成是方法3的特例。如果已知字符串的字符
     * 属于哪一种字符集的情况下，可以用大小固定的数组代替 map。
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
        int maxLen = 0;
        int[] index = new int[128];
        for (int li = 0, ri = 0; ri < s.length(); ++ri) {
            char c = s.charAt(ri);
            li = Math.max(index[c], li);
            maxLen = Math.max(ri - li + 1, maxLen);
            index[c] = ri + 1;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution4 solu = new Solution4();
        System.out.println(solu.lengthOfLongestSubstring("abcabcbb") == 3);
        System.out.println(solu.lengthOfLongestSubstring("bbbbb") == 1);
        System.out.println(solu.lengthOfLongestSubstring("pwwkew") == 3);
    }
}
