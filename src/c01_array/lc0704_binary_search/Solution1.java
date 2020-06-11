package c01_array.lc0704_binary_search;

/**
 * This is the solution of No. 704 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/binary-search/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a sorted (in ascending order) integer array nums of n elements and a target value,
 * write a function to search target in nums. If target exists, then return its index, otherwise return -1.
 *
 * Example 1:
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 *
 * Example 2:
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 *
 * Note:
 * - You may assume that all elements in nums are unique.
 * - n will be in the range [1, 10000].
 * - The value of each element in nums will be in the range [-9999, 9999].
 * ==========================================================================================================
 *
 * Tags: array;binary search;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * Approach 1: Binary Search
     * Time Complexity: O(log(N))
     * Space Complexity: O(1)
     *
     * @param nums int[], a sorted (in ascending order) integer array
     * @param target int, a target value
     * @return int, the index of target value or -1 if it does exists
     */
    public int search(int[] nums, int target) {
        int li = 0, ri = nums.length - 1;
        while (li <= ri) {
            int mi = li + ((ri - li) >> 1);
            if (target == nums[mi]) {
                return mi;
            } else if (target < nums[mi]) {
                ri = mi - 1;
            } else {
                li = mi + 1;
            }
        }
        return -1;
    }
}