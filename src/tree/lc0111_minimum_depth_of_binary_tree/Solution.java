package tree.lc0111_minimum_depth_of_binary_tree;

import entity.TreeNode;

/**
 * This is the solution of No. 111 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
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
 *
 * return its minimum depth = 2.
 * ==========================================================================================================
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2019/06/19
 */
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = minDepth(root.left), r = minDepth(root.right);
        return 1 + (Math.min(l, r) > 0 ? Math.min(l, r) : Math.max(l, r));
    }
}