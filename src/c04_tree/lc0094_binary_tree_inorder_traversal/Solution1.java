package c04_tree.lc0094_binary_tree_inorder_traversal;

import entity.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * This is the solution of No. 94 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,3,2]
 *
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 * ==========================================================================================================
 *
 * Tags: tree;
 *
 * | Date          | #   | Desc   |
 * | ------------- | --- | ------ |
 * | May 5, 2019   | 1   | ×      |
 * | June 17, 2020 | n   | √      |
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * Approach 1: Recursion
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param root TreeNode, the root of binary tree
     * @return List<Integer>, the inorder traversal of binary tree
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> vals = new LinkedList<>();
        inorderTraversal(root, vals);
        return vals;
    }

    private void inorderTraversal(TreeNode root, List<Integer> vals) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, vals);
        vals.add(root.val);
        inorderTraversal(root.right, vals);
    }
}