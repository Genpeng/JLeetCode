package c04_tree.lc0111_minimum_depth_of_binary_tree;

import entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

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
public class Solution2 {
    /**
     * 解法二 - 迭代（BFS版本）
     * 思路描述：
     * 从根结点出发层序遍历二叉树，当树中某一层的某个结点不存在左右子树时，那么该结点即为最小深度的叶子结点。
     * 从而该结点的深度即为所求的最小深度。
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Depth of Binary Tree.
     * Memory Usage: 38.4 MB, less than 98.44% of Java online submissions for Minimum Depth of Binary Tree.
     *
     * @param root, TreeNode, the root of the binary tree
     * @return int, the minimum depth of the binary tree
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 0;
        while (!q.isEmpty()) {
            ++depth;
            int n = q.size();
            while (n-- > 0) {
                TreeNode node = q.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
        }
        return -1;
    }
}