package array.lc0015_3sum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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
public class Solution2 {
    /**
     * 解法二：双指针
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     *
     * @param nums int[], input array
     * @return List<List<Integer>>, all unique triplets in the array which gives the sum of zero
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new LinkedList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        int n = nums.length;
        for (int i = 0; i < n-2; ++i) {
            if (i > 0 && nums[i-1] == nums[i]) {
                continue;
            }
            int l = i + 1, r = n - 1;
            while (l < r) {
                int s = nums[i] + nums[l] + nums[r];
                if (s < 0) {
                    ++l;
                } else if (s > 0) {
                    --r;
                } else {
                    res.add(Arrays.asList(nums[i], nums[l++], nums[r++]));
                    while (l < r && nums[l] == nums[l+1]) {
                        ++l;
                    }
                    while (l < r && nums[r] == nums[r-1]) {
                        --r;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {-1, 0, 1, 2, -1, -4};
        System.out.println((new Solution2()).threeSum(nums));
    }
}