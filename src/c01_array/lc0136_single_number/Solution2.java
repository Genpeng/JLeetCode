package c01_array.lc0136_single_number;

import java.util.HashMap;
import java.util.Map;

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
public class Solution2 {
    /**
     * 解法二：哈希表
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param nums int[], the input array of integers
     * @return int, the only integer which appears once
     */
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.remove(num);
            } else {
                map.put(num, 1);
            }
        }
        return map.entrySet().iterator().next().getKey();
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1};
        System.out.println((new Solution2()).singleNumber(nums));
    }
}
