package algo.sort;

import java.util.Arrays;

/**
 * Learn merge sort algorithm in practice
 *
 * @author  Lukas
 * @date    20230313
 */
public class MergeSort {
    public static void sort(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        sort(nums, 0, nums.length - 1);
    }

    private static void sort(int[] nums, int li, int ri) {
        if (li == ri) {
            return;
        }
        int mi = li + (ri - li) / 2;
        sort(nums, li, mi);
        sort(nums, mi + 1, ri);
        merge(nums, li, mi+1, ri);
    }

    /**
     * Merge two sorted sub-arrays in an array, where the left half starts from 0 to mi-1,
     * while the right half starts from mi to ri. The size of the array must be greater than
     * or equal to 2.
     *
     * @param nums int[], the array contains two sorted sub-arrays
     * @param li int, the start index of left half
     * @param mi int, the start index  of right half
     * @param ri int, the end index of right half
     */
    private static void merge(int[] nums, int li, int mi, int ri) {
//        int[] rightHalf = new int[ri - mi + 1];
//        for (int i = mi; i <= ri; ++i) {
//            rightHalf[i-mi] = nums[i];
//        }
        int[] rightHalf = Arrays.copyOfRange(nums, mi, ri+1);
        int i = mi - 1, j = ri - mi, k = ri;
        while (i >= li && j >= 0) {
            if (nums[i] > rightHalf[j]) {
                nums[k] = nums[i];
                --i;
            } else {
                nums[k] = rightHalf[j];
                --j;
            }
            --k;
        }
        while (j >= 0) {
            nums[k] = rightHalf[j];
            --j;
            --k;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 7, 9, 12, 4, 8, 10, 13};
        System.out.println(Arrays.toString(nums));
        MergeSort.merge(nums, 0, 4, 7);
        System.out.println(Arrays.toString(nums));

        int[] nums2 = {13, 2, 18, 9, 6, 4, 1, 20};
        System.out.println(Arrays.toString(nums2));
        MergeSort.sort(nums2);
        System.out.println(Arrays.toString(nums2));

        int[] nums3 = {2, 1, 4, 3, 8, 6, 2, 6};
        System.out.println(Arrays.toString(nums3));
        MergeSort.sort(nums3);
        System.out.println(Arrays.toString(nums3));
    }
}
