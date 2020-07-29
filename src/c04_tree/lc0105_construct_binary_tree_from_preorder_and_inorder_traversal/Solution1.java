package c04_tree.lc0105_construct_binary_tree_from_preorder_and_inorder_traversal;

import entity.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * This is the solution of No. 105 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * - You may assume that duplicates do not exist in the tree.
 *
 * For example, given
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * ==========================================================================================================
 *
 * Difficulty: Medium
 * Tags: tree;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    private Map<Integer, Integer> inorderMap;
    private int[] preorder;

    /**
     * Approach 1: Recursion
     * 这道题的思路是：递归地将前序遍历的结果划分为根结点、左子树和右子树，直到到达叶子结点。
     * 中序遍历数组的作用是确定左右子树的结点数目，前序遍历数组的左右是确定左右子树的根结点。
     *
     * Complexity Analysis:
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * @param preorder int[], preorder traversal of the binary tree
     * @param inorder int[], inorder traversal of the binary tree
     * @return TreeNode, the root of the binary tree we constructed
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        this.preorder = preorder;
        this.inorderMap = new HashMap<>(n);
        for (int i = 0; i < n; ++i) {
            inorderMap.put(inorder[i], i);
        }
        return build(0, 0, n-1);
    }

    private TreeNode build(int preRoot, int inLeft, int inRight) {
        if (inLeft > inRight) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preRoot]);
        int inRoot = inorderMap.get(root.val);
        root.left = build(preRoot + 1, inLeft, inRoot - 1);
        root.right = build(inRoot - inLeft + preRoot + 1, inRoot + 1, inRight);
        return root;
    }
}