package c04_tree.lc0199_binary_tree_right_side_view;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the solution of No. 199 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/binary-tree-right-side-view/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of
 * the nodes you can see ordered from top to bottom.
 *
 * Example 1:
 * Input: root = [1,2,3,null,5,null,4]
 * Output: [1,3,4]
 *
 * Example 2:
 * Input: root = [1,null,3]
 * Output: [1,3]
 * Example 3:
 *
 * Input: root = []
 * Output: []
 *
 * Constraints:
 * - The number of nodes in the tree is in the range [0, 100].
 * - -100 <= Node.val <= 100
 * ==========================================================================================================
 *
 * Difficulty: Medium
 * Tags: tree;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution2 {
    /**
     * 题意：
     * - 返回二叉树的"右视图"
     *
     * 思路：
     * - 找出每一层（深度）中最右侧的节点
     *
     * 解法1：BFS
     * 采用层序遍历（BFS）逐层遍历二叉树，保存每一层最右边的节点
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * 解法2：DFS（递归）
     * 采用「root -> right -> left」的顺序（DFS）进行遍历，则每一层最先遍历到的节点即为最右边的节点
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * 解法3：DFS（迭代）
     * 采用「root -> right -> left」的顺序（DFS）进行遍历，则每一层最先遍历到的节点即为最右边的节点
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param root TreeNode, the root of binary tree
     * @return List<Integer>, the values of nodes you can see on the right side view
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> vals = new ArrayList<>();
        dfs(root, 0, vals);
        return vals;
    }

    private void dfs(TreeNode root, int depth, List<Integer> vals) {
        if (root == null) {
            return;
        }
        // 如果当前的深度第一次出现，保存当前节点的值
        if (depth == vals.size()) {
            vals.add(root.val);
        }
        dfs(root.right, depth+1, vals);
        dfs(root.left, depth+1, vals);
    }
}