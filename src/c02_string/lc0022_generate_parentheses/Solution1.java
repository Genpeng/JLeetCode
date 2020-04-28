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
     * Time Complexity: O(n * 2 ^ (2n))
     * Space Complexity: O(n)
     *
     * @param n int, the number of pairs of parentheses
     * @return List<String>, all combinations of well-formed parentheses
     */
    public List<String> generateParenthesis(int n) {
        List<String> ans = new LinkedList<>();
        generateParenthesis(new char[2 * n], 0, ans);
        return ans;
    }

    private void generateParenthesis(char[] s, int idx, List<String> ans) {
        if (idx == s.length) {
            if (isValid(s)) {
                ans.add(new String(s));
            }
            return;
        }
        s[idx] = '(';
        generateParenthesis(s, idx + 1, ans);
        s[idx] = ')';
        generateParenthesis(s, idx + 1, ans);
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