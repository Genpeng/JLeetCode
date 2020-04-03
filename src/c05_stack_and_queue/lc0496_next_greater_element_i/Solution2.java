package c05_stack_and_queue.lc0496_next_greater_element_i;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * This is the solution of No. 496 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/next-greater-element-i/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2.
 * Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
 * <p>
 * The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2.
 * If it does not exist, output -1 for this number.
 * <p>
 * Example 1:
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * Output: [-1,3,-1]
 * Explanation:
 * For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
 * For number 1 in the first array, the next greater number for it in the second array is 3.
 * For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
 * <p>
 * Example 2:
 * Input: nums1 = [2,4], nums2 = [1,2,3,4].
 * Output: [3,-1]
 * Explanation:
 * For number 2 in the first array, the next greater number for it in the second array is 3.
 * For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
 * <p>
 * Note:
 * - All elements in nums1 and nums2 are unique.
 * - The length of both nums1 and nums2 would not exceed 1000.
 * ==========================================================================================================
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution2 {
    /**
     * 解法2：单调栈
     * 时间复杂度：O(m + n)
     * 空间复杂度：O(n)
     *
     * Runtime: 5 ms, faster than 38.19% of Java online submissions for Next Greater Element I.
     * Memory Usage: 40.9 MB, less than 7.41% of Java online submissions for Next Greater Element I.
     *
     * @param nums1 int[], the first input array
     * @param nums2 int[], the second input array
     * @return int[], the next greater numbers for nums1's elements
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            // 防止nums2为空，当nums2元素的数目大于等于0时，都能正确返回
            return new int[] {};
        }
        // Step 1: find out the next greater number for each element in the nums2, O(n)
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && num > stack.peek()) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }
        // Step 2: take out the answer for each element in the nums1, O(m)
        int n1 = nums1.length;
        int[] ans = new int[n1];
        for (int i = 0; i < n1; ++i) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {4, 1, 2};
        int[] nums2 = new int[] {1, 3, 4, 2};
        Solution2 solution = new Solution2();
        int[] ans = solution.nextGreaterElement(nums1, nums2);
        System.out.println(Arrays.toString(ans));
    }
}