package array.lc0238_product_of_array_except_self;

import java.util.Arrays;

/**
 * This is the solution of No. 238 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/product-of-array-except-self/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to
 * the product of all the elements of nums except nums[i].
 *
 * Example:
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Note: Please solve it without division and in O(n).
 *
 * Follow up:
 * - Could you solve it with constant space complexity? (The output array does not count as extra space
 *   for the purpose of space complexity analysis.)
 * ==========================================================================================================
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * 解法1：Left and Right product lists
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Product of Array Except Self.
     * Memory Usage: 47.7 MB, less than 5.51% of Java online submissions for Product of Array Except Self.
     *
     * @param nums int[], the input integer array
     * @return int[], an array such that output[i] is equal to the product of all the elements
     *                of nums except nums[i].
     */
    public int[] productExceptSelt(int[] nums) {
        int n = nums.length;
        // Step 1: calculate L[i], where L[i] contains the product of all the elements to the left of i, O(n)
        int[] L = new int[n];
        L[0] = 1;
        for (int i = 1; i < n; ++i) {
            L[i] = L[i-1] * nums[i-1];
        }
        // Step 2: calculate R[i], where R[i] contains the product of all the elements to the right of i, O(n)
        int[] R = new int[n];
        R[n-1] = 1;
        for (int i = n - 2; i >= 0; --i) {
            R[i] = R[i+1] * nums[i+1];
        }
        // Step3: construct the answer array, where ans[i] = L[i] * R[i]
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            ans[i] = L[i] * R[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4};
        Solution1 solution = new Solution1();
        int[] ans = solution.productExceptSelt(nums);
        System.out.println(Arrays.toString(ans));
    }
}