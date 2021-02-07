package c04_tree.lc0404_sum_of_left_leaves;

import entity.TreeNode;

/**
 * This is the solution of No. 404 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/sum-of-left-leaves/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Find the sum of all left leaves in a given binary tree.
 *
 * Example:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 * ==========================================================================================================
 *
 * Difficulty: Easy
 * Tags: tree;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    private int leftLeavesSum;

    /**
     * Approach 1: Recursive
     *
     * Complexity Analysis:
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * @param root TreeNode, the root of binary tree
     * @return int, the sum of all left leaves
     */
    public int sumOfLeftLeaves(TreeNode root) {
        leftLeavesSum = 0;
        sumOfLeftLeaves(root, false);
        return leftLeavesSum;
    }

    private void sumOfLeftLeaves(TreeNode root, boolean isLeft) {
        if (root == null) {
            return;
        }
        if (isLeft && root.left == null && root.right == null) {
            leftLeavesSum += root.val;
        }
        sumOfLeftLeaves(root.left, true);
        sumOfLeftLeaves(root.right, false);
    }
}