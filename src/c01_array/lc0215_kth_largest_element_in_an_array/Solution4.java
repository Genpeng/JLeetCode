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
public class Solution4 {
    private Random rand = new Random();

    /**
     * Approach 4: Quick Select (Iteration)
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     *
     * @param nums int[], an input integer array
     * @param k int, an integer represents the kth
     * @return int, the kth largest element
     */
    public int findKthLargest(int[] nums, int k) {
//         if (nums == null || k > nums.length || k < 1) {
//             throw new IllegalArgumentException(
//                     "[ERROR] The input array is null or " +
//                     "the value of k is illegal (less than 0 or greater than the length of the array!!!)"
//             );
//         }
        int n = nums.length;
        k = n - k; // 1 <= k <= n, convert to find the (n-k)th smallest element
        int li = 0, ri = n - 1;
        while (li < ri) {
            int splitPoint = partition(nums, li, ri);
            if (splitPoint == k) {
                break;
            } else if (splitPoint < k) {
                li = splitPoint + 1;
            } else { // splitPoint > k
                ri = splitPoint - 1;
            }
        }
        return nums[k];
    }

    public int partition(int[] nums, int si, int ei) {
        swap(nums, si + rand.nextInt(ei - si), ei);
        int pivot = nums[ei];
        int i = si - 1;
        for (int j = si; j < ei; ++j) {
            if (nums[j] <= pivot) {
                ++i;
                if (j > i) {
                    swap(nums, i, j);
                }
            }
        }
        swap(nums, ++i, ei);
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
}