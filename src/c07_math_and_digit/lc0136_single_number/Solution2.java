package c07_math_and_digit.lc0136_single_number;

import java.util.HashSet;
import java.util.Set;

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
 * Difficulty: Easy
 * Tags: array;math;hash table;bit manipulation;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution2 {
    /**
     * Solution 2: Math
     *
     * Complexity Analysis:
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * Result of Submission:
     * Runtime: 4 ms, faster than 43.68% of Java online submissions for Single Number.
     * Memory Usage: 41.4 MB, less than 68.15% of Java online submissions for Single Number.
     *
     * @param nums int[], an input integer array
     * @return int, the element which appears once
     */
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int sumOnce = 0, sumAll = 0;
        for (int num : nums) {
            sumAll += num;
            if (!set.contains(num)) {
                sumOnce += num;
                set.add(num);
            }
        }
        return sumOnce * 2 - sumAll;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 1};
        Solution2 solution = new Solution2();
        System.out.println(solution.singleNumber(nums));
    }
}