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
     * @param root TreeNode, the root of the binary tree
     * @return int, the maximum depth of the binary tree
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> depths = new Stack<>();
        stack.push(root);
        depths.push(1);
        TreeNode node;
        int depth, maxDepth = -1;
        while (!stack.isEmpty()) {
            node = stack.pop();
            depth = depths.pop();
            maxDepth = Math.max(maxDepth, depth);
            if (node.right != null) {
                stack.push(node.right);
                depths.push(depth + 1);
            }
            if (node.left != null) {
                stack.push(node.left);
                depths.push(depth + 1);
            }
        }
        return maxDepth;
    }
}