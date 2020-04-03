package c04_tree.lc0226_invert_binary_tree;

import entity.TreeNode;

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
public class Solution1 {
    /**
     * 解法一：递归
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param root TreeNode, the root of a binary tree
     * @return TreeNode, the root of the inverted tree
     */
    public TreeNode invertTree(TreeNode root) {
        // Recursive termination condition
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
    }

    /**
     * 解法一：递归
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param root TreeNode, the root of a binary tree
     * @return TreeNode, the root of the inverted tree
     */
    public TreeNode invertTreeV2(TreeNode root) {
        // Recursive termination condition
        if (root == null) {
            return null;
        }
        TreeNode left = invertTreeV2(root.left);
        TreeNode right = invertTreeV2(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}