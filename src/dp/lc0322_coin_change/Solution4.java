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
public class Solution4 {
    private int result;

    public void coin(int[] coins, int amount, int count, int pick) {
        for (int i = pick; i >= 0; i--) {
            if (result != -1 && count >= result) {
                return;
            }
            if (amount - coins[i] == 0) {
                if (result == -1 || result > count) {
                    result = count;
                }
                return;
            } else if (amount - coins[i] > 0) {
                if (result != -1 && (count >= result - 1 || amount - coins[i] * (result - count) > 0)) {
                    return;
                }
                coin(coins, amount - coins[i], count + 1, i);
            }
        }
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        result = -1;
        Arrays.sort(coins);
        coin(coins, amount, 1, coins.length - 1);
        return result;
    }
}