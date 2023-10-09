package c08_dp.lc0122_best_time_to_buy_and_sell_stock_ii;

/**
 * This is the solution of No. 122 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * Say you have an array prices for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e.,
 * buy one and sell one share of the stock multiple times).
 * <p>
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock
 * before you buy again).
 * <p>
 * Example 1:
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * <p>
 * Example 2:
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 * engaging multiple transactions at the same time. You must sell before buying again.
 * <p>
 * Example 3:
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 * <p>
 * Constraints:
 * - 1 <= prices.length <= 3 * 10 ^ 4
 * - 0 <= prices[i] <= 10 ^ 4
 * ==========================================================================================================
 * <p>
 * Difficulty: Easy
 * Tags: greedy algorithm;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    private int ans;

    /**
     * 题意：
     * - 已知一只股票每天的价格
     * - 每天可以买卖股票的一股
     * - 最多只能持有一股
     * - 交易频次为 T0，即支持当天买后，立即卖出
     *
     * 思路：
     * 求出股票的所有上升趋势
     *
     * Approach 1: Brute Force (backtracking)
     *
     * Complexity Analysis:
     * Time Complexity: O(2 ^ N)
     * Space Complexity: O(N)
     *
     * @param prices int[], the prices of a given stock
     * @return int, the maximum profit
     */
    public int maxProfit(int[] prices) {
        ans = 0;
        dfs(prices, 0, 0, 0);
        return ans;
    }

    private void dfs(int[] prices, int i, int status, int profit) {
        if (i == prices.length) {
            ans = Math.max(ans, profit);
            return;
        }
        // 可以选择保持状态不变
        dfs(prices, i + 1, status, profit);
        // 也可以选择改变状态
        if (status == 0) {
            // 如果之前的状态为「持有现金」，可以选择买入股票
            dfs(prices, i + 1, 1, profit - prices[i]);
        } else {
            // 如果之前的状态为「持有股票」，可以选择卖出股票
            dfs(prices, i + 1, 0, profit + prices[i]);
        }
    }

    public static void main(String[] args) {
        Solution1 solu = new Solution1();
        System.out.println(solu.maxProfit(new int[]{7, 1, 5, 3, 6, 4}) == 7);
        System.out.println(solu.maxProfit(new int[]{1, 2, 3, 4, 5}) == 4);
        System.out.println(solu.maxProfit(new int[]{7, 6, 4, 3, 1}) == 0);
    }
}