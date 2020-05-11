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
public class Solution3 {
    /**
     * Approach 3: Binary Search
     * Time Complexity: O(log(m + n))
     * Space Complexity: O(log(m + n))
     *
     * Result of Submission:
     * Runtime: 2 ms, faster than 99.80% of Java online submissions for Median of Two Sorted Arrays.
     * Memory Usage: 40.1 MB, less than 100.00% of Java online submissions for Median of Two Sorted Arrays.
     *
     * @param A int[], one integer array
     * @param B int[], the other integer array
     * @return int[], the median of two sorted array
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        if (A == null || B == null) {
            throw new IllegalArgumentException("[ERROR] There must exist null array!!!");
        }
        int m = A.length, n = B.length;
        int l = (m + n + 1) >> 1;
        int r = (m + n + 2) >> 1;
        return (getKthElem(A, 0, m-1, B, 0, n-1, l) + getKthElem(A, 0, m-1, B, 0, n-1, r)) * 0.5;
    }

    private int getKthElem(int[] A, int s1, int e1, int[] B, int s2, int e2, int k) {
        int l1 = e1 - s1 + 1, l2 = e2 - s2 + 1;
        if (l1 > l2) {
            return getKthElem(B, s2, e2, A, s1, e1, k);
        }
        if (l1 == 0) {
            return B[s2 + k - 1];
        }
        if (k == 1) {
            return Math.min(A[s1], B[s2]);
        }
        int i = Math.min(e1, s1 + k/2 - 1);
        int j = Math.min(e2, s2 + k/2 - 1);
        if (A[i] > B[j]) {
            return getKthElem(A, s1, e1, B, j+1, e2, k - (j-s2+1));
        } else {
            return getKthElem(A, i+1, e1, B, s2, e2, k - (i-s1+1));
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 3, 3};
        int[] nums2 = {1, 1, 3, 3};
        Solution3 solution = new Solution3();
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }
}