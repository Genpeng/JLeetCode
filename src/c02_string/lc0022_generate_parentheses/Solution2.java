package c02_string.lc0022_generate_parentheses;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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
public class Solution2 {

    // Recursive Version
    // ============================================================================================ //

    /**
     * Approach 2: Backtracking (or DFS), subtraction
     * This method is the improved version of Approach 1, the basic idea is the same as Approach 1,
     * but this time we generate all the possible combinations with pruning.
     *
     * Complexity Analysis:
     * Time Complexity: O(4 ^ n / sqrt(n))
     * Space Complexity: O(n)
     * TODO: How to analyze time complexity?
     *
     * Result of Submission:
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Generate Parentheses.
     * Memory Usage: 39.7 MB, less than 19.35% of Java online submissions for Generate Parentheses.
     *
     * @param n int, the number of pairs of parentheses
     * @return List<String>, all combinations of well-formed parentheses
     */
    public List<String> generateParenthesisV1(int n) {
        List<String> ans = new LinkedList<>();
        dfsV1(new StringBuilder(), n, n, ans);
        return ans;
    }

    /**
     * Traverse the binary tree by using DFS.
     *
     * @param sb StringBuilder, current string
     * @param left int, the remaining number of left brackets
     * @param right int, the remaining number of right brackets
     * @param ans List<String>, all combinations of well-formed parentheses
     */
    private void dfsV1(StringBuilder sb, int left, int right, List<String> ans) {
        if (left == 0 && right == 0) {
            ans.add(sb.toString());
            return;
        }
        if (left > 0) {
            dfsV1(sb.append("("), left - 1, right, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right > left) {
            dfsV1(sb.append(")"), left, right - 1, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    /**
     * Approach 2: Backtracking (or DFS), subtraction
     * This method is the improved version of Approach 1, the basic idea is the same as Approach 1,
     * but this time we generate all the possible combinations with pruning.
     *
     * Complexity Analysis:
     * Time Complexity: O(4 ^ n / sqrt(n))
     * Space Complexity: O(n)
     *
     * Result of Submission:
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Generate Parentheses.
     * Memory Usage: 39.7 MB, less than 19.35% of Java online submissions for Generate Parentheses.
     *
     * @param n int, the number of pairs of parentheses
     * @return List<String>, all combinations of well-formed parentheses
     */
    public List<String> generateParenthesisV2(int n) {
        List<String> ans = new LinkedList<>();
        dfsV2(new char[n << 1], 0, n, n, ans);
        return ans;
    }

    /**
     * Traverse the binary tree by using DFS.
     *
     * @param currStr char[], a char array represents current string
     * @param idx int, the index of current char with `idx+1` denotes the length of current string
     * @param left int, the remaining number of left brackets
     * @param right int, the remaining number of right brackets
     * @param ans List<String>, all combinations of well-formed parentheses
     */
    private void dfsV2(char[] currStr, int idx, int left, int right, List<String> ans) {
        if (idx == currStr.length) {
            ans.add(new String(currStr));
            return;
        }
        if (left > 0) {
            currStr[idx] = '(';
            dfsV2(currStr, idx + 1, left - 1, right, ans);
        }
        if (right > left) {
            currStr[idx] = ')';
            dfsV2(currStr, idx + 1, left, right - 1, ans);
        }
    }

    /**
     * Approach 2: Backtracking (or DFS), addition
     * This method is the improved version of Approach 1, the basic idea is the same as Approach 1,
     * but this time we generate all the possible combinations with pruning.
     *
     * Complexity Analysis:
     * Time Complexity: O(4 ^ n / sqrt(n))
     * Space Complexity: O(n)
     *
     * Result of Submission:
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Generate Parentheses.
     * Memory Usage: 39.8 MB, less than 19.35% of Java online submissions for Generate Parentheses.
     *
     * @param n int, the number of pairs of parentheses
     * @return List<String>, all combinations of well-formed parentheses
     */
    public List<String> generateParenthesisV3(int n) {
        List<String> ans = new LinkedList<>();
        dfsV3(new StringBuilder(), 0, 0, n, ans);
        return ans;
    }

    /**
     * Traverse the binary tree by using DFS.
     *
     * @param sb StringBuilder, current string
     * @param left int, the current number of left brackets
     * @param right int, the current number of right brackets
     * @param max int, the maximum number of left or right brackets
     * @param ans List<String>, all combinations of well-formed parentheses
     */
    private void dfsV3(StringBuilder sb, int left, int right, int max, List<String> ans) {
        if (left == max && right == max) {
            ans.add(sb.toString());
            return;
        }
        if (left < max) {
            dfsV3(sb.append("("), left + 1, right, max, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (left > right) {
            dfsV3(sb.append(")"), left, right + 1, max, ans);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    /**
     * Approach 2: Backtracking (or DFS), addition
     * This method is the improved version of Approach 1, the basic idea is the same as Approach 1,
     * but this time we generate all the possible combinations with pruning.
     *
     * Complexity Analysis:
     * Time Complexity: O(4 ^ n / sqrt(n))
     * Space Complexity: O(n)
     *
     * Result of Submission:
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Generate Parentheses.
     * Memory Usage: 39.8 MB, less than 19.35% of Java online submissions for Generate Parentheses.
     *
     * @param n int, the number of pairs of parentheses
     * @return List<String>, all combinations of well-formed parentheses
     */
    public List<String> generateParenthesisV4(int n) {
        List<String> ans = new LinkedList<>();
        dfsV4(new char[n << 1], 0, 0, 0, n, ans);
        return ans;
    }

    /**
     * Traverse the binary tree by using DFS.
     *
     * @param currStr char[], a char array represents current string
     * @param idx int, the index of current char with `idx+1` denotes the length of current string
     * @param left int, the current number of left brackets
     * @param right int, the current number of right brackets
     * @param max int, the maximum number of left or right brackets
     * @param ans List<String>, all combinations of well-formed parentheses
     */
    private void dfsV4(char[] currStr, int idx, int left, int right, int max, List<String> ans) {
        if (idx == currStr.length) {
            ans.add(new String(currStr));
            return;
        }
        if (left < max) {
            currStr[idx] = '(';
            dfsV4(currStr, idx + 1, left + 1, right, max, ans);
        }
        if (left > right) {
            currStr[idx] = ')';
            dfsV4(currStr, idx + 1, left, right + 1, max, ans);
        }
    }

    // Iterative Version
    // ============================================================================================ //

    /**
     * Approach 2: Backtracking (or DFS), subtraction without recursion
     * This method is the improved version of Approach 1, the basic idea is the same as Approach 1,
     * but this time we generate all the possible combinations with pruning.
     *
     * Complexity Analysis:
     * Time Complexity: O(4 ^ n / sqrt(n))
     * Space Complexity: O(n)
     *
     * Result of Submission:
     * Runtime: 2 ms, faster than 23.55% of Java online submissions for Generate Parentheses.
     * Memory Usage: 39.6 MB, less than 20.00% of Java online submissions for Generate Parentheses.
     *
     * @param n int, the number of pairs of parentheses
     * @return List<String>, all combinations of well-formed parentheses
     */
    public List<String> generateParenthesisV5(int n) {
        List<String> ans = new LinkedList<>();
        Stack<Node<String>> stack = new Stack<>();
        stack.push(new Node<>("", n, n));
        while (!stack.isEmpty()) {
            Node<String> curr = stack.pop();
            if (curr.left == 0 && curr.right == 0) {
                ans.add(curr.e);
            }
            if (curr.right > curr.left) {
                stack.push(new Node<>(curr.e + ")", curr.left, curr.right - 1));
            }
            if (curr.left > 0) {
                stack.push(new Node<>(curr.e + "(", curr.left - 1, curr.right));
            }
        }
        return ans;
    }

    /**
     * Approach 2: Backtracking (or DFS), addition without recursion
     * This method is the improved version of Approach 1, the basic idea is the same as Approach 1,
     * but this time we generate all the possible combinations with pruning.
     *
     * Complexity Analysis:
     * Time Complexity: O(4 ^ n / sqrt(n))
     * Space Complexity: O(n)
     *
     * Result of Submission:
     * Runtime: 2 ms, faster than 23.55% of Java online submissions for Generate Parentheses.
     * Memory Usage: 39.6 MB, less than 20.00% of Java online submissions for Generate Parentheses.
     *
     * @param n int, the number of pairs of parentheses
     * @return List<String>, all combinations of well-formed parentheses
     */
    public List<String> generateParenthesisV6(int n) {
        List<String> ans = new LinkedList<>();
        Stack<Node<String>> stack = new Stack<>();
        stack.push(new Node("", 0, 0));
        while (!stack.isEmpty()) {
            Node<String> curr = stack.pop();
            if (curr.left == n && curr.right == n) {
                ans.add(curr.e);
            }
            if (curr.left < n) {
                stack.push(new Node<>(curr.e + "(", curr.left + 1, curr.right));
            }
            if (curr.left > curr.right) {
                stack.push(new Node<>(curr.e + ")", curr.left, curr.right + 1));
            }
        }
        return ans;
    }

    class Node<E> {
        E e;
        int left;
        int right;

        Node(E e, int left, int right) {
            this.e = e;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        int n = 2;
        Solution2 solution = new Solution2();
        System.out.println(solution.generateParenthesisV5(n));
    }
}