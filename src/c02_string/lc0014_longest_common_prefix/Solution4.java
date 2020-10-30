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
public class Solution4 {
    /**
     * Approach 4: Divide and Conquer (Bottom up)
     * Time Complexity: ???
     * Space Complexity: ???
     *
     * @param strs String[], an array of strings
     * @return String, the longest common prefix string
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        final int N = strs.length;
        for (int interval = 1; interval < N; interval *= 2) {
            for (int i = 0; i < N - interval; i += 2 * interval) {
                strs[i] = commonPrefix(strs[i], strs[i + interval]);
            }
        }
        return strs[0];
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

    public static void main(String[] args) {
        Solution4 solu = new Solution4();
        System.out.println(solu.longestCommonPrefix(new String[] {})); // ""
        System.out.println(solu.longestCommonPrefix(new String[] {"aa"})); // "aa"
        System.out.println(solu.longestCommonPrefix(new String[] {"aa", "aabbcc", "aab"})); // "aa"
        System.out.println(solu.longestCommonPrefix(new String[] {"abc", "aabbcc", "aab"})); // "a"
    }
}