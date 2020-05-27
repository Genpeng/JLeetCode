package c02_string.lc0186_reverse_words_in_a_string_ii;

/**
 * This is the solution of No. 186 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/reverse-words-in-a-string-ii
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an input string , reverse the string word by word. 
 *
 * Example:
 * Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
 * Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
 *
 * Note: 
 * - A word is defined as a sequence of non-space characters.
 * - The input string does not contain leading or trailing spaces.
 * - The words are always separated by a single space.
 *
 * Follow up: Could you do it in-place without allocating extra space?
 * ==========================================================================================================
 *
 * Tags: string;two pointers;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * Approach 1: Two Pointers (reverse the whole string -> reverse each words in the string)
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     *
     * @param s char[], a input string
     */
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);
        reverseEachWords(s);
    }

    private void reverse(char[] ca, int i, int j) {
        for (; i < j; ++i, --j) {
            char tmp = ca[i];
            ca[i] = ca[j];
            ca[j] = tmp;
        }
    }

    private void reverseEachWords(char[] ca) {
        int n = ca.length;
        for (int i, j = 0; j < n; ++j) {
            if (ca[j] != ' ') {
                i = j;
                while (j+1 < n && ca[j+1] != ' ') {
                    ++j;
                }
                reverse(ca, i, j);
            }
        }
    }
}