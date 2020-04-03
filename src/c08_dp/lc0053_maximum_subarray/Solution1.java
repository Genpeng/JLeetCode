package c08_dp.lc0053_maximum_subarray;

/**
 * This is the solution of No. 53 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/maximum-subarray/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 * <p>
 * Example:
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * <p>
 * Follow up:
 * - If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach,
 * which is more subtle.
 * ==========================================================================================================
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * Approach 1: Dynamic programming
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * State transition equation:
     *           / A[0], n = 0
     * F(A, n) =
     *           \ max(F(A, n-1), 0) + A[n] or max(F(A, n-1) + A[n], A[n]), n > 0
     * where F(A, n) represents the max sum of subarray A[:n] which must contains A[n] as the last element
     *
     * Runtime: 1 ms, faster than 85.31% of Java online submissions for Maximum Subarray.
     * Memory Usage: 41.8 MB, less than 5.16% of Java online submissions for Maximum Subarray.
     *
     * @param nums int[], the input integer
     * @return int, the largest sum of all the contiguous subarray
     */
    public int maxSubArrayV2(int[] nums) {
        int n = nums.length;
        int[] dp  = new int[n];
        dp[0] = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < n; ++i) {
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            maxSum = Math.max(dp[i], maxSum);
        }
        return maxSum;
    }

    /**
     * Approach 1: Dynamic programming (or Kadane's algorithm)
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * State transition equation:
     *           / A[0], n = 0
     * F(A, n) =
     *           \ max(F(A, n-1), 0) + A[n] or max(F(A, n-1) + A[n], A[n]), n > 0
     * where F(A, n) represents the max sum of subarray A[:n] which must contains A[n] as the last element
     *
     * Runtime: 1 ms, faster than 85.31% of Java online submissions for Maximum Subarray.
     * Memory Usage: 41.7 MB, less than 5.16% of Java online submissions for Maximum Subarray.
     *
     * @param nums int[], the input integer
     * @return int, the largest sum of all the contiguous subarray
     */
    public int maxSubArrayV3(int[] nums) {
        int currSum = nums[0], maxSum = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            currSum = Math.max(currSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;

        // or write as follow:
//        int currSum = nums[0], maxSum = nums[0];
//        for (int i = 1; i < nums.length; ++i) {
//            currSum = Math.max(currSum, 0) + nums[i];
//            maxSum = Math.max(maxSum, currSum);
//        }
//        return maxSum;
    }

    // ==================================================================================================== //
    // 以下是如何写出上面最终动态规划解法的思考过程，即从暴力递归到带备忘录的递归，从而最终写出上面的迭代的动态规划解法。
    // 备注：由于并不存在重叠子结构，所以并不需要带备忘录的递归解法。

    private int maxSum = Integer.MIN_VALUE;

    /**
     * Recursive approach
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * State transition equation:
     *           / A[0], n = 0
     * F(A, n) =
     *           \ max(F(A, n-1), 0) + A[n] or max(F(A, n-1) + A[n], A[n]), n > 0
     * where F(A, n) represents the max sum of subarray A[:n] which must contains A[n] as the last element
     *
     * Runtime: 1 ms, faster than 85.31% of Java online submissions for Maximum Subarray.
     * Memory Usage: 43.6 MB, less than 5.16% of Java online submissions for Maximum Subarray.
     *
     * @param nums int[], the input integer
     * @return int, the largest sum of all the contiguous subarray
     */
    public int maxSubArrayV1(int[] nums) {
        helper(nums, nums.length - 1);
        return maxSum;
    }

    /**
     * The auxiliary function of the recursive approach.
     *
     * @param nums int[], the input integer
     * @param n    int, the index of last element
     * @return int, the largest sum of subarray `nums[:n]`, which must have `nums[n]` as the last element
     */
    public int helper(int[] nums, int n) {
        if (n == 0) {
            maxSum = nums[0];
            return nums[0];
        }
        int currSum = Math.max(helper(nums, n - 1) + nums[n], nums[n]);
        maxSum = Math.max(maxSum, currSum);
        return currSum;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums2 = new int[] {1};
        Solution1 solution = new Solution1();
        System.out.println(solution.maxSubArrayV3(nums1));
        System.out.println(solution.maxSubArrayV3(nums2));
    }
}