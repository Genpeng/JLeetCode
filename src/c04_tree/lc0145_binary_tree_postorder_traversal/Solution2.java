package c04_tree.lc0145_binary_tree_postorder_traversal;

import entity.TreeNode;

import java.util.*;

/**
 * This is the solution of No. 145 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a binary tree, return the postorder traversal of its nodes' values.
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
 * Output: [3,2,1]
 *
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 * ==========================================================================================================
 *
 * Tags: tree;
 *
 * | Date          | #   | Desc                    |
 * | ------------- | --- | ----------------------- |
 * | May 5, 2019   | 1   | ×                       |
 * | June 17, 2020 | n   | √                       |
 * | June 23, 2020 | n   | add another method (v4) |
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution2 {
    /**
     * Approach 2: Iteration (v1)
     * The idea is to traverse the tree in reverse postorder, that is: root -> right -> left,
     * which is similar to preorder, and finally reverse the result we get.
     *
     * Complexity Analysis:
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * @param root TreeNode, the root of binary tree
     * @return List<Integer>, the postorder traversal of binary tree
     */
    public List<Integer> postorderTraversalV1(TreeNode root) {
        LinkedList<Integer> vals = new LinkedList<>();
        if (root == null) {
            return vals;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            vals.addFirst(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return vals;
    }

    /**
     * Approach 2: Iteration (v2)
     * The idea is to traverse the tree in reverse postorder, that is: root -> right -> left,
     * which is similar to preorder, and finally reverse the result we get.
     *
     * Complexity Analysis:
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * @param root TreeNode, the root of binary tree
     * @return List<Integer>, the postorder traversal of binary tree
     */
    public List<Integer> postorderTraversalV2(TreeNode root) {
        LinkedList<Integer> vals = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                vals.addFirst(curr.val);
                stack.push(curr);
                curr = curr.right;
            } else {
                curr = stack.pop().left;
            }
        }
        return vals;
    }

    /**
     * Approach 2: Iteration (v3, recommended, ☆☆☆)
     * The idea is to traverse the tree in reverse postorder, that is: root -> right -> left,
     * which is similar to preorder, and finally reverse the result we get.
     *
     * Complexity Analysis:
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * @param root TreeNode, the root of binary tree
     * @return List<Integer>, the postorder traversal of binary tree
     */
    public List<Integer> postorderTraversalV3(TreeNode root) {
        LinkedList<Integer> vals = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                vals.addFirst(curr.val);
                stack.push(curr);
                curr = curr.right;
            }
            curr = stack.pop().left;
        }
        return vals;
    }

    /**
     * Approach 2: Iteration (v4)
     * The idea is to use a stack and a hash table to simulate the post-order traversal.
     * This method can usually use to record the paths from leaf nodes to root node.
     *
     * Complexity Analysis:
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * @param root TreeNode, the root of binary tree
     * @return List<Integer>, the postorder traversal of binary tree
     */
    public List<Integer> postorderTraversalV4(TreeNode root) {
        List<Integer> vals = new LinkedList<>();
        if (root == null) {
            return vals;
        }
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> set = new HashSet<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node.left != null && !set.contains(node.left)) {
                stack.push(node.left);
            } else if (node.right != null && !set.contains(node.right)) {
                stack.push(node.right);
            } else {
                stack.pop();
                vals.add(node.val);
                set.add(node);
            }
        }
        return vals;
    }
}