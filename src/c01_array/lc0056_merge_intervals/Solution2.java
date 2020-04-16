package c01_array.lc0056_merge_intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * This is the solution of No. 56 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/merge-intervals/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 *
 * Example 2:
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 * NOTE:
 * - input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 * ==========================================================================================================
 *
 * Tags: array;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution2 {
    /**
     * Approach 2: Sort
     * Time Complexity: O(n * log(n))
     * Space Complexity: O(log(n))
     *
     * @param intervals int[][], a collection of intervals
     * @return int[][], the modified collection
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
//        Arrays.sort(intervals, (i1, i2) -> i1[0] - i2[0]);
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        List<int[]> ans = new LinkedList<>();
        ans.add(intervals[0]);
        int[] lastInterval = intervals[0];
        for (int[] interval : intervals) {
            if (lastInterval[1] >= interval[0]) {
                lastInterval[1] = Math.max(lastInterval[1], interval[1]);
            } else {
                ans.add(interval);
                lastInterval = interval;
            }
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}