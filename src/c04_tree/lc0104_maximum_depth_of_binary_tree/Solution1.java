package c04_tree.lc0104_maximum_depth_of_binary_tree;

import entity.TreeNode;

/**
 * This is the solution of No. 104 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node
 * down to the farthest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its depth = 3.
 * ==========================================================================================================
 *
 * Tags: tree;
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2019/05/20
 */
public class Solution1 {
    /**
     * Approach 1: Recursion
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * Result of Submission:
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Depth of Binary Tree.
     * Memory Usage: 39.5 MB, less than 89.25% of Java online submissions for Maximum Depth of Binary Tree.
     *
     * @param root TreeNode, the root of the binary tree
     * @return int, the maximum depth of the binary tree
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}