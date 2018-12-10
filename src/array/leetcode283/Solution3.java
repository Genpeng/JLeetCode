package array.leetcode283;

import java.util.Arrays;

/**
 * This is the solution of No. 283 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/move-zeroes/
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
