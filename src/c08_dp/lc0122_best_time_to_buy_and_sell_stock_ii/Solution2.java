package c08_dp.lc0122_best_time_to_buy_and_sell_stock_ii;

/**
 * This is the solution of No. 122 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Say you have an array prices for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e.,
 * buy one and sell one share of the stock multiple times).
 *
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock
 * before you buy again).
 *
 * Example 1:
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 *              Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 *
 * Example 2:
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 *              Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 *              engaging multiple transactions at the same time. You must sell before buying again.
 *
 * Example 3:
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 *
 * Constraints:
 * - 1 <= prices.length <= 3 * 10 ^ 4
 * - 0 <= prices[i] <= 10 ^ 4
 * ==========================================================================================================
 *
 * Difficulty: Easy
 * Tags: greedy algorithm;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution2 {

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
     * Approach 2: Greedy Algorithm
     *
     * Complexity Analysis:
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     *
     * @param prices int[], the prices of a given stock
     * @return int, the maximum profit
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; ++i) {
            int profit = prices[i] - prices[i-1]; // 现实中不可能等今天价格比昨天高，再买入昨天的吧
            if (profit > 0) {
                maxProfit += profit;
            }
        }
        return maxProfit;
    }
}