package tree.lc0103_binary_tree_zigzag_level_order_traversal;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
     * 解法一：迭代
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param root TreeNode, the root of the binary tree
     * @return List<List<Integer>>, the zigzag level order traversal of its nodes' values
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean zigzag = false; // the traversal direction is from left to right if `zigzag` equals to `false`
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> levelVals = new LinkedList<>();
            for (int i = 0; i < n; ++i) {
                TreeNode node = queue.poll();
                if (zigzag) {
                    levelVals.add(0, node.val);
                } else {
                    levelVals.add(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(levelVals);
            zigzag = !zigzag;
        }
        return res;
    }
}