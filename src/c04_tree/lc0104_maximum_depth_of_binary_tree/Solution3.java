package c04_tree.lc0104_maximum_depth_of_binary_tree;

import entity.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

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
 * Tags: tree;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 * @date    2019/05/20
 */
public class Solution3 {
    /**
     * 题意：
     * - 求出二叉树的最大深度
     *
     * 解法1：递归
     * 问题可以转为 1 + max(maxDepth(root.left), maxDepth(root.right))
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * 解法2：DFS（递归）
     * 采用前序遍历（DFS）搜索二叉树的每个节点，采用一个变量（ans）记录当前的最大深度，
     * 递归初始深度为 1，每次递归深度大于最大深度时，更新最大深度；递归结束后，返回最大深度
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * 解法3：DFS（迭代）
     * 采用前序遍历（DFS）搜索二叉树的每个节点，采用一个变量（ans）记录当前的最大深度，
     * 迭代初始深度为 1，每次迭代深度大于最大深度时，更新最大深度；递归结束后，返回最大深度
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * 解法4：BFS
     * 采用层序遍历逐层遍历二叉树，每往下遍历一层，最大深度 +1
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param root TreeNode, the root of binary tree
     * @return int, the maximum depth of binary tree
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxDepth = 1;
        Deque<TreeNode> nodeStack = new ArrayDeque<>();
        Deque<Integer> depthStack = new ArrayDeque<>();
        nodeStack.push(root);
        depthStack.push(1);
        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            int depth = depthStack.pop();
            if (depth > maxDepth) {
                maxDepth = depth;
            }
            if (node.right != null) {
                nodeStack.push(node.right);
                depthStack.push(depth+1);
            }
            if (node.left != null) {
                nodeStack.push(node.left);
                depthStack.push(depth+1);
            }
        }
        return maxDepth;
    }
}