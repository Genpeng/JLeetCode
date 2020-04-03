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
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2018/12/07
 */
public class Solution1 {
    public void moveZeroes(int[] nums) {
        // 1. 生成一个长度相同、元素都是0的数组
        //    时间复杂度：O(n)
        int[] tmp = new int[nums.length];

        // 2. 将数组nums中非零元素按照先后顺序依次存储到新的数组temp中
        //    时间复杂度：O(n)
        int idx = 0;
        for (int num : nums) {
            if (num != 0) {
                tmp[idx++] = num;
            }
        }

        // 3. 用temp数组覆盖原数组nums
        //    时间复杂度：O(n)
        for (int i = 0; i < nums.length; ++i) {
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
