package c07_math_and_digit.lc0136_single_number;

/**
 * This is the solution of No. 136 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/single-number/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * <p>
 * Note:
 * - Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * <p>
 * Example 1:
 * Input: [2,2,1]
 * Output: 1
 * <p>
 * Example 2:
 * Input: [4,1,2,1,2]
 * Output: 4
 * ==========================================================================================================
 *
 * Tags: array;math;hash table;bit manipulation;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution3 {
    /**
     * Solution 3: Bit Manipulation
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * Result of Submission:
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Single Number.
     * Memory Usage: 42.1 MB, less than 5.93% of Java online submissions for Single Number.
     *
     * @param nums int[], an input integer array
     * @return int, the element which appears once
     */
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 1};
        Solution3 solution = new Solution3();
        System.out.println(solution.singleNumber(nums));
    }
}