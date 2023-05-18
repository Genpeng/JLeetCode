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
 * Difficulty: Medium
 * Tags: array;sort;heap;divide and conquer;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution4 {
    private Random rand = new Random();

    /**
     * Approach 4: Quick Select (Iteration)
     * The idea is to use quick select algorithm.
     *
     * Complexity Analysis:
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     *
     * Result of Submission:
     * Runtime: 15 ms, faster than 17.73% of Java online submissions for Kth Largest Element in an Array.
     * Memory Usage: 41.7 MB, less than 17.93% of Java online submissions for Kth Largest Element in an Array.
     *
     * @param nums int[], an input integer array
     * @param k int, an integer represents the kth
     * @return int, the kth largest element
     */
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length, ti = n - k; // 1 <= k <= n, convert to find the (n-k)th smallest element
        int li = 0, ri = n - 1;
        while (li < ri) {
            int splitPoint = randomPartition(nums, li, ri);
            if (splitPoint == ti) {
                break;
            } else if (splitPoint < ti) {
                li = splitPoint + 1;
            } else { // splitPoint > ti
                ri = splitPoint - 1;
            }
        }
        return nums[ti];
    }

    private int randomPartition(int[] nums, int li, int ri) {
        swap(nums, li + rand.nextInt(ri - li), ri);
        return partition(nums, li, ri);
    }

    private int partition(int[] nums, int li, int ri) {
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
        Solution4 solu = new Solution4();
        System.out.println(solu.findKthLargest(new int[] {3, 2, 1, 5, 6, 4}, 2) == 5);
        System.out.println(solu.findKthLargest(new int[] {3, 2, 3, 1, 2, 4, 5, 5, 6}, 4) == 4);
    }
}