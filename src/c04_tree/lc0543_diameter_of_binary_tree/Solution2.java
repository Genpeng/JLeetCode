package c04_tree.lc0543_diameter_of_binary_tree;

import entity.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * This is the solution of No. 543 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/diameter-of-binary-tree/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a binary tree, you need to compute the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 *
 * Example:
 * Given a binary tree
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 *
 * Note: The length of path between two nodes is represented by the number of edges between them.
 * ==========================================================================================================
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution2 {
    /**
     * Approach 2: Iterative
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * Runtime: 5 ms, faster than 14.18% of Java online submissions for Diameter of Binary Tree.
     * Memory Usage: 39.6 MB, less than 16.88% of Java online submissions for Diameter of Binary Tree.
     *
     * @param root TreeNode, the root of the binary tree
     * @return int, the diameter of this binary tree
     */
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int diameter = 0;
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node.left != null && !map.containsKey(node.left)) {
                stack.push(node.left);
            } else if (node.right != null && !map.containsKey(node.right)) {
                stack.push(node.right);
            } else {
                stack.pop();
                int l = map.getOrDefault(node.left, 0);
                int r = map.getOrDefault(node.right, 0);
                diameter = Math.max(diameter, l + r);
                map.put(node, Math.max(l, r) + 1);
            }
        }
        return diameter;
    }
}