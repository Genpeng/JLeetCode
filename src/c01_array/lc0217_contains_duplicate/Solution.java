package c01_array.lc0217_contains_duplicate;

import java.util.HashSet;
import java.util.Set;

/**
 * This is the solution of No. 217 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/contains-duplicate/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given an array of integers, find if the array contains any duplicates.
 *
 * Your function should return true if any value appears at least twice in the array,
 * and it should return false if every element is distinct.
 *
 * Example 1:
 * Input: [1,2,3,1]
 * Output: true
 *
 * Example 2:
 * Input: [1,2,3,4]
 * Output: false
 *
 * Example 3:
 * Input: [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 * ==========================================================================================================
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numsHaveSeen = new HashSet<>();
        for (int num : nums) {
            if (numsHaveSeen.contains(num)) {
                return true;
            }
            numsHaveSeen.add(num);
        }
        return false;
    }
}