package c02_string.lc0022_generate_parentheses;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * This is the solution of No. 22 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/generate-parentheses/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 * ==========================================================================================================
 *
 * Tags: string;backtracking;dfs;bfs;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution4 {
    /**
     * Approach 4: "Dynamic Programming" (Optional)
     *
     * Complexity Analysis:
     * Time Complexity: O(4 ^ n / sqrt(n))
     * Space Complexity: O(4 ^ n / sqrt(n))
     *
     * @param n int, the number of pairs of parentheses
     * @return List<String>, all combinations of well-formed parentheses
     */
    public List<String> generateParenthesis(int n) {
        List<List<String>> dp = new ArrayList<>();
        List<String> dp0 = new LinkedList<>();
        dp0.add("");
        dp.add(dp0);
        for (int i = 1; i <= n; ++i) {
            List<String> dpi = new LinkedList<>();
            for (int j = 0; j < i; ++j) {
                List<String> lefts = dp.get(j);
                List<String> rights = dp.get(i-j-1);
                for (String left : lefts) {
                    for (String right : rights) {
                        dpi.add(String.format("(%s)%s", left, right));
                    }
                }
            }
            dp.add(dpi);
        }
        return dp.get(n);
    }
}