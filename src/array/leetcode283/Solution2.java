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
public class Solution2 {
    public void moveZeroes(int[] nums) {
        // 1. 将数组中所有非零元素按照它们本来的顺序移动到数组前面
        //    时间复杂度：O(n)
        int index = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }

        // 2. 将非零元素之外的所有元素设为0
        //    时间复杂度：O(n)
        for (int i = index; i < nums.length; ++i) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        System.out.println(Arrays.toString(nums));
        Solution2 solution = new Solution2();
        solution.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
