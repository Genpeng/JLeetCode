package c02_string.lc0557_reverse_words_in_a_string_iii;

/**
 * This is the solution of No. 557 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/reverse-words-in-a-string-iii/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a string, you need to reverse the order of characters in each word within a sentence
 * while still preserving whitespace and initial word order.
 *
 * Example 1:
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 *
 * Note:
 * In the string, each word is separated by single space and there will not be any extra space in the string.
 * ==========================================================================================================
 *
 * Tags: string;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * Approach 1: Use build-in API
     * Split the string into words, reverse each word, then join them back together.
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * Result of Submission:
     * Runtime: 3 ms, faster than 95.97% of Java online submissions for Reverse Words in a String III.
     * Memory Usage: 41.7 MB, less than 10.53% of Java online submissions for Reverse Words in a String III.
     *
     * @param s String, the input string
     * @return String, the modified string
     */
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(new StringBuilder(word).reverse()).append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        Solution1 solution = new Solution1();
        System.out.println(solution.reverseWords(s));
    }
}