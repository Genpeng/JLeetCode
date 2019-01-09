package array.leetcode349;

import util.PrintUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * This is the solution of No. 349 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/intersection-of-two-arrays/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 *
 * Example 2:
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 *
 * Note:
 * Each element in the result must be unique.
 * The result can be in any order.
 * ==========================================================================================================
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2019/01/09
 */
public class Solution1 {
    /**
     * 解法1：使用两个集合
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param nums1 int[], one array
     * @param nums2 int[], the other array
     * @return int[], the intersection of two arrays
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            throw new IllegalArgumentException("[ERROR] There exists at least one null array!");
        }

        Set<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }

        Set<Integer> set2 = new HashSet<>();
        for (int num : nums2) {
            if (set1.contains(num)) {
                set2.add(num);
            }
        }

        int[] res = new int[set2.size()];
        int i = 0;
        for (int num : set2) {
            res[i++] = num;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] res = (new Solution1()).intersection(nums1, nums2);
        PrintUtil.printArray(res);
    }
}
