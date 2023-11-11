package c02_string.lc0415_add_strings;

/**
 * This is the solution of No. 415 problem in the LeetCode,
 * the website of the problem is as follows:
 * https://leetcode.com/problems/add-strings/description/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.
 *
 * You must solve the problem without using any built-in library for handling large integers (such as BigInteger).
 * You must also not convert the inputs to integers directly.
 *
 * Example 1:
 * Input: num1 = "11", num2 = "123"
 * Output: "134"
 *
 * Example 2:
 * Input: num1 = "456", num2 = "77"
 * Output: "533"
 *
 * Example 3:
 * Input: num1 = "0", num2 = "0"
 * Output: "0"
 *
 * Constraints:
 * - 1 <= num1.length, num2.length <= 104
 * - num1 and num2 consist of only digits.
 * - num1 and num2 don't have any leading zeros except for the zero itself.
 * ==========================================================================================================
 *
 * Difficulty: Easy
 * Tags: string;
 *
 * @author  Lukas (xgp1227atgmail.com)
 */
public class Solution1 {
    public String addStrings(String num1, String num2) {
        // 题意：
        // - 将两个非负整数字符串相加，结果同样以字符串返回

        // 解法1：模拟整数求和过程
        // 时间复杂度：O(max(m, n))
        // 空间复杂度：O(1)

        int L1 = num1.length(), L2 = num2.length();
        int i = L1 - 1, j = L2 - 1;
        int carry = 0;
        int s;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || carry > 0) {
            s = carry;
            s += i >= 0 ? num1.charAt(i) - '0' : 0;
            s += j >= 0 ? num2.charAt(j) - '0' : 0;
            sb.append(s % 10);
            // update to next iteration
            carry = s / 10;
            --i;
            --j;
        }
        return sb.reverse().toString();
    }
}