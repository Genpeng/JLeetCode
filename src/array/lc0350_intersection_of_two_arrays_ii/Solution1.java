package array.lc0350_intersection_of_two_arrays_ii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is the solution of No. 350 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/intersection-of-two-arrays-ii/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 *
 * Example 2:
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 *
 * Note:
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 *
 * Follow up:
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that
 * you cannot load all elements into the memory at once?
 * ==========================================================================================================
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2019/03/16
 */
public class Solution1 {
    /**
     * 解法1：利用Map对元素进行计数
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param nums1 int[], one of integer array
     * @param nums2 int[], the other integer array
     * @return int[], the intersection of two array
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            throw new IllegalArgumentException("[ERROR] There exists at least one null array!");
        }

        if (nums1.length == 0 || nums2.length == 0) {
            return new int[] {};
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (map.getOrDefault(num, 0) > 0) {
                list.add(num);
                map.put(num, map.get(num) - 1);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); ++i) {
            res[i] = list.get(i);
        }
        return res;
    }
}
