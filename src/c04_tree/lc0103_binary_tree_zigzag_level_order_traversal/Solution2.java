package c04_tree.lc0103_binary_tree_zigzag_level_order_traversal;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
public class Solution2 {
    /**
     * 题意：
     * 二叉树的锯齿形层序遍历
     *
     * 思路：
     * 在二叉树层序遍历的基础上，用一个标志去标记元素的保存方向
     *
     * 解法二：递归（DFS）
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
     * Memory Usage: 36.5 MB, less than 99.04% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
     *
     * @param root TreeNode, the root of the binary tree
     * @return List<List<Integer>>, the zigzag level order traversal of its nodes' values
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        zigzagLevelOrder(root, 0, ans);
        return ans;
    }

    private void zigzagLevelOrder(TreeNode root, int depth, List<List<Integer>> ans) {
        if (root == null) {
            return;
        }
        if (depth >= ans.size()) {
            ans.add(new LinkedList<>());
        }
        LinkedList<Integer> vals = (LinkedList<Integer>) ans.get(depth);
        if ((depth & 1) == 0) {
            vals.add(root.val);
        } else {
            vals.addFirst(root.val);
        }
        zigzagLevelOrder(root.left, depth + 1, ans);
        zigzagLevelOrder(root.right, depth + 1, ans);
    }
}