package c02_string.lc0316_remove_duplicate_letters;

import java.util.*;

/**
 * This is the solution of No. 316 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/remove-duplicate-letters/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a string s, remove duplicate letters so that every letter appears once and only once.
 * You must make sure your result is the smallest in lexicographical order among all possible results.
 *
 * Note: This question is the same as 1081: https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
 *
 * Example 1:
 * Input: s = "bcabc"
 * Output: "abc"
 *
 * Example 2:
 * Input: s = "cbacdcbc"
 * Output: "acdb"
 *
 * Constraints:
 * - 1 <= s.length <= 104
 * - s consists of lowercase English letters.
 * ==========================================================================================================
 *
 * Difficulty: Medium
 * Tags: string;stack;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution3 {
    /**
     * Approach 3: Stack
     * 这道题其实要实现的点有两个：
     * 1. 删除重复的元素（借助集合）
     * 2. 使得最后的字符串字典序最小（借助一个 Map，如果当前元素比栈顶元素小且后面还会出现）
     *
     * Complexity Analysis:
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param s String, an input string
     * @return String, the modified string whose every letter appears once
     */
    public String removeDuplicateLetters(String s) {
        final int L = s.length();
        if (L <= 1) {
            return s;
        }
        // 统计每个字符最后出现的位置
        int[] counts = new int[26];
        for (int i = 0; i < L; ++i) {
            ++counts[s.charAt(i) - 'a'];
        }
        // 用栈维护最终返回的字符串
        boolean[] seen = new boolean[26];
        Deque<Character> stack = new ArrayDeque<>(); // peek() == peekFirst()
        for (int i = 0; i < L; ++i) {
            char c = s.charAt(i);
            --counts[c - 'a'];
            if (seen[c - 'a']) {
                continue;
            }
            while (!stack.isEmpty() && c < stack.peekLast() && counts[stack.peekLast() - 'a'] > 0) {
                seen[stack.peekLast() - 'a'] = false;
                stack.pollLast();
            }
            stack.addLast(c);
            seen[c - 'a'] = true;
        }
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            ans.append(stack.pollFirst());
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Solution3 solu = new Solution3();
        System.out.println(solu.removeDuplicateLetters("bcabc").equals("abc"));
        System.out.println(solu.removeDuplicateLetters("cbacdcbc").equals("acdb"));
        System.out.println(solu.removeDuplicateLetters("ecbacba").equals("eacb"));
        System.out.println(solu.removeDuplicateLetters("bbcaac").equals("bac"));
    }
}