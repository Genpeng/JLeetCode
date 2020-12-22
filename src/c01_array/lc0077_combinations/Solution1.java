package c01_array.lc0077_combinations;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * This is the solution of No. 77 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/combinations/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * You may return the answer in any order.
 *
 * Example 1:
 * Input: n = 4, k = 2
 * Output:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * Example 2:
 * Input: n = 1, k = 1
 * Output: [[1]]
 *
 * Constraints:
 * - 1 <= n <= 20
 * - 1 <= k <= n
 * ==========================================================================================================
 *
 * Difficulty: Medium
 * Tags: backtrack;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * Approach 1: Backtracking without pruning
     *
     * Reference:
     * [1] https://leetcode-cn.com/problems/combinations/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-ma-/
     *
     * Complexity Analysis:
     * Time Complexity: xxx
     * Space Complexity: xxx
     *
     * @param n int, the range of elements
     * @param k int, the size of combination
     * @return List<List<Integer>>, all possible combinations
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combs = new LinkedList<>();
        Deque<Integer> path = new ArrayDeque<>();
        combine(n, k, 1, path, combs);
        return combs;
    }

    private void combine(int n, int k, int start, Deque<Integer> path, List<List<Integer>> combs) {
        if (path.size() == k) {
            combs.add(new LinkedList<>(path));
            return;
        }
        for (int i = start; i <= n; ++i) {
            path.offerLast(i);
            combine(n, k, i+1, path, combs);
            path.pollLast();
        }
    }
}