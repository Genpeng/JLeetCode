package c04_tree.lc0144_binary_tree_preorder_traversal;

import entity.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * This is the solution of No. 144 problem in the LeetCode,
 * the website of the problem is as follows:
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a binary tree, return the preorder traversal of its nodes' values.
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
 * Output: [1,2,3]
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
     * @return List<Integer>, the preorder traversal of binary tree
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> vals = new LinkedList<>();
        preorderTraversal(root, vals);
        return vals;
    }

    private void preorderTraversal(TreeNode root, List<Integer> vals) {
        if (root == null) {
            return;
        }
        vals.add(root.val);
        preorderTraversal(root.left, vals);
        preorderTraversal(root.right, vals);
    }
}