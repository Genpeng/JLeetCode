package string.lc0014_longest_common_prefix;

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
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * 解法1：
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * 备注：自己的写法
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Longest Common Prefix.
     * Memory Usage: 37.8 MB, less than 80.70% of Java online submissions for Longest Common Prefix.
     *
     * @param strs String[], an array of strings
     * @return String, the longest common prefix string
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        // 步骤1：求出数组中最短的字符串长度
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; ++i) {
            if (strs[i].length() < minLen) {
                minLen = strs[i].length();
            }
        }
        // 步骤2：多次遍历数组，判断相应位置的字符是否一致，如果一致添加到结果字符串中
        StringBuilder sb = new StringBuilder();
        outer: for (int i = 0; i < minLen; ++i) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; ++j) {
                if (c != strs[j].charAt(i)) {
                    break outer;
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strs = new String[] {"flower", "flow", "flight"};
        Solution1 solution = new Solution1();
        System.out.println(solution.longestCommonPrefix(strs));
    }
}