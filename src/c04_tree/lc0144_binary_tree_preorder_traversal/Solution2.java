package c04_tree.lc0144_binary_tree_preorder_traversal;

import entity.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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
public class Solution2 {
    /**
     * Approach 2: Iteration (v1)
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param root TreeNode, the root of binary tree
     * @return List<Integer>, the preorder traversal of binary tree
     */
    public List<Integer> preorderTraversalV1(TreeNode root) {
        List<Integer> vals = new LinkedList<>();
        if (root == null) {
            return vals;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            vals.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return vals;
    }

    /**
     * Approach 2: Iteration (v2)
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param root TreeNode, the root of binary tree
     * @return List<Integer>, the preorder traversal of binary tree
     */
    public List<Integer> preorderTraversalV2(TreeNode root) {
        List<Integer> vals = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                vals.add(curr.val);
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop().right;
            }
        }
        return vals;
    }

    /**
     * Approach 2: Iteration (v3, recommended, ☆☆☆)
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * @param root TreeNode, the root of binary tree
     * @return List<Integer>, the preorder traversal of binary tree
     */
    public List<Integer> preorderTraversalV3(TreeNode root) {
        List<Integer> vals = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                vals.add(curr.val);
                curr = curr.left;
            }
            curr = stack.pop().right;
        }
        return vals;
    }
}