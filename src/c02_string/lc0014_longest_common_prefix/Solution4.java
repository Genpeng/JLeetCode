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
 * Tags: string;divide and conquer;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution4 {
    /**
     * Approach 4: Divide and Conquer (Bottom up)
     * Time Complexity:
     * Space Complexity:
     *
     * Result of Submission:
     * Runtime: 1 ms, faster than 58.69% of Java online submissions for Longest Common Prefix.
     * Memory Usage: 39.6 MB, less than 5.26% of Java online submissions for Longest Common Prefix.
     *
     * @param strs String[], an array of strings
     * @return String, the longest common prefix string
     */
    public String longestCommonPrefix(String[] strs) {
        // TODO: add it
        return null;
    }

    public static void main(String[] args) {
        Solution4 solu = new Solution4();
        System.out.println(solu.longestCommonPrefix(new String[] {})); // ""
        System.out.println(solu.longestCommonPrefix(new String[] {"aa"})); // "aa"
        System.out.println(solu.longestCommonPrefix(new String[] {"aa", "aabbcc", "aab"})); // "aa"
        System.out.println(solu.longestCommonPrefix(new String[] {"abc", "aabbcc", "aab"})); // "a"
    }
}