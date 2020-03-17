package dp.lc0322_coin_change;

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
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution2 {
    private int ans;

    /**
     * Approach 2: Greedy + DFS
     * Time Complexity: xxx
     * Space Complexity: xxx
     * where S is the amount to change, and n is the number of coins
     *
     * @param coins int[], coins of different denominations
     * @param amount int, target amount of money
     * @return int, the fewest number of coins that you need to make up that amount, and return -1 if it
     *              does not exist any combination of coins
     */
    public int coinChange(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (coins.length == 0) {
            return -1;
        }
        Arrays.sort(coins);
        ans = Integer.MAX_VALUE;
        coinChange(coins, amount, coins.length - 1, 0);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    /**
     *
     *
     * @param coins
     * @param amount
     * @param ei
     * @param count
     */
    private void coinChange(int[] coins, int amount, int ei, int count) {
        if (ei < 0) {
            return;
        }
        for (int k = amount / coins[ei]; k >= 0; --k) {
            int remain = amount - k * coins[ei];
            int newCount = count + k;
            if (remain == 0) {
                ans = Math.min(ans, newCount);
                return;
            }
            if (newCount + 1 >= ans) {
                return;
            }
            coinChange(coins, remain, ei - 1, newCount);
        }
    }

    public static void main(String[] args) {
        int[] coins = new int[] {1, 2, 5};
        int amount = 11;
        Solution2 solution = new Solution2();
        System.out.println(solution.coinChange(coins, amount));
    }
}