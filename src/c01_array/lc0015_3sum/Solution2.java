package c01_array.lc0015_3sum;

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
public class Solution2 {
    /**
     * Approach 2: Hash Table
     * Time Complexity: O(N ^ 2)
     * Space Complexity: O(N)
     *
     * Result of Submission:
     * Runtime: 297 ms, faster than 18.65% of Java online submissions for 3Sum.
     * Memory Usage: 46.5 MB, less than 91.87% of Java online submissions for 3Sum.
     *
     * @param nums int[], input array
     * @return List<List<Integer>>, all unique triplets in the array which gives the sum of zero
     */
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new LinkedList<>();
        }
        // Step 1: sort all the integers in the array, O(N * log(N))
        Arrays.sort(nums);
        // Step 2: find out all the triplets which give the sum of zero, O(N ^ 2)
        int n = nums.length;
        Set<List<Integer>> ans = new HashSet<>();
        for (int i = 0; i < n - 2; ++i) {
            if (i > 0 && nums[i-1] == nums[i]) {
                continue;
            }
            Set<Integer> s = new HashSet<>();
            for (int j = i + 1; j < n; ++j) {
                if (!s.contains(nums[j])) {
                    s.add(-nums[i]-nums[j]);
                } else {
                    ans.add(Arrays.asList(nums[i], -nums[i]-nums[j], nums[j]));
                }
            }
        }
        return new LinkedList<>(ans);
    }

    public static void main(String[] args) {
        int[] nums0 = new int[] {-1, 0, 1, 2, -1, -4};
        int[] nums1 = new int[] {0, 0, 0, 0};
        int[] nums2 = new int[] {0, 0, 0, -1, -1, 0};
        Solution2 solution = new Solution2();
        System.out.println(solution.threeSum(nums0));
        System.out.println(solution.threeSum(nums1));
        System.out.println(solution.threeSum(nums2));
    }
}