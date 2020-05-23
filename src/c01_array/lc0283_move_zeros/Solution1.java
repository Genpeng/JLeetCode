package c01_array.lc0283_move_zeros;

import java.util.Arrays;

/**
 * This is the solution of No. xxx problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/move-zeroes/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an array nums, write a function to move all 0's to the end of it
 * while maintaining the relative order of the non-zero elements.
 *
 * Example:
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 *
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 * ==========================================================================================================
 *
 * Tags: slow & fast pointers;
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2018/12/07
 */
public class Solution1 {
    /**
     * Approach 1: Make a copy
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param nums int[], the input integer array
     */
    public void moveZeroes(int[] nums) {
        final int N = nums.length;
        int[] tmp = new int[N];
        int idx = 0;
        for (int num : nums) {
            if (num != 0) {
                tmp[idx++] = num;
            }
        }
        for (int i = 0; i < N; ++i) {
            nums[i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        System.out.println(Arrays.toString(nums));
        Solution1 solution = new Solution1();
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
