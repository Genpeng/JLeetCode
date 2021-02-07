package c08_dp.lc0152_maximum_product_subarray;

/**
 * This is the solution of No. 152 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/maximum-product-subarray/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number)
 * which has the largest product.
 *
 * Example 1:
 *
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 *
 * Example 2:
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 * ==========================================================================================================
 *
 * Difficulty: Medium
 * Tags: array;dp;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] dpMax = new int[n];
        int[] dpMin = new int[n];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        int maxProduct = nums[0];
        for (int i = 1; i < n; ++i) {
            dpMax[i] = max(nums[i], dpMax[i-1] * nums[i], dpMin[i-1] * nums[i]);
            dpMin[i] = min(nums[i], dpMax[i-1] * nums[i], dpMin[i-1] * nums[i]);
            maxProduct = Math.max(maxProduct, dpMax[i]);
        }
        return maxProduct;
    }

    private int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}