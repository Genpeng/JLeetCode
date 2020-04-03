package c08_dp.lc0322_coin_change;

import java.util.Arrays;

/**
 * This is the solution of No. 322 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/coin-change/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 * <p>
 * Example 1:
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * <p>
 * Example 2:
 * Input: coins = [2], amount = 3
 * Output: -1
 * <p>
 * Note:
 * - You may assume that you have an infinite number of each kind of coin.
 * ==========================================================================================================
 *
 * Tags: dp
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution3 {
    /**
     * Approach 3: Dynamic Programming
     * Time Complexity: O(S * n)
     * Space Complexity: O(S)
     * where S is the amount to change, and n is the number of coins
     *
     * The state transition equation is:
     *         / -1, S < 0
     * F(S) =  - 0, S = 0
     *         \ min{F(S - ci) + 1, i = 0, 1, ..., n-1}, S > 0
     * where F(S) represents the minimum number of coins to make change for amount S
     *
     * Runtime: 9 ms, faster than 97.00% of Java online submissions for Coin Change.
     * Memory Usage: 40.9 MB, less than 5.33% of Java online submissions for Coin Change.
     *
     * @param coins int[], coins of different denominations
     * @param amount int, target amount of money
     * @return int, the fewest number of coins that you need to make up that amount, and return -1 if it
     *              does not exist any combination of coins
     */
    public int coinChange(int[] coins, int amount) {
//        int[] dp = new int[amount+1];
//        Arrays.fill(dp, amount+1);
//        dp[0] = 0;
//        for (int i = 1; i <= amount; ++i) {
//            for (int coin : coins) {
//                if (i >= coin) {
//                    dp[i] = Math.min(dp[i], dp[i-coin] + 1);
//                }
//            }
//        }
//        return dp[amount] == amount + 1 ? -1 : dp[amount];

        // write a little faster as follow:
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for (int i = 1; i <= amount; ++i) {
            int minNum = amount;
            for (int coin : coins) {
                if (i >= coin) {
                    minNum = Math.min(minNum, dp[i-coin]);
                }
            }
            dp[i] = minNum + 1;
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    // ================================================================================================ //
    // 以下是最终写出迭代的动态规划解法的思考过程，即从暴力递归到带备忘录的递归。

    /**
     * Recursive
     * Time Complexity: O(k * k^n)
     * Space Complexity: O(n)
     * where k represents the number of coins, and n is the depth of recursion tree
     *
     * The state transition equation is:
     *         / -1, S < 0
     * F(S) =  - 0, S = 0
     *         \ min{F(S - ci) + 1, i = 0, 1, ..., n-1}, S > 0
     * where F(S) represents the minimum number of coins to make change for amount S
     *
     * @param coins int[], coins of different denominations
     * @param amount int, target amount of money
     * @return int, the fewest number of coins that you need to make up that amount, and return -1 if it
     *              does not exist any combination of coins
     */
    public int coinChangeV1(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        int minNum = Integer.MAX_VALUE;
        for (int coin : coins) {
            int sub = coinChangeV1(coins, amount - coin);
            if (sub >= 0 && sub + 1 < minNum) {
                minNum = sub + 1;
            }
        }
        return minNum == Integer.MAX_VALUE ? -1 : minNum;
    }

    /**
     * Recursive with memorization
     * Time Complexity: O(S * n)
     * Space Complexity: O(S)
     * where S is the amount to change, and n is the number of coins
     *
     * The state transition equation is:
     *         / -1, S < 0
     * F(S) =  - 0, S = 0
     *         \ min{F(S - ci) + 1, i = 0, 1, ..., n-1}, S > 0
     * where F(S) represents the minimum number of coins to make change for amount S
     *
     * Runtime: 25 ms, faster than 26.61% of Java online submissions for Coin Change.
     * Memory Usage: 41.4 MB, less than 5.33% of Java online submissions for Coin Change.
     *
     * @param coins int[], coins of different denominations
     * @param amount int, target amount of money
     * @return int, the fewest number of coins that you need to make up that amount, and return -1 if it
     *              does not exist any combination of coins
     */
    public int coinChangeV2(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -2);
        dp[0] = 0;
        return coinChangeV2(coins, amount, dp);
    }

    private int coinChangeV2(int[] coins, int amount, int[] memo) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (memo[amount] != -2) {
            return memo[amount];
        }
        int minNum = Integer.MAX_VALUE;
        for (int coin : coins) {
            int sub = coinChangeV2(coins, amount - coin, memo);
            if (sub >= 0 && sub + 1 < minNum) {
                minNum = sub + 1;
            }
        }
        memo[amount] = minNum == Integer.MAX_VALUE ? -1 : minNum;
        return memo[amount];
    }

    public static void main(String[] args) {
        int[] coins = new int[] {1, 2, 5};
        int amount = 11;
        Solution3 solution = new Solution3();
        System.out.println(solution.coinChange(coins, amount));
    }
}