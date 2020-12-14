package c08_dp.lc0300_longest_increasing_subsequence;

/**
 * This is the solution of No. 300 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/longest-increasing-subsequence/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 *
 * Example:
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 *
 * Note:
 * - There may be more than one LIS combination, it is only necessary for you to return the length.
 * - Your algorithm should run in O(n^2) complexity.
 *
 * Follow up: Could you improve it to O(n log n) time complexity?
 * ==========================================================================================================
 *
 * Tags: dp;binary search;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution5 {
    /**
     * Approach 5: Binary Search
     * The idea is to maintain an array `tail`, where `tail[i]` represents the smallest tail
     * in all increasing subsequences of length `i+1`.
     *
     * Complexity Analysis:
     * Time Complexity: O(N * log(N))
     * Space Complexity: O(N)
     *
     * Result of Submission:
     * Runtime: 1 ms, faster than 86.60% of Java online submissions for Longest Increasing Subsequence.
     * Memory Usage: 37.6 MB, less than 34.00% of Java online submissions for Longest Increasing Subsequence.
     *
     * @param nums int[], the input integer array
     * @return int, the length of longest increasing subsequence
     */
    public int lengthOfLISV1(int[] nums) {
        int[] tail = new int[nums.length];
        int size = 0;
        for (int num : nums) {
            int l = 0, r = size;
            while (l < r) {
                int m = l + ((r - l) >> 1); // or (l + r) >>> 1
                if (num > tail[m]) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            tail[l] = num;
            if (l == size) {
                ++size;
            }
        }
        return size;
    }

    /**
     * Approach 4: Binary Search (Recommended)
     * The idea is to maintain an array `tail`, where `tail[i]` represents the smallest tail
     * in all increasing subsequences of length `i+1`.
     *
     * Complexity Analysis:
     * Time Complexity: O(N * log(N))
     * Space Complexity: O(N)
     *
     * Result of Submission:
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Longest Increasing Subsequence.
     * Memory Usage: 37.7 MB, less than 34.00% of Java online submissions for Longest Increasing Subsequence.
     *
     * @param nums int[], the input integer array
     * @return int, the length of longest increasing subsequence
     */
    public int lengthOfLISV2(int[] nums) {
        final int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] tail = new int[n];
        tail[0] = nums[0];
        int lastIndex = 0;
        for (int i = 1; i < n; ++i) {
            if (nums[i] > tail[lastIndex]) {
                tail[++lastIndex] = nums[i];
            } else if (nums[i] < tail[lastIndex]) {
                int idx = findFirstGreaterOrEqual(tail, 0, lastIndex, nums[i]);
                tail[idx] = nums[i];
            }
        }
        return lastIndex + 1;
    }

    private int findFirstGreaterOrEqual(int[] nums, int li, int ri, int target) {
        if (nums[ri] < target) {
            return -1;
        }
        while (li <= ri) {
            int mi = li + ((ri - li) >> 1);
            if (nums[mi] < target) {
                li = mi + 1;
            } else {
                ri = mi - 1;
            }
        }
        return li;
    }

    public static void main(String[] args) {
        Solution5 solu = new Solution5();
        System.out.println(solu.lengthOfLISV1(new int[] {}) == 0);
        System.out.println(solu.lengthOfLISV1(new int[] {1}) == 1);
        System.out.println(solu.lengthOfLISV1(new int[] {10, 9, 2, 5, 3, 7, 101, 18}) == 4);
        System.out.println(solu.lengthOfLISV1(new int[] {4, 2, 3, 6, 10, 1, 12}) == 5);
    }
}