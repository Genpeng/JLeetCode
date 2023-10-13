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
public class Solution4 {
    /**
     * 题意：
     * - 只能进行一次买卖
     * - 交易频次为 T+1，即不允许当天买卖
     *
     * 思路：
     * - 找到差值最大的间隔（📢 注意，并不是最大值减最小值，比如：[7,1,5,3,6,4]）
     *
     * Approach 4: Greedy Algorithm
     * 因为只能买卖一次，因此只能在最低点买，然后在最低点之后的高点卖。所以，首先找到最低点，
     * 然后遇到比最低点高的值时，更新最大收益。特殊情况，如果序列是单调递减的，这时选择不卖，
     * 也就是最大收益为 0.
     *
     * [20230814] 更新理解
     * 最大利润并不一定发生在最小值，以及最小值之后的元素组成的区间中，还有可能发生在次最小值，
     * 以及其之后的元素组成的区间中。即我们其实要找到一段差值最大的上升趋势。
     *
     * Complexity Analysis:
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * Result of Submission:
     * Runtime: 1 ms, faster than 95.18% of Java online submissions for Best Time to Buy and Sell Stock.
     * Memory Usage: 42.7 MB, less than 5.31% of Java online submissions for Best Time to Buy and Sell Stock.
     *
     * @param prices int[], the price of a given stock on each day
     * @return int, the max profit
     */
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE, maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = new int[] {7, 1, 5, 3, 6, 4};
        Solution4 solution = new Solution4();
        System.out.println(solution.maxProfit(prices));
    }
}