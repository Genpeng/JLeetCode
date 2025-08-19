package c02_string.lc0567_permutation_in_string;

/**
 * This is the solution of No. 567 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/permutation-in-string
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1.
 * In other words, one of the first string's permutations is the substring of the second string.
 * <p>
 * Example 1:
 * Input: s1 = "ab" s2 = "eidbaooo"
 * Output: True
 * Explanation: s2 contains one permutation of s1 ("ba").
 * <p>
 * Example 2:
 * Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 * <p>
 * Constraints:
 * - The input strings only contain lower case letters.
 * - The length of both given strings is in range [1, 10,000].
 * ==========================================================================================================
 * <p>
 * Difficulty: Medium
 * Tags: string;sliding window;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution2 {
    /**
     * Approach 2: Sliding Window (variable window)
     * <p>
     * Complexity Analysis:
     * Time Complexity: O(l1 + l2)
     * Space Complexity: O(1)
     * where l1 represents the length of s1, and l2 is the length of s2
     *
     * @param s1 String, the pattern string
     * @param s2 String, the target string to find pattern
     * @return boolean, true if s2 contains the permutation of s1
     */
    public boolean checkInclusion(String s1, String s2) {
        // 步骤1：统计 s1 所有字符出现的次数
        int[] freqMap = new int[128];
        for (char c : s1.toCharArray()) {
            ++freqMap[c];
        }
        // 步骤2：维持一个可变的窗口，一开始窗口尽可能的大，大到包含 s1 的所有字符，
        // 然后再缩小，如果存在某个时刻 count = 0 且刚好窗口的大小等于 s1 的长度，
        // 说明 s2 包含 s1 的某个排列
        int count = s1.length();
        char c;
        for (int li = 0, ri = 0; ri < s2.length(); ++ri) {
            c = s2.charAt(ri);
            if (freqMap[c]-- > 0) {
                --count;
            }
            while (count == 0) { // 如果 count == 0，说明此时窗口已经包含 s1 的所有字符
                if (ri - li + 1 == s1.length()) {
                    return true;
                }
                c = s2.charAt(li++);
                if (++freqMap[c] > 0) {
                    ++count;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution2 solu = new Solution2();
        System.out.println(solu.checkInclusion("ab", "eidbaooo") == true);
        System.out.println(solu.checkInclusion("ab", "eidboaoo") == false);
    }
}