package c02_string.lc0151_reverse_words_in_a_string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * This is the solution of No. 151 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/reverse-words-in-a-string/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an input string, reverse the string word by word.
 *
 * Example 1:
 * Input: "the sky is blue"
 * Output: "blue is sky the"
 *
 * Example 2:
 * Input: "  hello world!  "
 * Output: "world! hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 *
 * Example 3:
 * Input: "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 *
 * Note:
 * - A word is defined as a sequence of non-space characters.
 * - Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
 * - You need to reduce multiple spaces between two words to a single space in the reversed string.
 *
 * Follow up:
 * - For C programmers, try to solve it in-place in O(1) extra space.
 * ==========================================================================================================
 *
 * Tags: string;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * Approach 1: Use build-in API
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * @param s String, a string which contains multiple words
     * @return String, the modified string
     */
    public String reverseWords(String s) {
        s = s.trim();
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

    public static void main(String[] args) {
        String[] testCases = {"the sky is blue", "  hello world!  ", "a good   example"};
        String[] results = {"blue is sky the", "world! hello", "example good a"};
        Solution1 solution = new Solution1();
        for (int i = 0; i < testCases.length; ++i) {
            String result = results[i];
            String ans = solution.reverseWords(testCases[i]);
            if (!ans.equals(result)) {
                System.out.format("Original string: %s\nReversed string: %s\n", result, ans);
            }
        }
    }
}