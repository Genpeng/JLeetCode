package c01_array.lc0153_find_minimum_in_rotated_sorted_array;

/**
 * This is the solution of No. 153 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 *
 * Find the minimum element.
 *
 * You may assume no duplicate exists in the array.
 *
 * Example 1:
 * Input: [3,4,5,1,2]
 * Output: 1
 *
 * Example 2:
 * Input: [4,5,6,7,0,1,2]
 * Output: 0
 * ==========================================================================================================
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * Approach: Binary Search
     * Time complexity: O(log(N))
     * Space complexity: O(1)
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Minimum in Rotated Sorted Array.
     * Memory Usage: 38.3 MB, less than 88.64% of Java online submissions for Find Minimum in Rotated Sorted Array.
     *
     * @param nums int[], the input integer array
     * @return int, the minimum
     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("[ERROR] The input array is illegal!!!");
        }
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[r]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l];
    }

    /**
     * Find pivot in rotated sorted array.
     *
     * @param nums int[], the rotated sorted array
     * @return int, the index of the pivot
     */
    public int findPivot(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("[ERROR] The input array is illegal!!!");
        }
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
        int[] nums1 = new int[] {4, 5, 6, 7, 0, 1, 2};
        int[] nums2 = new int[] {1, 2};
        int[] nums3 = new int[] {2, 1};
        int[] nums4 = new int[] {5, 1, 3};
        Solution1 solution = new Solution1();
        System.out.println(solution.findPivot(nums1)); // 4
        System.out.println(solution.findPivot(nums2)); // 0
        System.out.println(solution.findPivot(nums3)); // 1
        System.out.println(solution.findPivot(nums4)); // 1
        System.out.println(solution.findMin(nums1));
        System.out.println(solution.findMin(nums2));
        System.out.println(solution.findMin(nums3));
        System.out.println(solution.findMin(nums4));
    }
}