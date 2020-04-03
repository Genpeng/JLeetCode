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
public class Solution1 {
    /**
     * Approach 1: Enumerate
     * Time complexity: O(CA(l1, l2) * (l1 + l2))
     * Space complexity: O(l1 + l2)
     * where `CA(a, b)` represents the common divisors of `a` and `b`, and l1 is the length of str1,
     * l2 is the length of str2.
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Greatest Common Divisor of Strings.
     * Memory Usage: 38.3 MB, less than 100.00% of Java online submissions for Greatest Common Divisor of Strings.
     *
     * @param str1 String, one string
     * @param str2 String, the other string
     * @return String, the greatest common divisor of strings
     */
    public String gcdOfStrings(String str1, String str2) {
        int l1 = str1.length(), l2 = str2.length();
        for (int i = Math.min(l1, l2); i >= 1; --i) {
            if (l1 % i == 0 && l2 % i == 0) {
                String subStr = str1.substring(0, i);
                if (isNTimes(subStr, str1) && isNTimes(subStr, str2)) {
                    return subStr;
                }
            }
        }
        return "";
    }

    /**
     * Check if the `s` is n times concatenations of `prefix`.
     * Time complexity: O(N)
     * Space complexity: O(N)
     * where N is the length of string `s`.
     *
     * @param prefix String, prefix string
     * @param s String, the longer string
     * @return boolean, true if `s` is n times concatenations of `prefix`
     */
    private boolean isNTimes(String prefix, String s) {
        int n = s.length() / prefix.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; ++i) {
            sb.append(prefix);
        }
        return sb.toString().equals(s);
    }

    public static void main(String[] args) {
        String a = "ABCABC", b = "ABC";
        Solution1 solution = new Solution1();
        System.out.println(solution.gcdOfStrings(a, b));
    }
}