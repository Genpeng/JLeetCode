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
     * 中位数有如下两个性质：
     * 1. 将一个集合划分为两个长度相等的子集
     * 2. 其中一个子集中的元素总是大于另一个子集中的元素
     *
     * 假设有两个排序数组 A 和 B，在位置 i 处将数组 A 划分成两个部分（left_A 和 right_A），
     * 在位置 j 处将数组 B 划分成两个部分（left_B 和 right_B），将 left_A 和 left_B 放入
     * 一个集合中，命名为 left_part，将 right_A 和 right_B 放入另一个集合中，命名为 right_part，
     *           left_part          |         right_part
     *     A[0], A[1], ..., A[i-1]  |  A[i], A[i+1], ..., A[m-1]
     *     B[0], B[1], ..., B[j-1]  |  B[j], B[j+1], ..., B[n-1]
     *
     * 按照中位数的两个性质，如果存在 i 和 j 满足以下两个条件，
     * - i + j = (m+n+1) / 2
     * - A[i-1] <= B[j] 且 B[j-1] <= A[i]
     * 则中位数为 max(left_part)（两个数组元素之和为奇数）或者 max(left_part) + min(right_part) / 2
     * （两个数组元素之和为偶数）。
     *
     * 进一步地，可以简化为：
     * 在 [0, m] 中找到最大的 i，使得：
     * A[i−1] <= B[j], 其中 j = (m+n+1)/2 - i
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
        int m = A.length, n = B.length, L = m + n;
        if (L == 0) {
            throw new IllegalArgumentException("[ERROR] The two input arrays are both empty!!!");
        }
        if (m > n) { // confirm m <= n
            return findMedianSortedArrays(B, A);
        }
        int half = (L + 1) >> 1;
        int aLeft = 0, aRight = m;
        int leftMax = 0, rightMin = 0;
        while (aLeft <= aRight) {
            int i = aLeft + ((aRight - aLeft) >> 1);
            int j = half - i;
            int L1 = i == 0 ? Integer.MIN_VALUE : A[i-1];
            int R1 = i == m ? Integer.MAX_VALUE : A[i];
            int L2 = j == 0 ? Integer.MIN_VALUE : B[j-1];
            int R2 = j == n ? Integer.MAX_VALUE : B[j];
            if (L1 <= R2) {
                aLeft = i + 1;
                leftMax = Math.max(L1, L2);
                rightMin = Math.min(R1, R2);
            } else {
                aRight = i - 1;
            }
        }
        return (L & 1) == 0 ? (leftMax + rightMin) * 0.5 : leftMax * 1.0;
    }

    public static void main(String[] args) {
        Solution4 solu = new Solution4();
        System.out.println(solu.findMedianSortedArrays(new int[] {1}, new int[] {}) == 1);
        System.out.println(solu.findMedianSortedArrays(new int[] {1, 2}, new int[] {3}) == 2);
        System.out.println(solu.findMedianSortedArrays(new int[] {1, 2}, new int[] {3, 4}) == 2.5);
    }
}