package tree.lc0104_maximum_depth_of_binary_tree;

import entity.TreeNode;

import java.util.Stack;

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
public class Solution2 {
    /**
     * 解法2：迭代（DFS版本）
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * Runtime: 3 ms, faster than 11.55% of Java online submissions for Maximum Depth of Binary Tree.
     * Memory Usage: 39.1 MB, less than 94.62% of Java online submissions for Maximum Depth of Binary Tree.
     *
     * @param root TreeNode, the root of the binary tree
     * @return int, the maximum depth of the binary tree
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> depthStack = new Stack<>();
        nodeStack.push(root);
        depthStack.push(1);
        TreeNode node;
        int depth, maxDepth = 0;
        while (!nodeStack.isEmpty()) {
            node = nodeStack.pop();
            depth = depthStack.pop();
            maxDepth = Math.max(maxDepth, depth);
            if (node.right != null) {
                nodeStack.push(node.right);
                depthStack.push(depth + 1);
            }
            if (node.left != null) {
                nodeStack.push(node.left);
                depthStack.push(depth + 1);
            }
        }
        return maxDepth;
    }
}