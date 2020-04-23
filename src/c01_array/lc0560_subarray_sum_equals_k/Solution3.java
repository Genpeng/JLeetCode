package c01_array.lc0560_subarray_sum_equals_k;

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
public class Solution3 {
    /**
     * Approach 3: Without Space
     * Time Complexity: O(n ^ 2)
     * Space Complexity: O(1)
     *
     * Result of Submission:
     * Runtime: 208 ms, faster than 22.09% of Java online submissions for Subarray Sum Equals K.
     * Memory Usage: 40 MB, less than 70.65% of Java online submissions for Subarray Sum Equals K.
     *
     * @param A int[], input integer array
     * @param target int, target sum
     * @return int, the total number of continuous subarrays whose sum equals to k
     */
    public int subarraySum(int[] A, int target) {
        int L = A.length, count = 0;
        for (int si = 0; si < L; ++si) {
            int s = 0;
            for (int ei = si; ei < L; ++ei) {
                s += A[ei];
                if (s == target) {
                    ++count;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = {1, 1, 1, 1};
        int target = 2;
        Solution3 solu = new Solution3();
        System.out.println(solu.subarraySum(A, target));
    }
}