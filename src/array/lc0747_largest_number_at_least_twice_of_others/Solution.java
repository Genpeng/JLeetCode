package array.lc0747_largest_number_at_least_twice_of_others;

/**
 * This is the solution of No. 747 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/largest-number-at-least-twice-of-others/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * In a given integer array `nums`, there is always exactly one largest element.
 *
 * Find whether the largest element in the array is at least twice as much as every other number in the array.
 *
 * If it is, return the **index** of the largest element, otherwise return -1.
 *
 * Example 1:
 * Input: nums = [3, 6, 1, 0]
 * Output: 1
 * Explanation: 6 is the largest integer, and for every other number in the array x,
 * 6 is more than twice as big as x.  The index of value 6 is 1, so we return 1.
 *
 * Example 2:
 * Input: nums = [1, 2, 3, 4]
 * Output: -1
 * Explanation: 4 isn't at least as big as twice the value of 3, so we return -1.

 * Note:
 * 1. `nums` will have a length in the range `[1, 50]`.
 * 2. Every `nums[i]` will be an integer in the range `[0, 99]`.
 * ==========================================================================================================
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2019/03/18
 */
public class Solution {
    public int dominantIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // 1. 找出数组中最大值的索引
        int maxIndex = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        // 2. 判断最大值是否是其他元素的两倍以上
        for (int i = 0; i < nums.length; ++i) {
            if (i != maxIndex && nums[maxIndex] < 2 * nums[i]) {
                return -1;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        int[] nums = {3, 6, 1, 0};
        System.out.println((new Solution()).dominantIndex(nums));
    }
}
