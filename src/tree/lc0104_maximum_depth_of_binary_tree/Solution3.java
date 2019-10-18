package tree.lc0104_maximum_depth_of_binary_tree;

import entity.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This is the solution of No. 104 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node
 * down to the farthest leaf node.
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
 * return its depth = 3.
 * ==========================================================================================================
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2019/05/20
 */
public class Solution3 {
    /**
     * 解法2：迭代（BFS版本）
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param root TreeNode, the root of the binary tree
     * @return int, the maximum depth of the binary tree
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 0;
        while (!q.isEmpty()) {
            ++depth;
            // put all the nodes of the next level into queue
            int n = q.size();
            while (n-- > 0) {
                TreeNode node = q.poll();
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
        }
        return depth;
    }
}