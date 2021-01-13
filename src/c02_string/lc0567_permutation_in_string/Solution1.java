package c02_string.lc0567_permutation_in_string;

import java.util.HashMap;
import java.util.Map;

/**
 * This is the solution of No. 567 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/permutation-in-string/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1.
 * In other words, one of the first string's permutations is the substring of the second string.
 *
 * Example 1:
 * Input: s1 = "ab" s2 = "eidbaooo"
 * Output: True
 * Explanation: s2 contains one permutation of s1 ("ba").
 *
 * Example 2:
 * Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 *  
 * Constraints:
 * - The input strings only contain lower case letters.
 * - The length of both given strings is in range [1, 10,000].
 * ==========================================================================================================
 *
 * Difficulty: Medium
 * Tags: string;sliding window;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * Approach 1: Sliding Window (fixed window)
     *
     * Complexity Analysis:
     * Time Complexity: O(l1 + l2)
     * Space Complexity: O(l1)
     * where l1 represents the length of s1, and l2 is the length of s2
     *
     * @param s1 String, the pattern string
     * @param s2 String, the target string to find pattern
     * @return boolean, true if s2 contains the permutation of s1
     */
    public boolean checkInclusion(String s1, String s2) {
        // 步骤1：统计 s1 字符出现的次数
        Map<Character, Integer> freqMap = new HashMap<>(s1.length());
        for (char c : s1.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        // 步骤2：维护一个大小等于 s1 长度的窗口向右移动，判断窗口内是否包含 s1 的所有字符
        int matched = 0;
        char c;
        for (int li = 0, ri = 0; ri < s2.length(); ++ri) {
            c = s2.charAt(ri);
            if (freqMap.containsKey(c)) {
                freqMap.put(c, freqMap.get(c) - 1);
                if (freqMap.get(c) == 0) {
                    ++matched;
                }
            }
            if (matched == freqMap.size()) {
                return true;
            }
            if (ri >= s1.length() - 1) {
                c = s2.charAt(li++);
                if (freqMap.containsKey(c)) {
                    if (freqMap.get(c) == 0) {
                        --matched;
                    }
                    freqMap.put(c, freqMap.get(c) + 1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution1 solu = new Solution1();
        System.out.println(solu.checkInclusion("ab", "eidbaooo") == true);
        System.out.println(solu.checkInclusion("ab", "eidboaoo") == false);
    }
}