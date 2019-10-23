package tree.lc0226_invert_binary_tree;

import entity.TreeNode;

import java.util.Stack;

/**
 * This is the solution of No. 226 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/invert-binary-tree/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Invert a binary tree.
 *
 * Example:
 *
 * Input:
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 *
 * Output:
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * Trivia:
 * This problem was inspired by this original tweet by Max Howell:
 *
 * Google: 90% of our engineers use the software you wrote (Homebrew), but you can’t invert a binary tree
 * on a whiteboard so f*** off.
 * ==========================================================================================================
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2019/06/20
 */
public class Solution2 {
    /**
     * 解法二：迭代（DFS）
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param root TreeNode, the root of a binary tree
     * @return TreeNode, the root of the inverted tree
     */
    public TreeNode invertTree(TreeNode root) {
        // Boundary condition
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            // swap left and right subtrees
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
            // add the left and right child into stack
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return root;
    }
}