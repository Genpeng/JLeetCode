package math_and_digit.lc0136_single_number;

import java.util.HashMap;
import java.util.Map;

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
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * Solution 1: Map
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * Runtime: 7 ms, faster than 29.83% of Java online submissions for Single Number.
     * Memory Usage: 41.8 MB, less than 55.56% of Java online submissions for Single Number.
     *
     * @param nums int[], an input integer array
     * @return int, the element which appears once
     */
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        throw new IllegalArgumentException("[ERROR] The input array is illegal!!!");
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 1};
        Solution1 solution = new Solution1();
        System.out.println(solution.singleNumber(nums));
    }
}