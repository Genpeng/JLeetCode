package c04_tree.lc0543_diameter_of_binary_tree;

import entity.TreeNode;

/**
 * This is the solution of No. 543 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/diameter-of-binary-tree/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a binary tree, you need to compute the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 *
 * Example:
 * Given a binary tree
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 *
 * Note: The length of path between two nodes is represented by the number of edges between them.
 * ==========================================================================================================
 *
 * Tags: tree; dfs;
 *
 * | Date          | #   | Desc   |
 * | ------------- | --- | ------ |
 * | June 22, 2020 | 3   | √      |
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    private int diameter;

    /**
     * Approach 1: Recursion
     * The idea is to find out the max depth of every nodes, and during this procedure,
     * we can update the length of longest path (diameter).
     *
     * Complexity Analysis:
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * Result of Submission:
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Diameter of Binary Tree.
     * Memory Usage: 39.4 MB, less than 18.18% of Java online submissions for Diameter of Binary Tree.
     *
     * @param root TreeNode, the root of the binary tree
     * @return int, the diameter of this binary tree
     */
    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        maxDepth(root);
        return diameter;
    }

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        diameter = Math.max(diameter, left + right);
        return Math.max(left, right) + 1;
    }
}