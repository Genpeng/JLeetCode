package c08_dp.lc0121_best_time_to_buy_and_sell_stock;

/**
 * This is the solution of No. 121 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock),
 * design an algorithm to find the maximum profit.
 *
 * Note that you cannot sell a stock before you buy one.
 *
 * Example 1:
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *              Not 7-1 = 6, as selling price needs to be larger than buying price.
 *
 * Example 2:
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 * ==========================================================================================================
 *
 * Difficulty: Easy
 * Tags: dp;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution2 {
    /**
     * 题意：
     * - 只能进行一次买卖
     * - 交易频次为 T+1，即不允许当天买卖
     *
     * 思路：
     * - 找到差值最大的间隔（📢 注意，并不是最大值减最小值，比如：[7,1,5,3,6,4]）
     *
     * Approach 2: Dynamic Programming
     * 令 dp[i] 表示到第 i 天为止的最大利润，则有
     *         / max(dp[i-1], prices[i] - minPrice), i > 0
     * dp[i] =
     *         \ 0, i = 0
     *
     * Complexity Analysis:
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * @param prices int[], the price of a given stock on each day
     * @return int, the max profit
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        int minPrice = prices[0];
        for (int i = 1; i < n; ++i) {
            minPrice = Math.min(minPrice, prices[i]);
            dp[i] = Math.max(dp[i-1], prices[i] - minPrice);
        }
        return dp[n-1];
    }

    /**
     * Approach 2: Dynamic Programming
     * 令 dp[i] 表示到第 i 天为止的最大利润，则有
     *         / max(dp[i-1], prices[i] - minPrice), i > 0
     * dp[i] =
     *         \ 0, i = 0
     *
     * Complexity Analysis:
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * @param prices int[], the price of a given stock on each day
     * @return int, the max profit
     */
    public int maxProfitV2(int[] prices) {
        int n = prices.length;
        if (n < 2) {
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = 0; // 可去掉
        int minPrice = prices[0]; // 表示到当前位置之前的最小价格
        for (int i = 1; i < n; ++i) {
            dp[i] = Math.max(dp[i-1], prices[i] - minPrice);
            minPrice = Math.min(minPrice, prices[i]); // 更新价格
        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.maxProfit(new int[] {7, 1, 5, 3, 6, 4}) == 5);
    }
}