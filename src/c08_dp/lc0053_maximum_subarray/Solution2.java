package c08_dp.lc0053_maximum_subarray;

/**
 * This is the solution of No. 53 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/maximum-subarray/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 *
 * Example:
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 * Follow up:
 * - If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach,
 *   which is more subtle.
 * ==========================================================================================================
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution2 {
    /**
     * Approach 2: Divide and conquer
     * Time complexity: O(N * log(N))
     * Space complexity: O(log(N))
     *
     * Runtime: 2 ms, faster than 14.24% of Java online submissions for Maximum Subarray.
     * Memory Usage: 41.6 MB, less than 5.16% of Java online submissions for Maximum Subarray.
     *
     * @param nums int[], the input integer
     * @return int, the largest sum of all the contiguous subarray
     */
    public int maxSubArray(int[] nums) {
        return maxSubArray(nums, 0, nums.length - 1);
    }

    /**
     * The maximum sum of subarray which starts at `li` index and ends at `ri` index.
     *
     * @param nums int[], input integer array
     * @param li int, left bound
     * @param ri int, right bound
     * @return int, the maximum sum of subarray
     */
    private int maxSubArray(int[] nums, int li, int ri) {
        if (li == ri) {
            return nums[li];
        }
        int mi = li + (ri - li) / 2;
        int leftMax = maxSubArray(nums, li, mi);
        int rightMax = maxSubArray(nums, mi + 1, ri);
        int midMax = maxCrossSum(nums, li, ri, mi);
        return Math.max(Math.max(leftMax, rightMax), midMax);
    }

    /**
     * The maximum sum of subarray which starts at `li` index and ends at `ri` index, and
     * must contain index `mi` as the intermediate element.
     *
     * @param nums int[], input integer array
     * @param li int, left bound
     * @param ri int, right bound
     * @param mi int, the intermediate index which must be contained
     * @return int, the maximum sum of subarray
     */
    private int maxCrossSum(int[] nums, int li, int ri, int mi) {
        int leftMax = Integer.MIN_VALUE;
        for (int i = mi, s = 0; i >= li; --i) {
            s += nums[i];
            leftMax = Math.max(leftMax, s);
        }
        int rightMax = Integer.MIN_VALUE;
        for (int i = mi + 1, s = 0; i <= ri; ++i) {
            s += nums[i];
            rightMax = Math.max(rightMax, s);
        }
        return leftMax + rightMax;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums2 = new int[] {1};
        Solution2 solution = new Solution2();
        System.out.println(solution.maxSubArray(nums1));
        System.out.println(solution.maxSubArray(nums2));
    }
}