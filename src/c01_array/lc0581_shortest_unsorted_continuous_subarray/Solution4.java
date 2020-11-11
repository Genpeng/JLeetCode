package c01_array.lc0581_shortest_unsorted_continuous_subarray;

/**
 * This is the solution of No. 581 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray
 * in ascending order, then the whole array will be sorted in ascending order.
 *
 * Return the shortest such subarray and output its length.
 *
 * Example 1:
 * Input: nums = [2,6,4,8,10,9,15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 *
 * Example 2:
 * Input: nums = [1,2,3,4]
 * Output: 0
 *
 * Example 3:
 * Input: nums = [1]
 * Output: 0
 *
 * Constraints:
 * - 1 <= nums.length <= 104
 * - -10^5 <= nums[i] <= 10^5
 * ==========================================================================================================
 *
 * Difficulty: Medium
 * Tags: array;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution4 {
    /**
     * Approach 4
     * 无序子数组的最小值决定左边界，最大值决定右边界。
     *
     * References:
     * [1] https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/solution/zui-duan-wu-xu-lian-xu-zi-shu-zu-by-leetcode/
     * [2] https://leetcode.com/problems/shortest-unsorted-continuous-subarray/discuss/103057/Java-O(n)-Time-O(1)-Space
     *
     * Complexity Analysis:
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     *
     * @param nums int[], the input integer array
     * @return int, the length of shortest such subarray
     */
    public int findUnsortedSubarray(int[] nums) {
        final int n = nums.length;
        // 找出无序子数组的最小值（如果存在逆序的情况）
        boolean isReverse = false;
        int minVal = Integer.MAX_VALUE;
        for (int i = 1; i < n; ++i) {
            if (nums[i] < nums[i-1]) {
                isReverse = true;
            }
            if (isReverse) {
                minVal = Math.min(minVal, nums[i]);
            }
        }
        // 找出无序子数组的最大值（如果存在逆序的情况）
        isReverse = false;
        int maxVal = Integer.MIN_VALUE;
        for (int i = n - 2; i >= 0; --i) {
            if (nums[i] > nums[i+1]) {
                isReverse = true;
            }
            if (isReverse) {
                maxVal = Math.max(maxVal, nums[i]);
            }
        }
        // 找到无序子数组左边部分第一个比 minVal 大的值
        int l = 0;
        for (; l < n; ++l) {
            if (nums[l] > minVal) {
                break;
            }
        }
        // 找到无序子数组右边部分第一个比 maxVal 小的值
        int r = n - 1;
        for (; r >= 0; --r) {
            if (nums[r] < maxVal) {
                break;
            }
        }
        return r - l < 0 ? 0 : r - l + 1;
    }

    public static void main(String[] args) {
        Solution4 solu = new Solution4();
        System.out.println(solu.findUnsortedSubarray(new int[] {2, 6, 4, 8, 10, 9, 15}) == 5);
        System.out.println(solu.findUnsortedSubarray(new int[] {1, 2, 3, 4}) == 0);
        System.out.println(solu.findUnsortedSubarray(new int[] {1}) == 0);
    }
}