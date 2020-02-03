package string.lc0008_string_to_integer_atoi;

/**
 * This is the solution of No. 8 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/string-to-integer-atoi/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Implement atoi which converts a string to an integer.
 *
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character
 * is found. Then, starting from this character, takes an optional initial plus or minus sign followed by
 * as many numerical digits as possible, and interprets them as a numerical value.
 *
 * The string can contain additional characters after those that form the integral number, which are ignored
 * and have no effect on the behavior of this function.
 *
 * If the first sequence of non-whitespace characters in str is not a valid integral number,
 * or if no such sequence exists because either str is empty or it contains only whitespace characters,
 * no conversion is performed.
 *
 * If no valid conversion could be performed, a zero value is returned.
 *
 * Note:
 * - Only the space character ' ' is considered as whitespace character.
 * - Assume we are dealing with an environment which could only store integers within
 *   the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of
 *   representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
 *
 * Example 1:
 * Input: "42"
 * Output: 42
 *
 * Example 2:
 * Input: "   -42"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is the minus sign.
 *              Then take as many numerical digits as possible, which gets 42.
 *
 * Example 3:
 * Input: "4193 with words"
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
 *
 * Example 4:
 * Input: "words and 987"
 * Output: 0
 * Explanation: The first non-whitespace character is 'w', which is not a numerical
 *              digit or a +/- sign. Therefore no valid conversion could be performed.
 *
 * Example 5:
 * Input: "-91283472332"
 * Output: -2147483648
 * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
 *              Thefore INT_MIN (−231) is returned.
 * ==========================================================================================================
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution {
    public int myAtoi(String str) {
        if (str == null) {
            throw new IllegalArgumentException("[ERROR] The input string is null!!!");
        }
        int sign = 1, base = 0, i = 0;
        // remove whitespace character in the front of string
        while (i < str.length() && str.charAt(i) == ' ') {
            ++i;
        }
        // if the input string is empty or it contains only whitespace characters
        if (i >= str.length()) {
            return 0;
        }
        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
            sign = str.charAt(i++) == '-' ? -1 : 1;
        }
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > 7)) {
                return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            base = base * 10 + (str.charAt(i++) - '0');
        }
        return sign * base;
    }
}