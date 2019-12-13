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
public class Solution1 {
    /**
     * 解法一：递归
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Depth of Binary Tree.
     * Memory Usage: 39 MB, less than 98.44% of Java online submissions for Minimum Depth of Binary Tree.
     *
     * @param root, TreeNode, the root of the binary tree
     * @return int, the minimum depth of the binary tree
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = minDepth(root.left), r = minDepth(root.right);
        return 1 + (Math.min(l, r) > 0 ? Math.min(l, r) : Math.max(l, r));
    }

    /**
     * 解法一：递归（推荐）
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Depth of Binary Tree.
     * Memory Usage: 38.4 MB, less than 98.44% of Java online submissions for Minimum Depth of Binary Tree.
     *
     * @param root, TreeNode, the root of the binary tree
     * @return int, the minimum depth of the binary tree
     */
    public int minDepthV2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = minDepthV2(root.left), r = minDepthV2(root.right);
        return (l == 0 || r == 0) ? l + r + 1 : Math.min(l, r) + 1;
    }
}