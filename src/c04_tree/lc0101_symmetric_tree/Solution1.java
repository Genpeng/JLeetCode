package c04_tree.lc0101_symmetric_tree;

import entity.TreeNode;

/**
 * This is the solution of No. 101 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/symmetric-tree/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 *
 * But the following [1,2,2,null,3,null,3] is not:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * Follow up: Solve it both recursively and iteratively.
 * ==========================================================================================================
 *
 * Difficulty: Easy
 * Tags: tree;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * Approach 1: Recursive
     *
     * Complexity Analysis:
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param root TreeNode, the root of the binary tree
     * @return boolean, true if and only if the binary is symmetric
     */
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val
                && isMirror(p.left, q.right)
                && isMirror(p.right, q.left);
    }
}