package c01_array.lc0525_contiguous_array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * This is the solution of No. 525 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/contiguous-array/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 *
 * Example 1:
 * Input: [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 *
 * Example 2:
 * Input: [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 *
 * Note: The length of the given binary array will not exceed 50,000.
 * ==========================================================================================================
 *
 * Tags: array;hash table;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution2 {
    /**
     * Approach 2: Hash Table
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * Result of Submission:
     * Runtime: 5 ms, faster than 99.70% of Java online submissions for Contiguous Array.
     * Memory Usage: 48 MB, less than 100.00% of Java online submissions for Contiguous Array.
     *
     * @param nums int[], the input binary array
     * @return int, the maximum length of a contiguous subarray with equal number of 0 and 1
     */
    public int findMaxLengthV1(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("[ERROR] The input array is null!!!");
        }
        int n = nums.length;
        int[] num2Index = new int[2 * n + 1];
        Arrays.fill(num2Index, -2);
        num2Index[n] = -1;
        int s = 0, maxLen = 0;
        for (int i = 0; i < n; ++i) {
            s += nums[i] * 2 - 1;
            if (num2Index[s + n] >= -1) {
                maxLen = Math.max(maxLen, i - num2Index[s + n]);
            } else {
                num2Index[s + n] = i;
            }
        }
        return maxLen;
    }

    /**
     * Approach 2: Hash Table
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * Result of Submission:
     * Runtime: 18 ms, faster than 90.67% of Java online submissions for Contiguous Array.
     * Memory Usage: 49.7 MB, less than 100.00% of Java online submissions for Contiguous Array.
     *
     * @param nums int[], the input binary array
     * @return int, the maximum length of a contiguous subarray with equal number of 0 and 1
     */
    public int findMaxLengthV2(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("[ERROR] The input array is null!!!");
        }
        int n = nums.length;
        Map<Integer, Integer> num2Index = new HashMap<>();
        num2Index.put(0, -1); // process the case: the entire array meets the requirement
        int s = 0, maxLen = 0;
        for (int i = 0; i < n; ++i) {
            s += nums[i] * 2 - 1;
            if (num2Index.containsKey(s)) {
                maxLen = Math.max(maxLen, i - num2Index.get(s));
            } else {
                num2Index.put(s, i);
            }
        }
        return maxLen;
    }
}