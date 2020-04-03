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
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution4 {
    /**
     * Approach 4: Binary Search
     * Time Complexity: O(n * log(n))
     * Space Complexity: O(n)
     *
     * Runtime: 1 ms, faster than 86.60% of Java online submissions for Longest Increasing Subsequence.
     * Memory Usage: 37.6 MB, less than 34.00% of Java online submissions for Longest Increasing Subsequence.
     *
     * @param nums int[], the input integer array
     * @return int, the length of longest increasing subsequence
     */
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return n;
        }
        int[] tail = new int[n];
        int size = 0;
        for (int num : nums) {
            int l = 0, r = size;
            while (l < r) {
                int m = l + (r - l) / 2;
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
     * Approach 4: Binary Search
     * Time Complexity: O(n * log(n))
     * Space Complexity: O(n)
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Longest Increasing Subsequence.
     * Memory Usage: 37.7 MB, less than 34.00% of Java online submissions for Longest Increasing Subsequence.
     *
     * @param nums int[], the input integer array
     * @return int, the length of longest increasing subsequence
     */
    public int lengthOfLISV1(int[] nums) {
        int n = nums.length;
        if (n <= 1) {
            return n;
        }
        int[] tail = new int[n];
        tail[0] = nums[0];
        int len = 0;
        for (int i = 1; i < n; ++i) {
            if (nums[i] > tail[len]) {
                tail[++len] = nums[i];
            } else if (nums[i] < tail[len]) {
                int l = 0, r = len;
                while (l < r) {
                    int m = l + (r - l) / 2;
                    if (nums[i] > tail[m]) {
                        l = m + 1;
                    } else {
                        r = m;
                    }
                }
                tail[l] = nums[i];
            }
        }
        return len + 1;
    }
}