package lc136;

import java.util.HashSet;
import java.util.Set;

/**
 * This is the solution of No. 136 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/single-number/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 * Input: [2,2,1]
 * Output: 1
 *
 * Example 2:
 * Input: [4,1,2,1,2]
 * Output: 4
 * ==========================================================================================================
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2019/01/04
 */
public class Solution3 {
    /**
     * 解法三：数学运算
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param nums int[], the input array of integers
     * @return int, the only integer which appears once
     */
    public int singleNumber(int[] nums) {
        int sum = 0;
        Set<Integer> uniqueNums = new HashSet<>();
        for (int num : nums) {
            uniqueNums.add(num);
            sum += num;
        }

        int doubleSum = 0;
        for (int num : uniqueNums) {
            doubleSum += 2 * num;
        }

        return doubleSum - sum;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1};
        System.out.println((new Solution3()).singleNumber(nums));
    }
}
