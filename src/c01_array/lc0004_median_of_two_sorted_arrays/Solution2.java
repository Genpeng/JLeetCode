package c01_array.lc0004_median_of_two_sorted_arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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
        if (A == null || B == null) {
            throw new IllegalArgumentException("[ERROR] There must exist null array!!!");
        }
        int m = A.length, n = B.length, L = m + n;
        int i = 0, j = 0;
        int prev = 0, curr = 0;
        for (int idx = 0; idx <= L / 2; ++idx) {
            prev = curr;
            if (i < m && (j >= n || A[i] < B[j])) {
                curr = A[i++];
            } else {
                curr = B[j++];
            }
        }
        if ((L & 1) == 0) {
            return (prev + curr) / 2.0;
        } else {
            return curr;
        }
    }

    public static void main(String[] args) {
        List<int[]> As = new LinkedList<>();
        As.add(new int[] {1, 3});
        As.add(new int[] {1, 2, 4});
        As.add(new int[] {});
        List<int[]> Bs = new LinkedList<>();
        Bs.add(new int[] {2});
        Bs.add(new int[] {3});
        Bs.add(new int[] {1, 2, 3, 4});
        double[] results = {2.0, 2.5, 2.5};
        Solution2 solu = new Solution2();
        for (int i = 0; i < As.size(); ++i) {
            int[] A = As.get(i);
            int[] B = Bs.get(i);
            double result = results[i];
            double pred = solu.findMedianSortedArrays(A, B);
            if (pred != result) {
                System.out.format("A: %s, B: %s", Arrays.toString(A), Arrays.toString(B));
            }
        }
    }
}