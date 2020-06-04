package c01_array.lc0016_3sum_closest;

import java.util.Arrays;

/**
 * This is the solution of No. 16 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/3sum-closest/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an array nums of n integers and an integer target, find three integers in nums such that
 * the sum is closest to target. Return the sum of the three integers. You may assume that
 * each input would have exactly one solution.
 *
 * Example:
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * ==========================================================================================================
 *
 * Tags: array;two pointers;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * Approach 1: Two Pointers
     * Time Complexity: O(N ^ 2)
     * Space Complexity: O(1)
     *
     * Result of Submission:
     * Runtime: 3 ms, faster than 98.45% of Java online submissions for 3Sum Closest.
     * Memory Usage: 39 MB, less than 6.67% of Java online submissions for 3Sum Closest.
     *
     * @param nums int[], the input integer array
     * @param target int, the target integer
     * @return int, the sum closest to target
     */
    public int threeSumClosest(int[] nums, int target) {
//        if (nums == null || nums.length < 3) {
//            throw new IllegalArgumentException("[ERROR] The input array is null or the size of array is less than 3!!!");
//        }
        // Step 1: sort all the integers in the array
        Arrays.sort(nums);
        // Step 2: find out the closest sum
        int n = nums.length;
        int ans = nums[0] + nums[1] + nums[n-1];
        for (int i = 0; i < n - 2; ++i) {
            int l = i + 1, r = n - 1;
            while (l < r) {
                int s = nums[i] + nums[l] + nums[r];
                if (s < target) {
                    ++l;
                } else if (s > target) {
                    --r;
                } else {
                    return target;
                }
                if (Math.abs(s - target) < Math.abs(ans - target)) {
                    ans = s;
                }
            }
            while (i < n - 2 && nums[i] == nums[i+1]) {
                ++i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution1 solu = new Solution1();
        System.out.println(solu.threeSumClosest(new int[] {-1, 2, 1, -4}, 1));
    }
}