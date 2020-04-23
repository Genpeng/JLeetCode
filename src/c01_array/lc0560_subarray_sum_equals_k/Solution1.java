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
public class Solution1 {
    /**
     * Approach 1: Brute Force
     * Time Complexity: O(n ^ 3)
     * Space Complexity: O(1)
     *
     * @param A int[], input integer array
     * @param target int, target sum
     * @return int, the total number of continuous subarrays whose sum equals to k
     */
    public int subarraySum(int[] A, int target) {
        int L = A.length, count = 0;
        for (int si = 0; si < L; ++si) {
            for (int ei = si; ei < L; ++ei) {
                int s = 0;
                for (int k = si; k <= ei; ++k) {
                    s += A[k];
                }
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
        Solution1 solu = new Solution1();
        System.out.println(solu.subarraySum(A, target));
    }
}