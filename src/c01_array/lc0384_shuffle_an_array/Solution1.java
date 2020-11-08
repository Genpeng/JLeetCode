package c01_array.lc0384_shuffle_an_array;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This is the solution of No. 384 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/shuffle-an-array/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an integer array nums, design an algorithm to randomly shuffle the array.
 *
 * Implement the Solution class:
 * - Solution(int[] nums) Initializes the object with the integer array nums.
 * - int[] reset() Resets the array to its original configuration and returns it.
 * - int[] shuffle() Returns a random shuffling of the array.
 *
 * Example 1:
 * Input
 * ["Solution", "shuffle", "reset", "shuffle"]
 * [[[1, 2, 3]], [], [], []]
 * Output
 * [null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
 *
 * Explanation
 * Solution solution = new Solution([1, 2, 3]);
 * solution.shuffle();    // Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3]
 *                        // must be equally likely to be returned. Example: return [3, 1, 2]
 * solution.reset();      // Resets the array back to its original configuration [1,2,3]. Return [1, 2, 3]
 * solution.shuffle();    // Returns the random shuffling of array [1,2,3]. Example: return [1, 3, 2]
 *
 * Constraints:
 * - 1 <= nums.length <= 200
 * - -10^6 <= nums[i] <= 10^6
 * - All the elements of nums are unique.
 * - At most 5 * 104 calls will be made to reset and shuffle.
 * ==========================================================================================================
 *
 * Difficulty: Medium
 * Tags: array
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    private int[] original;
    private int[] curr;
    private Random rand = new Random();

    public Solution1(int[] nums) {
        original = nums;
        curr = nums.clone();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        curr = original.clone();
        return curr;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        List<Integer> aux = copyArrayToList();
        for (int i = 0; i < original.length; ++i) {
            int removeIdx = rand.nextInt(aux.size());
            curr[i] = aux.get(removeIdx);
            aux.remove(removeIdx);
        }
        return curr;
    }

    private List<Integer> copyArrayToList() {
        List<Integer> aux = new ArrayList<>();
        for (int i = 0; i < original.length; ++i) {
            aux.add(original[i]);
        }
        return aux;
    }
}