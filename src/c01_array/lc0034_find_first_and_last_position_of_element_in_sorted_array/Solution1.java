package c01_array.lc0034_find_first_and_last_position_of_element_in_sorted_array;

/**
 * This is the solution of No. 34 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of
 * a given target value.
 *
 * If target is not found in the array, return [-1, -1].
 *
 * Follow up: Could you write an algorithm with O(log n) runtime complexity?
 *
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 * Example 3:
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 *
 * Constraints:
 * - 0 <= nums.length <= 105
 * - -109 <= nums[i] <= 109
 * - nums is a non-decreasing array.
 * - -109 <= target <= 109
 * ==========================================================================================================
 *
 * Difficulty: Medium
 * Tags: array;binary search;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * Approach 1: Binary Search
     * 这道题等价于求解：
     * - 找到第一个大于等于 target 的元素的位置
     * - 找到最后一个小于等于 target 的元素的位置
     *
     * Complexity Analysis:
     * Time Complexity: O(log(n))
     * Space Complexity: O(1)
     *
     * Result of Submission:
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Find First and Last Position of Element in Sorted Array.
     * Memory Usage: 42.5 MB, less than 28.99% of Java online submissions for Find First and Last Position of Element in Sorted Array.
     *
     * @param nums int[], the integer array
     * @param target int, the target value
     * @return int[], the starting and ending position of a given target value
     */
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int[] ans = new int[] {-1, -1};
        if (n == 0) {
            return ans;
        }
        int firstIdx = firstGreaterOrEqual(nums, target);
        if (firstIdx == -1 || nums[firstIdx] != target) {
            // 如果找不到 >= target，那就说明整个数组都小于 target，即数组不存在 target
            // 如果有 >= target 的元素，但是 nums[firstIdx] != target，那就说明数组不存在 target
            return ans;
        }
        ans[0] = firstIdx; // 如果可以找到等于 target 的元素，下面的二分查找肯定可以找到
        ans[1] = lastLessOrEqual(nums, target);
        return ans;
    }

    private int firstGreaterOrEqual(int[] nums, int target) {
        int n = nums.length;
        if (n == 0 || nums[n-1] < target) {
            return -1;
        }
        int li = 0, ri = n - 1;
        while (li <= ri) {
            int mi = li + ((ri - li) >> 1);
            if (nums[mi] < target) {
                li = mi + 1;
            } else { // nums[mi] >= target
                ri = mi - 1;
            }
        }
        return li;
    }

    private int lastLessOrEqual(int[] nums, int target) {
        int n = nums.length;
        if (n == 0 || nums[0] > target) {
            return -1;
        }
        int li = 0, ri = n - 1;
        while (li <= ri) {
            int mi = li + ((ri - li) >> 1);
            if (nums[mi] <= target) {
                li = mi + 1;
            } else { // nums[mi] > target
                ri = mi - 1;
            }
        }
        return ri;
    }
}