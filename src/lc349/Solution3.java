package lc349;

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
public class Solution3 {
    /**
     * 解法3：二分查找
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

        if (nums1.length == 0 || nums2.length == 0) {
            return new int[] {};
        }

        Arrays.sort(nums2);

        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            if (binarySearch(nums2, num)) {
                set.add(num);
            }
        }

        int[] res = new int[set.size()];
        int k = 0;
        for (int num : set) {
            res[k++] = num;
        }
        return res;
    }

    private boolean binarySearch(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] res = (new Solution3()).intersection(nums1, nums2);
        PrintUtil.printArray(res);
    }
}
