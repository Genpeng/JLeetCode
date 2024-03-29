package c07_math_and_digit.lc0069_sqrt_x;

/**
 * This is the solution of No. 69 problem in the LeetCode,
 * the website of the problem is as follows:
 * https://leetcode.cn/problems/sqrtx/description/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned
 * integer should be non-negative as well.
 *
 * You must not use any built-in exponent function or operator.
 *
 * For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 *
 * Example 1:
 * Input: x = 4
 * Output: 2
 * Explanation: The square root of 4 is 2, so we return 2.
 *
 * Example 2:
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since we round it down to the nearest integer, 2 is returned.
 *
 * Constraints:
 * - 0 <= x <= 231 - 1
 * ==========================================================================================================
 *
 * Difficulty: Easy
 * Tags: math; binary search;
 *
 * @author  Lukas (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * 题意：
     * - 求出非负整数 x 平方根的整数部分
     *
     * 解法1：袖珍计算器算法（指数和对数数学函数代替）
     * sqrt(x) = x ^ 0.5 = (e^ln(x)) ^ 0.5 = e ^ (0.5 * ln(x))
     * 时间复杂度：O(1)
     * 空间复杂度：O(1)
     *
     * @param x int, non-negative integer
     * @return int, the nearest integer of square root of x
     */
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int ans = (int) Math.exp(0.5 * Math.log(x));
        return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }
}