package c02_string.lc0022_generate_parentheses;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
 * Tags: string;backtracking;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution3 {
    /**
     * Approach 3: BFS, subtraction
     * Time Complexity: O(4 ^ n / sqrt(n))
     * Space Complexity: O(4 ^ n / sqrt(n))
     *
     * Result of Submission:
     * Runtime: 2 ms, faster than 23.55% of Java online submissions for Generate Parentheses.
     * Memory Usage: 39.5 MB, less than 20.00% of Java online submissions for Generate Parentheses.
     *
     * @param n int, the number of pairs of parentheses
     * @return List<String>, all combinations of well-formed parentheses
     */
    public List<String> generateParenthesisV1(int n) {
        List<String> ans = new LinkedList<>();
        Queue<Node<String>> q = new LinkedList<>();
        q.offer(new Node<>("", n, n));
        while (!q.isEmpty()) {
            for (int level = 0; level < q.size(); ++level) {
                Node<String> curr = q.poll();
                if (curr.left == 0 && curr.right == 0) {
                    ans.add(curr.e);
                }
                if (curr.left > 0) {
                    q.offer(new Node<>(curr.e + "(", curr.left - 1, curr.right));
                }
                if (curr.right > curr.left) {
                    q.offer(new Node<>(curr.e + ")", curr.left, curr.right - 1));
                }
            }
        }
        return ans;
    }

    /**
     * Approach 3: BFS, addition
     * Time Complexity: O(4 ^ n / sqrt(n))
     * Space Complexity: O(4 ^ n / sqrt(n))
     *
     * Result of Submission:
     * Runtime: 2 ms, faster than 23.55% of Java online submissions for Generate Parentheses.
     * Memory Usage: 39.5 MB, less than 20.00% of Java online submissions for Generate Parentheses.
     *
     * @param n int, the number of pairs of parentheses
     * @return List<String>, all combinations of well-formed parentheses
     */
    public List<String> generateParenthesisV2(int n) {
        List<String> ans = new LinkedList<>();
        Queue<Node<String>> q = new LinkedList<>();
        q.offer(new Node<>("", 0, 0));
        while (!q.isEmpty()) {
            for (int level = 0; level < q.size(); ++level) {
                Node<String> curr = q.poll();
                if (curr.left == n && curr.right == n) {
                    ans.add(curr.e);
                }
                if (curr.left < n) {
                    q.offer(new Node<>(curr.e + "(", curr.left + 1, curr.right));
                }
                if (curr.left > curr.right) {
                    q.offer(new Node<>(curr.e + ")", curr.left, curr.right + 1));
                }
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
        Solution3 solution = new Solution3();
        System.out.println(solution.generateParenthesisV1(n));
    }
}