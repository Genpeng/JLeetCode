package tree.lc0102_binary_tree_level_order_traversal;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * This is the solution of No. 102 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * ==========================================================================================================
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2019/06/23
 */
public class Solution2 {
    /**
     * 解法二：递归
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param root TreeNode, the root of a binary tree
     * @return List<List<Integer>>, the level order traversal of its nodes' values
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelOrderHelper(root, 0, res);
        return res;
    }

    private void levelOrderHelper(TreeNode root, int depth, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        if (depth >= res.size()) {
            res.add(new LinkedList<>());
        }
        res.get(depth).add(root.val);
        levelOrderHelper(root.left, depth + 1, res);
        levelOrderHelper(root.right, depth + 1, res);
    }
}