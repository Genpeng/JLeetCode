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
public class Solution2 {
    /**
     * Approach 2: Use Cumulative Sum
     * Time Complexity: O(n ^ 2)
     * Space Complexity: O(n)
     *
     * Result of Submission:
     * Runtime: 254 ms, faster than 8.20% of Java online submissions for Subarray Sum Equals K.
     * Memory Usage: 41.2 MB, less than 6.52% of Java online submissions for Subarray Sum Equals K.
     *
     * @param A int[], input integer array
     * @param target int, target sum
     * @return int, the total number of continuous subarrays whose sum equals to k
     */
    public int subarraySum(int[] A, int target) {
        int L = A.length;
        int[] cumuSum = new int[L+1];
        cumuSum[0] = 0;
        for (int i = 1; i <= L; ++i) {
            cumuSum[i] = cumuSum[i-1] + A[i-1];
        }
        int count = 0;
        for (int si = 0; si < L; ++si) {
            for (int ei = si; ei < L; ++ei) {
                if (cumuSum[ei+1] - cumuSum[si] == target) {
                    ++count;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = {1, 1, 1, 1};
        int target = 2;
        Solution2 solu = new Solution2();
        System.out.println(solu.subarraySum(A, target));
    }
}