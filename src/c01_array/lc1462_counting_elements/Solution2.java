package c01_array.lc1462_counting_elements;

import java.util.Arrays;

/**
 * This is the solution of No. xxx problem in the LeetCode,
 * the website of the problem is as follow:
 * xxx
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an integer array arr, count element x such that x + 1 is also in arr.
 *
 * If there're duplicates in arr, count them separately.
 *
 * Example 1:
 * Input: arr = [1,2,3]
 * Output: 2
 * Explanation: 1 and 2 are counted cause 2 and 3 are in arr.
 *
 * Example 2:
 * Input: arr = [1,1,3,3,5,5,7,7]
 * Output: 0
 * Explanation: No numbers are counted, cause there's no 2, 4, 6, or 8 in arr.
 *
 * Example 3:
 * Input: arr = [1,3,2,3,5,0]
 * Output: 3
 * Explanation: 0, 1 and 2 are counted cause 1, 2 and 3 are in arr.
 *
 * Example 4:
 * Input: arr = [1,1,2,2]
 * Output: 2
 * Explanation: Two 1s are counted cause 2 is in arr.
 *
 * Constraints:
 * - 1 <= arr.length <= 1000
 * - 0 <= arr[i] <= 1000
 * ==========================================================================================================
 *
 * Tags: array;hash table;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution2 {
    /**
     * Approach 2: Sort
     * Time Complexity: O(n * log(n))
     * Space Complexity: O(1)
     *
     * @param arr int[], the input integer array
     * @return int, the number of elements `x` whose `x+1` also in `arr`
     */
    public int countElements(int[] arr) {
        Arrays.sort(arr);
        int ans = 0;
        for (int i = 1, dupli = 1; i < arr.length; ++i) {
            if (arr[i] == arr[i-1] + 1) {
                ans += dupli;
            }
            dupli = arr[i] == arr[i-1] ? dupli + 1 : 1;
        }
        return ans;
    }
}