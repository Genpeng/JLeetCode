package array.lc0033_search_in_rotated_sorted_array;

/**
 * This is the solution of No. 33 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * <p>
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * Example 1:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * <p>
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * ==========================================================================================================
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution {
    /**
     * 解法：Binary Search
     * 时间复杂度：O(log(N))
     * 空间复杂度：O(1)
     *
     * 备注：
     * 1. 数组中元素不重复
     * 2. 数组中元素非负或者不包含-1
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in Rotated Sorted Array.
     * Memory Usage: 38.4 MB, less than 44.65% of Java online submissions for Search in Rotated Sorted Array.
     *
     * @param nums int[], the input array
     * @param target int, the integer to search
     * @return int, the index of target integer
     */
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        // Step 1: find out the index of minimum integer, O(log(N))
        int minIdx = findMinIdx(nums);
        // Step 2: shrink the search range
        if (nums[minIdx] == target) {
            return minIdx;
        }
        int n = nums.length;
        int l, r;
        if (nums[n-1] == target) {
            return n-1;
        } else if (nums[n-1] < target) {
            l = 0;
            r = minIdx - 1;
        } else {
            l = minIdx + 1;
            r = n - 1;
        }
        // Step 3: find out the target index, O(log(N))
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public int findMinIdx(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[r]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {4, 5, 6, 7, 0, 1, 2}; // the index of minimum is: 4
        int target = 0;
        Solution solution = new Solution();
        System.out.println(solution.search(nums, target));
    }
}