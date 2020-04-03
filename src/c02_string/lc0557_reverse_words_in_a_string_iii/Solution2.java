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
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution2 {
    /**
     * 解法2
     * 解题思路：
     * 将字符串转换成字符数组，然后将每个单词进行逆序，最后再重新生成一个新的字符串。
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * Runtime: 2 ms, faster than 99.50% of Java online submissions for Reverse Words in a String III.
     * Memory Usage: 41.3 MB, less than 19.30% of Java online submissions for Reverse Words in a String III.
     *
     * @param s String, the input string
     * @return String, the modified string
     */
    public String reverseWords(String s) {
        char[] ca = s.toCharArray();
        for (int i = 0; i < ca.length; ++i) {
            if (ca[i] != ' ') {
                int j = i;
                while (j + 1 < ca.length && ca[j+1] != ' ') {
                    ++j;
                }
                reverse(ca, i, j);
                i = j;
            }
        }
        return new String(ca);
    }

    private void reverse(char[] ca, int i, int j) {
        for (; i < j; ++i, --j) {
            char tmp = ca[i];
            ca[i] = ca[j];
            ca[j] = tmp;
        }
    }
}