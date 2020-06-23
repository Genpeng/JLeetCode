package c04_tree.lc0124_binary_tree_maximum_path_sum;

import entity.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * This is the solution of No. 124 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a non-empty binary tree, find the maximum path sum.
 *
 * For this problem, a path is defined as any sequence of nodes from some starting node to
 * any node in the tree along the parent-child connections. The path must contain at least
 * one node and does not need to go through the root.
 *
 * Example 1:
 * Input: [1,2,3]
 *        1
 *       / \
 *      2   3
 * Output: 6
 *
 * Example 2:
 * Input: [-10,9,20,null,null,15,7]
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Output: 42
 * ==========================================================================================================
 *
 * Tags: tree;
 *
 * | Date          | #   | Desc   |
 * | ------------- | --- | ------ |
 * | June 21, 2020 | 1   | ×      |
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution2 {
    /**
     * Approach 2: Iteration
     * The idea is to use post-order traversal to simulate the recursion procedure (top down and then bottom up),
     * calculate each node's "max gain", and at the same time, update the maximum path sum.
     *
     * Complexity Analysis:
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * @param root TreeNode, a binary tree
     * @return int, the maximum path sum
     */
    public int maxPathSum(TreeNode root) {
        int maxSum = Integer.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        stack.push(root);
        map.put(null, 0);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node.left != null && !map.containsKey(node.left)) {
                stack.push(node.left);
            } else if (node.right != null && !map.containsKey(node.right)) {
                stack.push(node.right);
            } else {
                stack.pop();
                int left = Math.max(map.get(node.left), 0);
                int right = Math.max(map.get(node.right), 0);
                maxSum = Math.max(maxSum, left + right + node.val);
                map.put(node, Math.max(left, right) + node.val);
            }
        }
        return maxSum;
    }
}