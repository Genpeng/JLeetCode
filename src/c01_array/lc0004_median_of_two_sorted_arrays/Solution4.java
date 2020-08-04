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
public class Solution4 {
    /**
     * Approach 4: Median's property
     *
     * References:
     * - https://leetcode-cn.com/problems/median-of-two-sorted-arrays/solution/xun-zhao-liang-ge-you-xu-shu-zu-de-zhong-wei-s-114/
     *
     * Complexity Analysis:
     * Time Complexity: O(log(min{m, n}))
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
        int m = A.length, n = B.length;
        if (m + n == 0) {
            throw new IllegalArgumentException("[ERROR] The two input arrays are both empty!!!");
        }
        if (m > n) {
            return findMedianSortedArrays(B, A);
        }
        int L = m + n, half = (L + 1) >> 1;
        int aLeft = 0, aRight = m;
        int median1 = 0, median2 = 0;
        while (aLeft <= aRight) {
            int i = (aLeft + aRight) >> 1;
            int j = half - i;
            int L1 = i == 0 ? Integer.MIN_VALUE : A[i-1];
            int R1 = i == m ? Integer.MAX_VALUE : A[i];
            int L2 = j == 0 ? Integer.MIN_VALUE : B[j-1];
            int R2 = j == n ? Integer.MAX_VALUE : B[j];
            if (L1 <= R2) {
                median1 = Math.max(L1, L2);
                median2 = Math.min(R1, R2);
                aLeft = i + 1;
            } else {
                aRight = i - 1;
            }
        }
        return (L & 1) == 0 ? (median1 + median2) * 0.5 : median1 * 1.0;
    }

    public static void main(String[] args) {
        Solution4 solu = new Solution4();
        System.out.println(solu.findMedianSortedArrays(new int[] {1}, new int[] {}) == 1);
        System.out.println(solu.findMedianSortedArrays(new int[] {1, 2}, new int[] {3}) == 2);
        System.out.println(solu.findMedianSortedArrays(new int[] {1, 2}, new int[] {3, 4}) == 2.5);
    }
}