package array.lc0016_3sum_closest;

import java.util.Arrays;

/**
 * This is the solution of No. 16 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/3sum-closest/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an array nums of n integers and an integer target, find three integers in nums such that
 * the sum is closest to target. Return the sum of the three integers. You may assume that
 * each input would have exactly one solution.
 * <p>
 * Example:
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * ==========================================================================================================
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution {
    /**
     * 解法：Two pointers
     * 时间复杂度：O(N ^ 2)
     * 空间复杂度：O(1)
     *
     * @param nums int[], the input integer array
     * @param target int, the target integer
     * @return int, the sum closest to target
     */
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            throw new IllegalArgumentException("[ERROR] The size of input array is less than 3!!!");
        }
        // Step 1: sort all the integers in the array
        Arrays.sort(nums);
        // Step 2: find three integers in the array such that the sum is cloest to target
        int n = nums.length;
        int cs = nums[0] + nums[1] + nums[n-1]; // closest sum
        int ce = Math.abs(cs - target); // closest error
        for (int i = 0; i < n - 2; ++i) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int l = i + 1, r = n - 1;
            while (l < r) {
                int s = nums[i] + nums[l] + nums[r];
                int e = Math.abs(s - target);
                if (e < ce) {
                    cs = s;
                    ce = e;
                }
                if (s < target) {
                    ++l;
                } else if (s > target) {
                    --r;
                } else {
                    return cs;
                }
            }
        }
        return cs;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {-1, 0, 1, 1, 55};
        int target = 3;
        Solution solution = new Solution();
        int closestSum = solution.threeSumClosest(nums, target);
        System.out.println(closestSum);
    }
}