package c02_string.lc0022_generate_parentheses;

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
public class Solution1 {
    /**
     * Approach 1: Brute Force (recursion without pruning)
     * The idea is to find out all the possible combinations and check if it is valid.
     *
     * Complexity Analysis:
     * Time Complexity: O(n * 2 ^ (2n))
     * Space Complexity: O(n)
     *
     * Result of Submission:
     * Runtime: 1 ms, faster than 85.01% of Java online submissions for Generate Parentheses.
     * Memory Usage: 39.5 MB, less than 70.81% of Java online submissions for Generate Parentheses.
     *
     * @param n int, the number of pairs of parentheses
     * @return List<String>, all combinations of well-formed parentheses
     */
    public List<String> generateParenthesis(int n) {
        List<String> ans = new LinkedList<>();
        char[] path = new char[2 * n];
        generateParenthesis(0, path, ans);
        return ans;
    }

    private void generateParenthesis(int idx, char[] path, List<String> ans) {
        if (idx == path.length) {
            if (isValid(path)) {
                ans.add(new String(path));
            }
            return;
        }
        path[idx] = '(';
        generateParenthesis(idx + 1, path, ans);
        path[idx] = ')';
        generateParenthesis(idx + 1, path, ans);
    }

    private boolean isValid(char[] s) {
        int k = 0;
        for (char c : s) {
            k += c == '(' ? 1 : -1;
            if (k < 0) {
                return false;
            }
        }
        return k == 0;
    }

    public static void main(String[] args) {
        int n = 3;
        Solution1 solu = new Solution1();
        List<String> combs = solu.generateParenthesis(n);
        System.out.println(combs);
    }
}