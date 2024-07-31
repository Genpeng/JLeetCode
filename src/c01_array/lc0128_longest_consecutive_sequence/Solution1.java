package c01_array.lc0128_longest_consecutive_sequence;

import java.util.HashSet;
import java.util.Set;

/**
 * This is the solution of No. 128 problem in the LeetCode,
 * the website of the problem is as follows:
 * https://leetcode.com/problems/longest-consecutive-sequence
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 * <p>
 * You must write an algorithm that runs in O(n) time.
 * <p>
 * Example 1:
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * <p>
 * Example 2:
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 * <p>
 * Constraints:
 * - 0 <= nums.length <= 10^5
 * - -10^9 <= nums[i] <= 10^9
 * ==========================================================================================================
 * <p>
 * Difficulty: Medium
 * Tags: array;hash table;
 *
 * @author Lukas (xgp1227atgmail.com)
 */
class Solution1 {
    public int longestConsecutive(int[] nums) {
        // 题意：
        // 已知一个整数数组，求出数组中最长的连续子序列

        // 解法1：哈希表（Hash Table）
        // 时间复杂度：O(n)
        // 空间复杂度：O(n)

        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLen = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currNum = num, currLen = 1;
                while (set.contains(currNum + 1)) {
                    ++currNum;
                    ++currLen;
                }
                maxLen = Math.max(maxLen, currLen);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        Solution1 solu = new Solution1();
        System.out.println(solu.longestConsecutive(nums));
    }
}