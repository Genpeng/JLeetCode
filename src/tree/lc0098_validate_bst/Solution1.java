package tree.lc0098_validate_bst;

import entity.TreeNode;

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
public class Solution1 {
    /**
     * 解法一：递归
     * 时间复杂度：O(n)，其中n表示节点数目
     * 空间复杂度：O(n)
     *
     * @param root TreeNode, the root of BST
     * @return boolean, true if the BST is valid
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, Integer lower, Integer upper) {
        if (root == null) {
            return true;
        }

        int val = root.val;
        if (lower != null && val <= lower) {
            return false;
        }
        if (upper != null && val >= upper) {
            return false;
        }
        return isValidBST(root.left, lower, val) && isValidBST(root.right, val, upper);
    }

    /**
     * 解法一：递归（版本2，推荐）
     * 在二叉搜索树中，除了根节点的取值范围是负无穷到正无穷之外，其余的节点总能根据其父节点的取值范围得到一个区间，
     * 节点的取值只有在这个区间中才是正确的。
     *
     * 时间复杂度：O(n)，其中n表示节点数目
     * 空间复杂度：O(n)
     *
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Validate Binary Search Tree.
     * Memory Usage: 38.4 MB, less than 86.05% of Java online submissions for Validate Binary Search Tree.
     *
     * @param root TreeNode, the root of BST
     * @return boolean, true if the BST is valid
     */
    public boolean isValidBSTV2(TreeNode root) {
        return isValidBSTV2(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    private boolean isValidBSTV2(TreeNode root, double lower, double upper) {
        if (root == null) {
            return true;
        }
        int val = root.val;
        if (val <= lower || val >= upper) {
            return false;
        }
        return isValidBSTV2(root.left, lower, val) && isValidBSTV2(root.right, val, upper);
    }
}