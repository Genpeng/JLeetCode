package c01_array.lc0004_median_of_two_sorted_arrays;

import java.util.Arrays;

/**
 * This is the solution of No. 4 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * The median is 2.0
 *
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * The median is (2 + 3)/2 = 2.5
 * ==========================================================================================================
 *
 * Tags: array;divide-and-conquer;binary-search
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * Approach 1: Brute Force
     * Time Complexity: O(m + n)
     * Space Complexity: O(m + n)
     *
     * Result of Submission:
     * Runtime: 7 ms, faster than 14.64% of Java online submissions for Median of Two Sorted Arrays.
     * Memory Usage: 46.5 MB, less than 90.97% of Java online submissions for Median of Two Sorted Arrays.
     *
     * @param A int[], one integer array
     * @param B int[], the other integer array
     * @return int[], the median of two sorted array
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int[] nums = merge(A, m, B, n);
        int L = m + n, mid = L / 2;
        if ((L & 1) == 0) {
            return (nums[mid - 1] + nums[mid]) * 0.5;
        } else {
            return nums[mid];
        }
    }

    public int[] merge(int[] nums1, int m, int[] nums2, int n) {
        if (m * n == 0) {
            return m == 0 ? nums2 : nums1;
        }
        int[] ans = new int[m + n];
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                ans[k--] = nums1[i--];
            } else {
                ans[k--] = nums2[j--];
            }
        }
        while (i >= 0) {
            ans[k--] = nums1[i--];
        }
        while (j >= 0) {
            ans[k--] = nums2[j--];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 3, 4};
        Solution1 solution = new Solution1();
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }
}