package algo.sort;

import java.util.Arrays;

/**
 * Learn quick sort algorithm in practice
 *
 * @author  Lukas
 * @date    20230314
 */
public class QuickSort {
    public static void sort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        sort(nums, 0, nums.length - 1);
    }

    private static void sort(int[] nums, int li, int ri) {
        if (li >= ri) {
            return;
        }
        int splitPoint = partition(nums, li, ri);
        sort(nums, li, splitPoint - 1);
        sort(nums, splitPoint + 1, ri);
    }

    /**
     * The partition process used in quick sort, its rule is to move elements in the array
     * based on the pivot value, where the elements smaller than the pivot value is moving
     * to the left of split point, while the elements greater than pivot value is moving
     * to the right of split point.
     *
     * 快排中的 partition 操作，其作用是基于 pivot 值对数组中的元素进行移动，将小于 pivot 值的元素移动到
     * 分割点（split point）的左边，将大于 pivot 值的元素移动到分割点的右边
     *
     * @param nums int[], the input array
     * @param li int, the left index
     * @param ri int, the right index
     * @return int, the split point
     */
    private static int partition(int[] nums, int li, int ri) {
        int pivot = nums[ri];
        int i = li - 1;
        for (int j = li; j < ri; ++j) {
            if (nums[j] <= pivot) {
                ++i;
                if (j > i) {
                    swap(nums, j, i);
                }
            }
        }
        swap(nums, ++i, ri);
        return i;
    }

    public static void swap(int[] nums, int i, int j) {
        if (i != j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {13, 2, 18, 9, 6, 4, 1, 20};
        System.out.println(Arrays.toString(nums1));
        QuickSort.sort(nums1);
        System.out.println(Arrays.toString(nums1));

        int[] nums2 = {2, 1, 4, 3, 8, 6, 2, 6};
        System.out.println(Arrays.toString(nums2));
        QuickSort.sort(nums2);
        System.out.println(Arrays.toString(nums2));
    }
}
