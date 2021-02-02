package c04_tree.lc0124_binary_tree_maximum_path_sum;

import entity.TreeNode;

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
 * Difficulty: Hard
 * Tags: tree;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    private int maxSum;

    /**
     * Approach 1: Recursion
     * The idea is to find out every node's "max gain" from leaf nodes up to root node,
     * where max gain is defined as the maximum score a node obtained starting from itself
     * down towards the leaf nodes.
     *
     * Complexity Analysis:
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * @param root TreeNode, a binary tree
     * @return int, the maximum path sum
     */
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(maxGain(root.left), 0);
        int right = Math.max(maxGain(root.right), 0);
        maxSum = Math.max(maxSum, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}