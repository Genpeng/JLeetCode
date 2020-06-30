package c01_array.lc0215_kth_largest_element_in_an_array;

import java.util.Random;

/**
 * This is the solution of No. 215 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/kth-largest-element-in-an-array/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order,
 * not the kth distinct element.
 *
 * Example 1:
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 *
 * Example 2:
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 * ==========================================================================================================
 *
 * Tags: array;sort;heap;divide and conquer;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution3 {
    private Random rand = new Random();

    /**
     * Approach 3: Quick Select (Recursion)
     * The idea is to use quick select algorithm.
     *
     * Complexity Analysis:
     * Time Complexity: O(N)
     * Space Complexity: O(log(N))
     *
     * References:
     * [1] Cormen, Thomas H., et al. Introduction to algorithms. MIT press, 2009. (Chapter 9.2)
     * [2] https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/shu-zu-zhong-de-di-kge-zui-da-yuan-su-by-leetcode-/
     *
     * Result of Submission:
     * Runtime: 1 ms, faster than 97.99% of Java online submissions for Kth Largest Element in an Array.
     * Memory Usage: 39.9 MB, less than 50.37% of Java online submissions for Kth Largest Element in an Array.
     *
     * @param nums int[], an input integer array
     * @param k int, an integer represents the kth
     * @return int, the kth largest element
     */
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length, ti = n - k; // convert to find the (n-k)th smallest element (0 index)
        quickSelect(nums, 0, n - 1, ti);
        return nums[ti];
    }

    /**
     * Find out the target element (specify by index) in an unsorted array
     * by using Quick Select Algorithm.
     *
     * @param nums int[], an unsorted array of integers
     * @param li int, the index of the first element, inclusive, to be searched
     * @param ri int, the index of the last element, inclusive, to be searched
     * @param ti int, the index of the target element
     */
    public void quickSelect(int[] nums, int li, int ri, int ti) {
        if (li >= ri) {
            return;
        }
        int splitPoint = randomPartition(nums, li, ri);
        if (splitPoint < ti) {
            quickSelect(nums, splitPoint + 1, ri, ti);
        } else if (splitPoint > ti) {
            quickSelect(nums, li, splitPoint - 1, ti);
        }
    }

    public int randomPartition(int[] nums, int li, int ri) {
        swap(nums, li + rand.nextInt(ri - li), ri);
        return partition(nums, li, ri);
    }

    public int partition(int[] nums, int li, int ri) {
        int pivot = nums[ri];
        int i = li - 1;
        for (int j = li; j < ri; ++j) {
            if (nums[j] <= pivot) {
                ++i;
                if (j > i) {
                    swap(nums, i, j);
                }
            }
        }
        swap(nums, ++i, ri);
        return i;
    }

    public void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        Solution3 solu = new Solution3();
        System.out.println(solu.findKthLargest(nums, k));
    }
}