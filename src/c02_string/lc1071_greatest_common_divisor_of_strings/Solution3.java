package c02_string.lc1071_greatest_common_divisor_of_strings;

/**
 * This is the solution of No. 1071 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/greatest-common-divisor-of-strings/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * For strings S and T, we say "T divides S" if and only if S = T + ... + T  (T concatenated with itself 1 or more times)
 *
 * Return the largest string X such that X divides str1 and X divides str2.
 *
 * Example 1:
 * Input: str1 = "ABCABC", str2 = "ABC"
 * Output: "ABC"
 *
 * Example 2:
 * Input: str1 = "ABABAB", str2 = "ABAB"
 * Output: "AB"
 *
 * Example 3:
 * Input: str1 = "LEET", str2 = "CODE"
 * Output: ""
 *
 * Note:
 * - 1 <= str1.length <= 1000
 * - 1 <= str2.length <= 1000
 * - str1[i] and str2[i] are English uppercase letters.
 * ==========================================================================================================
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution3 {
    /**
     * Approach 3: Math
     * Time complexity: O(l1 + l2)
     * Space complexity: O(l1 + l2)
     * where l1 is the length of str1, l2 is the length of str2.
     *
     * TODO: 充分性证明没看懂
     * https://leetcode-cn.com/problems/greatest-common-divisor-of-strings/solution/zi-fu-chuan-de-zui-da-gong-yin-zi-by-leetcode-solu/
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Greatest Common Divisor of Strings.
     * Memory Usage: 38.3 MB, less than 100.00% of Java online submissions for Greatest Common Divisor of Strings.
     *
     * @param str1 String, one string
     * @param str2 String, the other string
     * @return String, the greatest common divisor of strings
     */
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    public int gcd(int a, int b) {
        if (a < b) {
            return gcd(b, a);
        }
        return b > 0 ? gcd(b, a % b) : a;
    }
}