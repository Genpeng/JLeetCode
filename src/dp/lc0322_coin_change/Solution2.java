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
 * Tags: dp
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution2 {
    private int ans;

    // 这道题需要处理3种边界情况：
    // 1. amount = 0
    // 2. amount < 0
    // 3. coins.length = 0

    /**
     * Approach 2: Greedy + DFS
     * Time Complexity: O(S ^ n)
     * Space Complexity: O(n)
     * where S is the amount to change, and n is the number of coins
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
        if (coins.length == 0) {
            return -1;
        }
        Arrays.sort(coins);
        ans = Integer.MAX_VALUE;
        coinChangeV1(coins, amount, coins.length - 1, 0);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private void coinChangeV1(int[] coins, int amount, int ei, int count) {
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
            coinChangeV1(coins, remain, ei - 1, newCount);
        }
    }

    /**
     * Approach 2: Greedy + DFS
     * Time Complexity: O(S ^ n)
     * Space Complexity: O(n)
     * where S is the amount to change, and n is the number of coins
     *
     * @param coins int[], coins of different denominations
     * @param amount int, target amount of money
     * @return int, the fewest number of coins that you need to make up that amount, and return -1 if it
     *              does not exist any combination of coins
     */
    public int coinChangeV2(int[] coins, int amount) {
        Arrays.sort(coins);
        ans = Integer.MAX_VALUE;
        coinChangeV2(coins, amount, coins.length - 1, 0);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private void coinChangeV2(int[] coins, int amount, int ei, int count) {
        if (amount == 0) {
            ans = Math.min(ans, count);
            return;
        }
        if (ei < 0) { // amount < 0 的情况也能处理
            return;
        }
        for (int k = amount / coins[ei]; k >= 0 && k + count < ans; --k) {
            coinChangeV2(coins, amount - k * coins[ei], ei - 1, k + count);
        }
    }

    public static void main(String[] args) {
        int[] coins = new int[] {1, 2, 5};
        int amount = 11;
        int[] coins2 = {429, 171, 485, 26, 381, 31, 290};
        int amount2 = 8440;
        Solution2 solution = new Solution2();
        System.out.println(solution.coinChangeV2(coins2, amount2));
    }
}