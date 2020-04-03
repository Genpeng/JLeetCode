package c04_tree.lc0226_invert_binary_tree;

import entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

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
public class Solution3 {
    /**
     * 解法三：迭代（BFS）
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param root TreeNode, the root of a binary tree
     * @return TreeNode, the root of the inverted tree
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            // swap left and right subtrees
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
            // add the left and right child into queue
            if (node.left != null) {
                q.offer(node.left);
            }
            if (node.right != null) {
                q.offer(node.right);
            }
        }
        return root;
    }

    /**
     * 解法三：迭代（BFS）
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Invert Binary Tree.
     * Memory Usage: 34.4 MB, less than 100.00% of Java online submissions for Invert Binary Tree.
     *
     * @param root TreeNode, the root of a binary tree
     * @return TreeNode, the root of the inverted tree
     */
    public TreeNode invertTreeV2(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int n = q.size();
            while (n-- > 0) {
                TreeNode node = q.poll();
                // swap left and right subtrees
                TreeNode tmp = node.left;
                node.left = node.right;
                node.right = tmp;
                // add nodes of the next level into queue
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
        }
        return root;
    }
}