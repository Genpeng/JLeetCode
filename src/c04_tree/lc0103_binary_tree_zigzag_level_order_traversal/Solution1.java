package c04_tree.lc0103_binary_tree_zigzag_level_order_traversal;

import entity.TreeNode;

import java.util.*;

/**
 * This is the solution of No. 103 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right,
 * then right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 * ==========================================================================================================
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2019/07/04
 */
public class Solution1 {
    /**
     * 题意：
     * 二叉树的锯齿形层序遍历
     *
     * 思路：
     * 在二叉树层序遍历的基础上，用一个标志去标记元素的保存方向
     *
     * 解法一：迭代
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param root TreeNode, the root of the binary tree
     * @return List<List<Integer>>, the zigzag level order traversal of its nodes' values
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        boolean leftToRight = true;
        while (!q.isEmpty()) {
            LinkedList<Integer> level = new LinkedList<>();
            int n = q.size();
            for (int i = 0; i < n; ++i) {
                TreeNode node = q.poll();
                // 保存当前一层的结点的值
                if (leftToRight) {
                    level.add(node.val);
                } else {
                    level.addFirst(node.val);
                }
                // 将下一层的结点放入队列中
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            ans.add(level);
            leftToRight = !leftToRight;
        }
        return ans;
    }
}