package c01_array.lc0015_3sum;

import java.util.*;

/**
 * This is the solution of No. 15 problem in the LeetCode,
 * the website of the problem is as follows:
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
 * Difficulty: Medium
 * Tags: array;hash table;two pointers;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 * @date   2019/05/06
 */
public class Solution1 {
    /**
     * Approach 1: Brute Force
     *
     * Complexity Analysis:
     * Time Complexity: O(N ^ 3)
     * Space Complexity: O(1)
     *
     * Result of Submission:
     * Time Limit Exceeded
     *
     * @param nums int[], input array
     * @return List<List<Integer>>, all unique triplets in the array which gives the sum of zero
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        if (nums == null || nums.length < 3) {
            return ans;
        }
        // Step 1: sort all the integers in the array, O(N * log(N))
        Arrays.sort(nums);
        // Step 2: find out all the triplets which give the sum of zero, O(N ^ 3)
        int n = nums.length;
        for (int i = 0; i < n - 2; ++i) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            for (int j = i + 1; j < n - 1; ++j) {
                if (j > i + 1 && nums[j] == nums[j-1]) {
                    continue;
                }
                for (int k = j + 1; k < n; ++k) {
                    if (k > j + 1 && nums[k] == nums[k-1]) {
                        continue;
                    }
                    if (nums[i] + nums[j] == -nums[k]) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums0 = new int[] {-1, 0, 1, 2, -1, -4};
        int[] nums1 = new int[] {0, 0, 0, 0};
        int[] nums2 = new int[] {0, 0, 0, -1, -1, 0};
        System.out.println((new Solution1()).threeSum(nums0));
        System.out.println((new Solution1()).threeSum(nums1));
        System.out.println((new Solution1()).threeSum(nums2));
    }
}