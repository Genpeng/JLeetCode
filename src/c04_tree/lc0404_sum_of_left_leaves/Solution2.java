package c04_tree.lc0404_sum_of_left_leaves;

import entity.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * This is the solution of No. 404 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/sum-of-left-leaves/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Find the sum of all left leaves in a given binary tree.
 *
 * Example:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 * ==========================================================================================================
 *
 * Difficulty: Easy
 * Tags: tree;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution2 {
    /**
     * Approach 2: Iterative
     * 思路就是遍历树中的每个结点，判断该结点是否为左孩子结点，如果是的话，将它的值加入到结果中。
     * 判断一个结点是否为左孩子结点需要借用一个标志（是否为左子树），如果该结点是左子树，同时
     * 它是叶子结点（node.left == null && node.right == null），那么该结点就是一个左孩子结点。
     *
     * Complexity Analysis:
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * @param root TreeNode, the root of binary tree
     * @return int, the sum of all left leaves
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> nodes = new ArrayDeque<>();
        Deque<Boolean> properties = new ArrayDeque<>();
        nodes.push(root);
        properties.push(false);
        int s = 0;
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pop();
            boolean isLeft = properties.pop();
            if (isLeft && node.left == null && node.right == null) {
                s += node.val;
            }
            if (node.right != null) {
                nodes.push(node.right);
                properties.push(false);
            }
            if (node.left != null) {
                nodes.push(node.left);
                properties.push(true);
            }
        }
        return s;
    }
}