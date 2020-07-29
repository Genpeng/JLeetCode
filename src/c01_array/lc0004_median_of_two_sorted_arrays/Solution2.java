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
 * Difficulty: Hard
 * Tags: array;divide and conquer;binary search
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution2 {
    /**
     * Approach 2: Two Pointers
     * The idea is to find out the median in the two sorted arrays by using two pointers.
     *
     * Complexity Analysis:
     * Time Complexity: O(m + n)
     * Space Complexity: O(1)
     *
     * @param A int[], one integer array
     * @param B int[], the other integer array
     * @return int[], the median of two sorted array
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        if (A == null || B == null) {
            throw new IllegalArgumentException("[ERROR] There must exist null array in two input arrays!!!");
        }
        int m = A.length, n = B.length, k = m + n;
        if (k == 0) {
            throw new IllegalArgumentException("[ERROR] The two input arrays are both empty!!!");
        }
        int i = 0, j = 0;
        int prev = 0, curr = 0;
        for (int idx = 0; idx <= k / 2; ++idx) {
            prev = curr;
            if (i < m && (j >= n || A[i] < B[j])) {
                curr = A[i++];
            } else {
                curr = B[j++];
            }
        }
        if ((k & 1) == 0) {
            return (prev + curr) * 0.5;
        } else {
            return curr;
        }
    }

    public static void main(String[] args) {
        Solution2 solu = new Solution2();
        System.out.println(solu.findMedianSortedArrays(new int[] {1}, new int[] {}) == 1);
        System.out.println(solu.findMedianSortedArrays(new int[] {1, 2}, new int[] {3}) == 2);
        System.out.println(solu.findMedianSortedArrays(new int[] {1, 2}, new int[] {3, 4}) == 2.5);
    }
}