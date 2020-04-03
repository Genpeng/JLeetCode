package c08_dp.lc0070_climbing_stairs;

/**
 * This is the solution of No. 70 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/climbing-stairs/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Note: Given n will be a positive integer.
 *
 * Example 1:
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 *
 * Example 2:
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * ==========================================================================================================
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2019/07/15
 */
public class Solution6 {
    /**
     * 解法六：Fibonacci Formula
     * Reference: https://leetcode.com/articles/climbing-stairs/
     *
     * 时间复杂度：O(log(n))
     * 空间复杂度：O(1)
     *
     * @param n int, the number of steps to reach to the top of the stair
     * @return int, the number of distinct ways you can climb to the top
     */
    public int climbStairs(int n) {
        // TODO: Refill not finished
        return 0;
    }

    public static void main(String[] args) {
        int n = 10;
        Solution6 solution = new Solution6();
        long startTime = System.currentTimeMillis();
        int res = solution.climbStairs(n);
        long endTime = System.currentTimeMillis();
        System.out.format("climbStairs(%d) = %d\n", n, res);
        System.out.format("[INFO] Done in %f seconds.\n", (endTime - startTime) / 1000.0);
    }
}