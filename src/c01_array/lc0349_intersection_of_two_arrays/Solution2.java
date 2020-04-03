package c01_array.lc0349_intersection_of_two_arrays;

import util.PrintUtil;

import java.util.Arrays;
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
public class Solution2 {
    /**
     * 解法2：双指针
     * 时间复杂度：O(n * log(n))
     * 空间复杂度：O(k)，其中，k表示交集的大小
     *
     * @param nums1 int[], one array
     * @param nums2 int[], the other array
     * @return int[], the intersection of two arrays
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            throw new IllegalArgumentException("[ERROR] There exists at least one null array!");
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;
        Set<Integer> set = new HashSet<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                ++i;
            } else if (nums1[i] > nums2[j]) {
                ++j;
            } else { // nums1[i] == nums2[j]
                set.add(nums1[i]);
                ++i;
                ++j;
            }
        }

        int idx = 0;
        int[] res = new int[set.size()];
        for (int num : set) {
            res[idx++] = num;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] res = (new Solution2()).intersection(nums1, nums2);
        PrintUtil.printArray(res);
    }
}
