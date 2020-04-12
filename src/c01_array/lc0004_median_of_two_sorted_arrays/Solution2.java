package c01_array.lc0004_median_of_two_sorted_arrays;

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
public class Solution2 {
    /**
     * Approach 2: Find out the number in the middle without merging two arrays
     * Time Complexity: O(m + n)
     * Space Complexity: O(1)
     *
     * @param A int[], one integer array
     * @param B int[], the other integer array
     * @return int[], the median of two sorted array
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length, n = B.length, L = m + n;
        int prev = -1, curr = -1;
        int ai = 0, bi = 0;
        for (int i = 0; i <= L / 2; ++i) {
            prev = curr;
            if (ai < m && (bi >= n || A[ai] < B[bi])) {
                curr = A[ai++];
            } else {
                curr = B[bi++];
            }
        }
        if ((L & 1) == 0) {
            return (prev + curr) / 2.0;
        } else {
            return curr;
        }
    }
}