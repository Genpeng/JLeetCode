package c04_tree.lc0098_validate_bst;

import entity.TreeNode;

import java.util.Stack;

/**
 * This is the solution of No. 98 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/validate-binary-search-tree/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 * - The left subtree of a node contains only nodes with keys less than the node's key.
 * - The right subtree of a node contains only nodes with keys greater than the node's key.
 * - Both the left and right subtrees must also be binary search trees.
 *
 * Example 1:
 *
 *     2
 *    / \
 *   1   3
 *
 * Input: [2,1,3]
 * Output: true
 *
 * Example 2:
 *
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 *
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 * ==========================================================================================================
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2019/05/14
 */
public class Solution3 {
    /**
     * 解法三：中序遍历（利用BST的性质）
     * 时间复杂度：O(n)，其中n表示节点数目
     * 空间复杂度：O(n)
     *
     * @param root TreeNode, the root of BST
     * @return boolean, true if the BST is valid
     */
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        double val = - Double.MAX_VALUE;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode node = stack.pop();
                if (node.val <= val) {
                    return false;
                }
                val = node.val;
                curr = node.right;
            }
        }
        return true;
    }

    /**
     * 解法三：中序遍历（版本2）
     * 时间复杂度：O(n)，其中n表示节点数目
     * 空间复杂度：O(n)
     *
     * Runtime: 2 ms, faster than 24.27% of Java online submissions for Validate Binary Search Tree.
     * Memory Usage: 38.5 MB, less than 84.65% of Java online submissions for Validate Binary Search Tree.
     *
     * @param root TreeNode, the root of BST
     * @return boolean, true if the BST is valid
     */
    public boolean isValidBSTV2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        double val = Double.NEGATIVE_INFINITY;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            TreeNode node = stack.pop();
            if (node.val <= val) {
                return false;
            }
            val = node.val;
            curr = node.right;
        }
        return true;
    }
}