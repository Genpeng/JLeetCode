package c01_array.lc1013_partition_array_into_three_parts_with_equal_sum;

/**
 * This is the solution of No. 1013 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an array A of integers, return true if and only if we can partition the array into
 * three non-empty parts with equal sums.
 *
 * Formally, we can partition the array if we can find indexes i+1 < j with (A[0] + A[1] + ... + A[i] ==
 * A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1])
 *
 * Example 1:
 * Input: A = [0,2,1,-6,6,-7,9,1,2,0,1]
 * Output: true
 * Explanation: 0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
 *
 * Example 2:
 * Input: A = [0,2,1,-6,6,7,9,-1,2,0,1]
 * Output: false
 *
 * Example 3:
 * Input: A = [3,3,6,5,-2,2,5,1,-9,4]
 * Output: true
 * Explanation: 3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
 *
 * Constraints:
 * - 3 <= A.length <= 50000
 * - -10^4 <= A[i] <= 10^4
 * ==========================================================================================================
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * Approach 1
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Partition Array Into Three Parts With Equal Sum.
     * Memory Usage: 44.8 MB, less than 100.00% of Java online submissions for Partition Array Into Three Parts With Equal Sum.
     *
     * @param nums int[], input integer array
     * @return boolean, true if and only if the array can partition into three non-empty parts
     */
    public boolean canThreePartsEqualSum(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        if (totalSum % 3 != 0) {
            return false;
        }
        int aver = totalSum / 3, currSum = 0, count = 0;
        for (int num : nums) {
            currSum += num;
            if (currSum == aver) {
                ++count;
                currSum = 0;
            }
        }
        return count >= 3;
    }

    public static void main(String[] args) {
        int[] nums = {1, -1, 1, -1, 1, -1, 1, -1};
        Solution1 solution = new Solution1();
        System.out.println(solution.canThreePartsEqualSum(nums));
    }
}