package c02_string.lc0151_reverse_words_in_a_string;

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
 * Difficulty: Medium
 * Tags: string;two pointers;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution2 {
    /**
     * Approach 2: Two Pointers
     * remove redundant space -> reverse the whole string -> reverse each word in the string
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * Result of Submission:
     * Runtime: 7 ms, faster than 26.91% of Java online submissions for Reverse Words in a String.
     * Memory Usage: 39.8 MB, less than 23.65% of Java online submissions for Reverse Words in a String.
     *
     * @param s String, a string which contains multiple words
     * @return String, the modified string
     */
    public String reverseWordsV1(String s) {
        StringBuilder sb = trimSpaces(s);
        reverse(sb, 0, sb.length() - 1);
        reverseEachWords(sb);
        return new String(sb);
    }

    private StringBuilder trimSpaces(String s) {
        int li = 0, ri = s.length() - 1;
        while (li <= ri && s.charAt(li) == ' ') {
            ++li;
        }
        while (li <= ri && s.charAt(ri) == ' ') {
            --ri;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = li; i <= ri; ++i) {
            char c = s.charAt(i);
            if (c != ' ') {
                sb.append(c);
            } else if (sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
        }
        return sb;
    }

    private void reverse(StringBuilder sb, int i, int j) {
        for (; i < j; ++i, --j) {
            char tmp = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, tmp);
        }
    }

    private void reverseEachWords(StringBuilder sb) {
        int L = sb.length();
        for (int i = 0, j; i < L; ++i) {
            if (sb.charAt(i) != ' ') {
                j = i;
                while (j + 1 < L && sb.charAt(j + 1) != ' ') {
                    ++j;
                }
                reverse(sb, i, j);
                i = j;
            }
        }
    }

    /**
     * Approach 2: Two Pointers
     * reverse the whole string -> reverse each word in the string
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * @param s String, a string which contains multiple words
     * @return String, the modified string
     */
    public String reverseWordsV2(String s) {
        int L = s.length();
        char[] ca = s.toCharArray();
        reverse(ca, 0, L - 1);
        StringBuilder sb = new StringBuilder();
        for (int i, j = 0; j < L; ++j) {
            if (ca[j] != ' ') {
                i = j;
                while (j+1 < L && ca[j+1] != ' ') {
                    ++j;
                }
                reverse(ca, i, j);
                sb.append(ca, i, j-i+1).append(' ');
            }
        }
        return sb.toString().trim();
    }

    private void reverse(char[] ca, int i, int j) {
        for (; i < j; ++i, --j) {
            char tmp = ca[i];
            ca[i] = ca[j];
            ca[j] = tmp;
        }
    }

    public static void main(String[] args) {
        String[] testCases = {"the sky is blue", "  hello world!  ", "a good   example"};
        String[] results = {"blue is sky the", "world! hello", "example good a"};
        Solution2 solution = new Solution2();
        for (int i = 0; i < testCases.length; ++i) {
            String result = results[i];
            String ans = solution.reverseWordsV2(testCases[i]);
            if (!ans.equals(result)) {
                System.out.format("Original string: %s\nReversed string: %s\n", result, ans);
            }
        }
    }
}