package c02_string.lc0340_longest_substring_with_at_most_k_distinct_characters;

import java.util.HashMap;
import java.util.Map;

/**
 * This is the solution of No. 340 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a string s and an integer k, return the length of the longest substring of s that contains at most
 * k distinct characters.
 *
 * Example 1:
 * Input: s = "eceba", k = 2
 * Output: 3
 * Explanation: The substring is "ece" with length 3.
 *
 * Example 2:
 * Input: s = "aa", k = 1
 * Output: 2
 * Explanation: The substring is "aa" with length 2.
 *  
 * Constraints:
 * - 1 <= s.length <= 5 * 104
 * - 0 <= k <= 50
 * ==========================================================================================================
 *
 * Difficulty: Medium
 * Tags: string;sliding window;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * Approach 1: Sliding Window
     *
     * Complexity Analysis:
     * Time Complexity: O(N)
     * Space Complexity: O(k)
     *
     * @param s String, the input string
     * @param k int, the number of most distinct characters
     * @return int, the length of the longest substring that at most k distinct characters
     */
    public int lengthOfLongestSubstringKDistinctV1(String s, int k) {
        final int L = s.length();
        Map<Character, Integer> freqMap = new HashMap<>(k+1);
        int maxLen = 0;
        char c;
        for (int li = 0, ri = 0; ri < L; ++ri) {
            c = s.charAt(ri);
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
            while (freqMap.size() > k) {
                c = s.charAt(li);
                freqMap.put(c, freqMap.get(c) - 1);
                if (freqMap.get(c) == 0) {
                    freqMap.remove(c);
                }
                ++li;
            }
            maxLen = Math.max(maxLen, ri - li + 1);
        }
        return maxLen;
    }

    /**
     * Approach 1: Sliding Window
     *
     * Complexity Analysis:
     * Time Complexity: O(N)
     * Space Complexity: O(k)
     *
     * @param s String, the input string
     * @param k int, the number of most distinct characters
     * @return int, the length of the longest substring that at most k distinct characters
     */
    public int lengthOfLongestSubstringKDistinctV2(String s, int k) {
        final int L = s.length();
        int[] freqMap = new int[256];
        int maxLen = 0, count = 0;
        char c;
        for (int li = 0, ri = 0; ri < L; ++ri) {
            c = s.charAt(ri);
            if (freqMap[c] == 0) {
                ++count;
            }
            ++freqMap[c];
            while (count > k) {
                c = s.charAt(li);
                --freqMap[c];
                if (freqMap[c] == 0) {
                    --count;
                }
                ++li;
            }
            maxLen = Math.max(maxLen, ri - li + 1);
        }
        return maxLen;
    }
}