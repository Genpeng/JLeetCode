package c01_array.lc0912_sort_an_array;

import java.util.Arrays;

/**
 * This is the solution of No. 912 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/sort-an-array/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an array of integers nums, sort the array in ascending order.
 *
 * Example 1:
 * Input: nums = [5,2,3,1]
 * Output: [1,2,3,5]
 *
 * Example 2:
 * Input: nums = [5,1,1,2,0,0]
 * Output: [0,0,1,1,2,5]
 *
 * Constraints:
 * 1 <= nums.length <= 50000
 * -50000 <= nums[i] <= 50000
 * ==========================================================================================================
 *
 * Tags: array;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * Approach 1: Quick Sort
     * Time Complexity: O(n * log(n))
     * Space Complexity: O(log(n))
     *
     * @param nums int[], an array
     * @return int[], the sorted array
     */
    public int[] sortArray(int[] nums) {
        quicksort(nums);
        return nums;
    }

    private void quicksort(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("[ERROR] The input array is null!!!");
        }
        quicksort(nums, 0, nums.length - 1);
    }

    private void quicksort(int[] nums, int li, int ri) {
        if (li >= ri) {
            return;
        }
        int splitIndex = partitionV2(nums, li, ri);
        quicksort(nums, li, splitIndex - 1);
        quicksort(nums, splitIndex + 1, ri);
    }

    private int partitionV1(int[] nums, int li, int ri) {
        int pivot = nums[ri]; // 关注点1
        int i = li - 1;
        for (int j = li; j < ri; ++j) {
            if (nums[j] <= pivot) {
                ++i; // 关注点2，不可以放到下面的判断体中
                if (i < j) {
                    swap(nums, i, j);
                }
            }
        }
        swap(nums, ++i, ri);
        return i;
    }

    private int partitionV2(int[] nums, int li, int ri) {
        int pivot = nums[li];
        int lm = li + 1, rm = ri;
        while (true) {
            while (lm <= rm && nums[lm] <= pivot) {
                ++lm;
            }
            while (lm <= rm && nums[rm] >= pivot) {
                --rm;
            }
            if (lm > rm) {
                break;
            }
            swap(nums, lm, rm);
        }
        swap(nums, li, rm);
        return rm;
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1};
        Solution1 solution = new Solution1();
        System.out.println(Arrays.toString(solution.sortArray(nums)));
    }
}