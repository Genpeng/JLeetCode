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
public class Solution3 {
    /**
     * Approach 3: Binary Search
     * 在一个大小为 n 的排序数组中查找中位数，其实就是找出第 n/2 个元素（当 n 为奇数的时候），或者是同时找出
     * 第 n/2 和 n/2 + 1 个元素（当 n 为偶数的时候）。这种解法的基本思路就是如此。为了在两个数组中查找第 k 个
     * 元素，每次都取出两个数组中第 k/2 个元素进行比较，对于较小结果的数组缩小 k/2 的查找范围，即 k/2 之前的元素
     * 都不必查找了。
     *
     * Complexity Analysis:
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
        if (m + n == 0) {
            throw new IllegalArgumentException("[ERROR] The two input array are both empty!!!");
        }
        int l = (m + n + 1) >> 1;
        int r = (m + n + 2) >> 1;
        return (getKthElem(A, 0, m-1, B, 0, n-1, l) + getKthElem(A, 0, m-1, B, 0, n-1, r)) * 0.5;
    }

    private int getKthElem(int[] A, int aLeft, int aRight, int[] B, int bLeft, int bRight, int k) {
        int la = aRight - aLeft + 1, lb = bRight - bLeft + 1;
        if (la > lb) {
            return getKthElem(B, bLeft, bRight, A, aLeft, aRight, k);
        }
        if (la == 0) {
            return B[bLeft + k - 1];
        }
        if (k == 1) {
            return Math.min(A[aLeft], B[bLeft]);
        }
        int i = Math.min(aRight, aLeft + k/2 - 1);
        int j = Math.min(bRight, bLeft + k/2 - 1);
        if (A[i] > B[j]) {
            return getKthElem(A, aLeft, aRight, B, j+1, bRight, k - (j-bLeft+1));
        } else {
            return getKthElem(A, i+1, aRight, B, bLeft, bRight, k - (i-aLeft+1));
        }
    }

    public static void main(String[] args) {
        Solution3 solu = new Solution3();
        System.out.println(solu.findMedianSortedArrays(new int[] {1}, new int[] {}) == 1);
        System.out.println(solu.findMedianSortedArrays(new int[] {1, 2}, new int[] {3}) == 2);
        System.out.println(solu.findMedianSortedArrays(new int[] {1, 2}, new int[] {3, 4}) == 2.5);
    }
}