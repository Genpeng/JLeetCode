package c01_array.lc0066_plus_one;

import util.PrintUtil;

/**
 * This is the solution of No. 66 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/plus-one/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list, and each element
 * in the array contain a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 *
 * Example 2:
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * ==========================================================================================================
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2018/12/27
 */
public class Solution1 {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; --i) {
            if (digits[i] < 9) {
                ++digits[i];
                return digits;
            }
            digits[i] = 0;
        }
        digits = new int[n + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        int[] digits = {9, 9, 9};
        PrintUtil.printArray((new Solution1()).plusOne(digits));
    }
}
