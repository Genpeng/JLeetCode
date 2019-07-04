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
public class Solution2 {
    /**
     * 解法二：递归（DFS）
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param root TreeNode, the root of the binary tree
     * @return List<List<Integer>>, the zigzag level order traversal of its nodes' values
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        zigzagLevelOrder(root, 0, res);
        return res;
    }

    private void zigzagLevelOrder(TreeNode root, int depth, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        if (depth >= res.size()) {
            res.add(new LinkedList<>());
        }
        List<Integer> levelVals = res.get(depth);
        if (depth % 2 == 0) {
            levelVals.add(root.val);
        } else {
            levelVals.add(0, root.val);
        }
        zigzagLevelOrder(root.left, depth + 1, res);
        zigzagLevelOrder(root.right, depth + 1, res);
    }
}