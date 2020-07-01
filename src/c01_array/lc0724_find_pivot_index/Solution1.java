package c01_array.lc0724_find_pivot_index;

/**
 * This is the solution of No. xxx problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/find-pivot-index/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an array of integers nums, write a method that returns the "pivot" index of this array.
 *
 * We define the pivot index as the index where the sum of the numbers to the left of the index is equal to
 * the sum of the numbers to the right of the index.
 *
 * If no such index exists, we should return -1. If there are multiple pivot indexes, you should return
 * the left-most pivot index.
 *
 * Example 1:
 * Input:
 * nums = [1, 7, 3, 6, 5, 6]
 * Output: 3
 * Explanation:
 * The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3.
 * Also, 3 is the first index where this occurs.
 *
 *
 * Example 2:
 * Input:
 * nums = [1, 2, 3]
 * Output: -1
 * Explanation:
 * There is no index that satisfies the conditions in the problem statement.
 *
 *
 * Note:
 * The length of nums will be in the range [0, 10000].
 * Each element nums[i] will be an integer in the range [-1000, 1000].
 * ==========================================================================================================
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2019/03/17
 */
public class Solution1 {
    public int pivotIndex(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("[ERROR] The input array is null!!!");
        }
        // Step 1: calculate the sum of all integers in the array
        int s = 0;
        for (int num : nums) {
            s += num;
        }
        // Step 2: find out the pivot index
        int leftSum = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (leftSum == s - nums[i] - leftSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}