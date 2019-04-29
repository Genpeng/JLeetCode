package string.lc0242_valid_anagram;

import java.util.Arrays;

/**
 * This is the solution of No. 242 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/valid-anagram/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 *
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 *
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 *
 * Note:
 * - You may assume the string contains only lowercase alphabets.
 *
 * Follow up:
 * - What if the inputs contain unicode characters? How would you adapt your solution to such case?
 * ==========================================================================================================
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2019/04/29
 */
public class Solution1 {
    /**
     * 解法一：比较排序后的字符串
     * 时间复杂度：O(n * log(n))，其中n表示字符串的长度
     * 空间复杂度：O(n)
     *
     * @param s String, one of the two input strings
     * @param t String, the other input string
     * @return boolean, true if t is an anagram of s
     */
    public boolean isAnagram(String s, String t) {
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        Arrays.sort(sc);
        Arrays.sort(tc);
        return Arrays.equals(sc, tc);
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println((new Solution1()).isAnagram(s, t));
    }
}