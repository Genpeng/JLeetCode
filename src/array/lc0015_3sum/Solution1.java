package array.lc0015_3sum;

import java.util.*;

/**
 * This is the solution of No. 15 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/3sum/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 * ==========================================================================================================
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2019/05/06
 */
public class Solution1 {
    /**
     * 解法（Deprecated）：Brute Force
     * 时间复杂度：O(n^3)
     * 空间复杂度：O(n)
     *
     * @param nums int[], input array
     * @return List<List<Integer>>, all unique triplets in the array which gives the sum of zero
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new LinkedList<>();
        }
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new LinkedList<>();
        for (int i = 0; i < n - 2; ++i) {
            int a = nums[i];
            if (i > 0 && a == nums[i-1]) {
                continue;
            }
            for (int j = i + 1; j < n - 1; ++j) {
                int b = nums[j];
                if (j > i + 1 && b == nums[j-1]) {
                    continue;
                }
                for (int k = j + 1; k < n; ++k) {
                    int c = nums[k];
                    if (k > j + 1 && c == nums[k-1]) {
                        continue;
                    }
                    if (c == -(a + b)) {
                        ans.add(Arrays.asList(a, b, c));
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums0 = new int[] {-1, 0, 1, 2, -1, -4};
        int[] nums1 = new int[] {0, 0, 0, 0};
        System.out.println((new Solution1()).threeSum(nums0));
        System.out.println((new Solution1()).threeSum(nums1));
    }
}