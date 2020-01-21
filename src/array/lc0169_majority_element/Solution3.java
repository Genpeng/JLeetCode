package array.lc0169_majority_element;

/**
 * This is the solution of No. 169 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/majority-element/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an array of size n, find the majority element. The majority element is the element that
 * appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Example 1:
 * Input: [3,2,3]
 * Output: 3
 *
 * Example 2:
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 * ==========================================================================================================
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2019/03/14
 */
public class Solution3 {
    /**
     * 解法3：多数投票算法（Boyer-Moore majority vote algorithm）
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param nums int[], the array contains majority element
     * @return int, the majority element
     */
    public int majorityElement(int[] nums) {
        int m = nums[0], count = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (count == 0) {
                m = nums[i];
                count = 1;
            } else if (nums[i] == m) {
                ++count;
            } else { // nums[i] != m
                --count;
            }
        }
        return m;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 1, 1, 1, 2};
        System.out.println((new Solution3()).majorityElement(nums));
    }
}
