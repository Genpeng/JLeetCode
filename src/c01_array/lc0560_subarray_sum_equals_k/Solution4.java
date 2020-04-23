package c01_array.lc0560_subarray_sum_equals_k;

import java.util.HashMap;
import java.util.Map;

/**
 * This is the solution of No. 560 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/subarray-sum-equals-k/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays
 * whose sum equals to k.
 *
 * Example 1:
 * Input:nums = [1, 1, 1], k = 2
 * Output: 2
 *
 * Note:
 * - The length of the array is in range [1, 20,000].
 * - The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 * ==========================================================================================================
 *
 * Tags: array;hash table;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution4 {
    /**
     * Approach 4: Hash Table
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * Result of Submission:
     * Runtime: 11 ms, faster than 95.43% of Java online submissions for Subarray Sum Equals K.
     * Memory Usage: 40.6 MB, less than 25.00% of Java online submissions for Subarray Sum Equals K.
     *
     * @param A int[], input integer array
     * @param target int, target sum
     * @return int, the total number of continuous subarrays whose sum equals to k
     */
    public int subarraySum(int[] A, int target) {
        Map<Integer, Integer> sum2Times = new HashMap<>();
        sum2Times.put(0, 1);
        int s = 0, count = 0;
        for (int num : A) {
            s += num;
            if (sum2Times.containsKey(s - target)) {
                count += sum2Times.get(s - target);
            }
            sum2Times.put(s, sum2Times.getOrDefault(s, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = {1, 1, 1, 1};
        int target = 2;
        Solution4 solu = new Solution4();
        System.out.println(solu.subarraySum(A, target));
    }
}