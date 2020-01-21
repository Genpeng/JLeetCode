package array.lc0026_remove_duplicates;

/**
 * This is the solution of No. 26 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once
 * and return the new length.
 *
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place
 * with O(1) extra memory.
 *
 * Example 1:
 * Given nums = [1,1,2],
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * It doesn't matter what you leave beyond the returned length.
 *
 * Example 2:
 * Given nums = [0,0,1,1,1,2,2,3,3,4],
 * Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3,
 * and 4 respectively.
 * It doesn't matter what values are set beyond the returned length.
 * ==========================================================================================================
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution {
    /**
     * 解法：双指针
     * 思路：
     * 利用一个快指针发现不重复的元素，利用一个慢指针指向元素的存储位置。
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     *
     * @param nums int[], the input array
     * @return int, the length of the array without duplicates
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int k = 1;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] != nums[i-1]) {
                nums[k] = nums[i];
                ++k;
            }
        }
        return k;
    }
}