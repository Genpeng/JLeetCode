package c07_math_and_digit.lc0231_power_of_two;

/**
 * This is the solution of No. 231 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/power-of-two/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an integer, write a function to determine if it is a power of two.
 *
 * Example 1:
 * Input: 1
 * Output: true
 * Explanation: 20 = 1
 *
 * Example 2:
 * Input: 16
 * Output: true
 * Explanation: 24 = 16
 *
 * Example 3:
 * Input: 218
 * Output: false
 * ==========================================================================================================
 *
 * Difficulty: Easy
 * Tags: math;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * Approach 1: Iteration
     * If a number is a power of two, then the highest digit is 1, and other digits are 0.
     *
     * Complexity Analysis:
     * Time Complexity: O(log(n))
     * Space Complexity: O(1)
     *
     * @param n int, an integer
     * @return boolean, true if the integer is a power of two
     */
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        int n = 1;
        Solution1 solution = new Solution1();
        System.out.println(solution.isPowerOfTwo(n));
    }
}