package c01_array.lc0088_merge_sorted_array;

import java.util.Arrays;

/**
 * This is the solution of No. 88 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/merge-sorted-array/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * Note:
 * - The number of elements initialized in nums1 and nums2 are m and n respectively.
 * - You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 *
 * Example:
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * Output: [1,2,2,3,5,6]
 * ==========================================================================================================
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2019/06/28
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums2[j] > nums1[i]) {
                nums1[k] = nums2[j];
                --j;
            } else {
                nums1[k] = nums1[i];
                --i;
            }
            --k;
        }
        while (j >= 0) {
            nums1[k] = nums2[j];
            --j;
            --k;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[] {4, 5, 6};
        int m = 3, n = 3;
        (new Solution()).merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}