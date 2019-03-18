package lc283;

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
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2018/12/07
 */
public class Solution3 {
    public void moveZeroes(int[] nums) {
        for (int slow = 0, fast = 0; fast < nums.length; ++fast) {
            if (nums[fast] != 0) {
                int temp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = temp;
                ++slow;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 1};
        System.out.println(Arrays.toString(nums));
        Solution3 solution = new Solution3();
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
