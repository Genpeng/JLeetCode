package c02_string.lc0242_valid_anagram;

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
public class Solution2 {
    /**
     * 解法二：哈希表
     * 时间复杂度：O(n)，其中n表示字符串的长度
     * 空间复杂度：O(n)
     *
     * @param s String, one of the two input strings
     * @param t String, the other input string
     * @return boolean, true if t is an anagram of s
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            ++freq[c - 'a'];
        }
        for (char c : t.toCharArray()) {
            if (freq[c - 'a']-- == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println((new Solution2()).isAnagram(s, t));
    }
}