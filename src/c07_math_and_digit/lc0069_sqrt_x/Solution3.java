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
public class Solution3 {
    /**
     * 题意：
     * - 求出非负整数 x 平方根的整数部分
     *
     * 解法3：牛顿迭代
     * 时间复杂度：O(log(x))
     * 空间复杂度：O(1)
     *
     * @param x int, non-negative integer
     * @return int, the nearest integer of square root of x
     */
    public int mySqrt(int x) {
        // 牛顿迭代法的思路：
        // 选定一个起始点，过起始点做一条切线，切线与横轴的交点为下一个迭代点，如此循环往复，直到相邻两个点的差异小于阈值

        // 平方根：
        // f(x) = x^2 - C
        // f(x0) = f'(x0) * (x - x0) + f(x0)
        //       = 2 * x0 * (x - x0) + x0^2 - C
        // 更新公式：
        // x1 <- x0 - (x0^2 - C) / (2 * x0) = (x0 + C/x0) / 2

        // 一种写法
        if (x == 0) {
            return x;
        }
        double guess = x;
        while (Math.abs(guess * guess - x) > 1e-6) {
            guess = (guess + x/guess) / 2;
        }
        return (int) guess;

        // 另一种写法
//        if (x == 0) {
//            return 0;
//        }
//        double x0 = x; // x0 表示初始值
//        while (true) {
//            double x1 = 0.5 * (x0 + x / x0);
//            if (Math.abs(x1 - x0) < 1e-6) {
//                break;
//            }
//            x0 = x1;
//        }
//        return (int) x0;
    }
}