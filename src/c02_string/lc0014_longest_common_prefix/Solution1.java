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
 * Difficulty: Easy
 * Tags: string;divide and conquer;binary search;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * Approach 1: Two Pointers (Convert to find out the common prefix of two strings)
     * Time Complexity: O(L1 + L2 + ... + Ln)
     * Space Complexity: O(1)
     *
     * Result of Submission:
     * Runtime: 2 ms, faster than 32.50% of Java online submissions for Longest Common Prefix.
     * Memory Usage: 39.4 MB, less than 5.26% of Java online submissions for Longest Common Prefix.
     *
     * @param strs String[], an array of strings
     * @return String, the longest common prefix string
     */
    public String longestCommonPrefixV1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String lcp = strs[0];
        for (int i = 1; i < strs.length; ++i) {
            lcp = commonPrefix(lcp, strs[i]);
            if (lcp.length() == 0) {
                break;
            }
        }
        return lcp;
    }

    public String commonPrefix(String s1, String s2) {
        int minLen = Math.min(s1.length(), s2.length());
        for (int i = 0; i < minLen; ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return s1.substring(0, i);
            }
        }
        return s1.substring(0, minLen);
    }

    /**
     * Approach 1: Convert to find out the common prefix of two strings
     * Time Complexity: O(L1 + L2 + ... + Ln)
     * Space Complexity: O(1)
     *
     * Result of Submission:
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Longest Common Prefix.
     * Memory Usage: 37.9 MB, less than 80.70% of Java online submissions for Longest Common Prefix.
     *
     * @param strs String[], an array of strings
     * @return String, the longest common prefix string
     */
    public String longestCommonPrefixV2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String lcp = strs[0];
        for (int i = 1; i < strs.length; ++i) {
            while (strs[i].indexOf(lcp) != 0) {
                lcp = lcp.substring(0, lcp.length() - 1);
                if (lcp.isEmpty()) {
                    return "";
                }
            }
        }
        return lcp;
    }

    public static void main(String[] args) {
        Solution1 solu = new Solution1();
        System.out.println(solu.longestCommonPrefixV1(new String[] {})); // ""
        System.out.println(solu.longestCommonPrefixV1(new String[] {"aa"})); // "aa"
        System.out.println(solu.longestCommonPrefixV1(new String[] {"aa", "aabbcc", "aab"})); // "aa"
        System.out.println(solu.longestCommonPrefixV1(new String[] {"abc", "aabbcc", "aab"})); // "a"
    }
}