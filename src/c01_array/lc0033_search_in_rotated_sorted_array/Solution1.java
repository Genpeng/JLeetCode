package c01_array.lc0033_search_in_rotated_sorted_array;

/**
 * This is the solution of No. 33 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * <p>
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * Example 1:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * <p>
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * ==========================================================================================================
 *
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
    public int searchV1(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        // Step 1: find out the index of minimum, O(log(N))
        int minIdx = findMinIdx(nums); // when n == 0, meaningless
        // Step 2: search the target value, O(log(N))
        int li = 0, ri = n - 1;
        while (li <= ri) {
            int mi = li + ((ri - li) >> 1);
            int realMi = (mi + minIdx) % n;
            if (nums[realMi] < target) {
                li = mi + 1;
            } else if (nums[realMi] > target) {
                ri = mi - 1;
            } else {
                return realMi;
            }
        }
        return -1;
    }

    /**
     * Approach 1: Binary Search
     * Time Complexity: O(log(N))
     * Space Complexity: O(1)
     *
     * Result of Submission:
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in Rotated Sorted Array.
     * Memory Usage: 38.4 MB, less than 44.65% of Java online submissions for Search in Rotated Sorted Array.
     *
     * @param nums int[], the input array
     * @param target int, the integer to search
     * @return int, the index of target integer
     */
    public int searchV2(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        // Step 1: find out the index of minimum integer, O(log(N))
        int minIdx = findMinIdx(nums);
        // Step 2: shrink the search range
        int li = 0, ri = nums.length - 1;
        if (target > nums[ri]) {
            ri = minIdx - 1;
        } else {
            li = minIdx;
        }
        // Step 3: find out the target index by using binary search, O(log(N))
        return binarySearch(nums, li, ri, target);
    }

    private int findMinIdx(int[] nums) {
        int li = 0, ri = nums.length - 1;
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

    public int binarySearch(int[] nums, int li, int ri, int target) {
        while (li <= ri) {
            int mi = li + ((ri - li) >> 1);
            if (nums[mi] == target) {
                return mi;
            } else if (nums[mi] < target) {
                li = mi + 1;
            } else {
                ri = mi - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[] {4, 5, 6, 7, 0, 1, 2};
        int[] nums2 = new int[] {5, 1, 3};
        int target = 5;
        Solution1 solu = new Solution1();
        // test `findMinIdx(...)` function
        System.out.println(solu.findMinIdx(nums1));
        System.out.println(solu.findMinIdx(nums2));
        // test `search(...)` function
//        System.out.println(solution.searchV1(nums1, target));
//        System.out.println(solution.searchV1(nums2, target));
    }
}