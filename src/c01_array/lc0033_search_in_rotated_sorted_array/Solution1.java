package c01_array.lc0033_search_in_rotated_sorted_array;

/**
 * This is the solution of No. 33 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 *
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * ==========================================================================================================
 *
 * Difficulty: Medium
 * Tags:array;binary search;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * Approach 1: Binary Search
     * Time Complexity: O(log(N))
     * Space Complexity: O(1)
     *
     * Result of Submission:
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in Rotated Sorted Array.
     * Memory Usage: 38.9 MB, less than 88.36% of Java online submissions for Search in Rotated Sorted Array.
     *
     * @param nums int[], the input array
     * @param target int, the integer to search
     * @return int, the index of target integer
     */
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        // Step 1: find out the index of minimum, O(log(N))
        int offset = findMinIndex(nums, n); // when n == 0, meaningless
        // Step 2: search the target value, O(log(N))
        return findTargetIndex(nums, n, offset, target);
    }

    private int findMinIndex(int[] nums, int n) {
        int li = 0, ri = n - 1;
        while (li < ri) {
            int mi = li + ((ri - li) >> 1);
            if (nums[mi] > nums[ri]) {
                li = mi + 1;
            } else {
                ri = mi;
            }
        }
        return li;
    }

    private int findTargetIndex(int[] nums, int n, int offset, int target) {
        int li = 0, ri = n - 1;
        int ti = -1;
        while (li <= ri) {
            int mi = li + ((ri - li) >> 1);
            int realMi = (mi + offset) % n;
            if (nums[realMi] == target) {
                ti = realMi;
                break;
            } else if (nums[realMi] < target) {
                li = mi + 1;
            } else {
                ri = mi - 1;
            }
        }
        return ti;
    }

    /**
     * The template of binary search.
     *
     * @param nums int[], the input integer array
     * @param li int, the index of left bound
     * @param ri int, the index of right bound
     * @param target int, the target integer
     * @return int, if found in the array return its index, otherwise return -1
     */
    public int binarySearch(int[] nums, int li, int ri, int target) {
        int ti = -1;
        while (li <= ri) {
            int mi = li + ((ri - li) >> 1);
            if (nums[mi] == target) {
                ti = mi;
                break;
            } else if (nums[mi] < target) {
                li = mi + 1;
            } else {
                ri = mi - 1;
            }
        }
        return -1;
    }

    /**
     * Approach 1: Binary Search
     * 思路为采用二分查找进行搜索，在进行范围缩减时，如果满足 target 在左边界（li）和中间位置（mi）中间时，
     * 即当满足一下三个条件时，将右边界更新到中间位置（ri = mi），
     * 1. nums[li] <= target <= nums[mi]
     * 2. nums[mi] < nums[li] <= target
     * 3. target <= nums[mi] < nums[li]
     * 其他情况则更新左边界到 mi+1
     *
     * Complexity Analysis:
     * - Time Complexity: O(log(N))
     * - Space Complexity: O(1)
     *
     * @param nums int[], the input array
     * @param target int, the integer to search
     * @return int, the index of target integer
     */
    public int searchV2(int[] nums, int target) {
        if (nums == null || nums.length == 0 || (nums.length == 1 && nums[0] != target)) {
            return -1;
        }
        int n = nums.length;
        int li = 0, ri = n-1;
        while (li < ri) {
            int mi = li + ((ri-li) >> 1);
            if ((nums[li] <= target && target <= nums[mi])
                || (nums[mi] < nums[li] && nums[li] <= target)
                || (target <= nums[mi] && nums[mi] < nums[li])) {
                ri = mi;
            } else {
                li = mi + 1; // 当只剩下两个元素的时候，比如：[1, 3]，如果 li 的更新公式为 li = mi，则无法挑出循环
            }
        }
        return li == ri && nums[li] == target ? li : -1;
    }

    /**
     * Approach 1: Binary Search (Recommended)
     * 思路为采用二分查找进行搜索，在进行范围缩减时，如果满足 target 在左边界（li）和中间位置（mi）中间时，
     * 即当满足一下三个条件时，将右边界更新到中间位置（ri = mi），
     * 1. nums[li] <= target <= nums[mi]
     * 2. nums[mi] < nums[li] <= target
     * 3. target <= nums[mi] < nums[li]
     * 其他情况则更新左边界到 mi+1
     *
     * 在上一个方法的基础上，进一步简化条件，对于下面三个条件，当满足 2 个时，
     * 1. nums[li] <= target
     * 2. nums[mi] < nums[li]
     * 3. target <= nums[mi]
     * 满足 target 位于左边界（li）和中间位置（mi）。
     *
     * 如果三个条件进行异或，当结果为假时（两个条件为真），满足 target 位于左边界（li）和中间位置（mi）；
     * 当结果为真（一个条件为真），target 位于左边界和中间位置的两侧
     *
     * Complexity Analysis:
     * - Time Complexity: O(log(N))
     * - Space Complexity: O(1)
     *
     * @param nums int[], the input array
     * @param target int, the integer to search
     * @return int, the index of target integer
     */
    public int searchV3(int[] nums, int target) {
        if (nums == null || nums.length == 0 || (nums.length == 1 && nums[0] != target)) {
            return -1;
        }
        int n = nums.length;
        int li = 0, ri = n-1;
        while (li < ri) {
            int mi = li + ((ri-li) >> 1);
            if ((nums[li] <= target) ^ (nums[mi] < nums[li]) ^ (target <= nums[mi])) {
                li = mi + 1;
            } else {
                ri = mi;
            }
        }
        return li == ri && nums[li] == target ? li : -1;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {4, 5, 6, 7, 8, 0, 1, 2, 3};
        int[] nums2 = new int[] {1, 3};
        int target = 5;
        Solution1 solu = new Solution1();
        // test `findMinIdx(...)` function
//        System.out.println(solu.findMinIndex(nums1, nums1.length));
//        System.out.println(solu.findMinIndex(nums2, nums2.length));
        // test `search(...)` function
//        System.out.println(solution.searchV1(nums1, target));
//        System.out.println(solution.searchV1(nums2, target));

        int result = solu.searchV2(nums2, target=1);
        System.out.println(result);
    }
}