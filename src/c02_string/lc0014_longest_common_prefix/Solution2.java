package c02_string.lc0014_longest_common_prefix;

/**
 * This is the solution of No. 14 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/longest-common-prefix/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 *
 * Example 2:
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 * Note:
 * - All given inputs are in lowercase letters a-z.
 * ==========================================================================================================
 *
 * Tags: string;divide and conquer;binary search;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution2 {
    /**
     * Approach 2: K Pointers (Scan K strings simultaneously)
     * Time Complexity: O(L1 + L2 + ... + Ln)
     * Space Complexity: O(1)
     *
     * Result of Submission:
     * Runtime: 2 ms, faster than 32.88% of Java online submissions for Longest Common Prefix.
     * Memory Usage: 39.1 MB, less than 8.19% of Java online submissions for Longest Common Prefix.
     *
     * @param strs String[], an array of strings
     * @return String, the longest common prefix string
     */
    public String longestCommonPrefixV1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int minLen = Integer.MAX_VALUE;
        for (String s : strs) {
            if (s.length() < minLen) {
                minLen = s.length();
            }
        }
        for (int i = 0; i < minLen; ++i) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; ++j) {
                if (strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0].substring(0, minLen);
    }

    /**
     * Approach 2: K pointers (Scan K strings simultaneously)
     * Time Complexity: O(L1 + L2 + ... + Ln)
     * Space Complexity: O(1)
     *
     * Result of Submission:
     * Runtime: 2 ms, faster than 32.88% of Java online submissions for Longest Common Prefix.
     * Memory Usage: 39.1 MB, less than 5.26% of Java online submissions for Longest Common Prefix.
     *
     * @param strs String[], an array of strings
     * @return String, the longest common prefix string
     */
    public String longestCommonPrefixV2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); ++i) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; ++j) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        Solution2 solu = new Solution2();
        System.out.println(solu.longestCommonPrefixV2(new String[] {})); // ""
        System.out.println(solu.longestCommonPrefixV2(new String[] {"aa"})); // "aa"
        System.out.println(solu.longestCommonPrefixV2(new String[] {"aa", "aabbcc", "aab"})); // "aa"
        System.out.println(solu.longestCommonPrefixV2(new String[] {"abc", "aabbcc", "aab"})); // "a"
    }
}