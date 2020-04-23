package c04_tree.lc1008_construct_binary_search_tree_from_preorder_traversal;

import entity.TreeNode;

/**
 * This is the solution of No. 1008 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Return the root node of a binary search tree that matches the given preorder traversal.
 *
 * (Recall that a binary search tree is a binary tree where for every node, any descendant of node.left
 * has a value < node.val, and any descendant of node.right has a value > node.val.  Also recall that
 * a preorder traversal displays the value of the node first, then traverses node.left,
 * then traverses node.right.)
 *
 * Example 1:
 * Input: [8,5,1,7,10,12]
 * Output: [8,5,10,1,7,null,12]
 *
 * Note:
 * - 1 <= preorder.length <= 100
 * - The values of preorder are distinct.
 * ==========================================================================================================
 *
 * Tags: tree;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution2 {
    private int idx;

    /**
     * Approach 2: Recursive
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * @param preorder int[], the preorder traversal of a BST
     * @return Tree, the root node of BST
     */
    public TreeNode bstFromPreorderV1(int[] preorder) {
        idx = 0;
        return bstFromPreorderV1(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode bstFromPreorderV1(int[] preorder, int lower, int upper) {
        if (idx == preorder.length || preorder[idx] < lower || preorder[idx] > upper) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[idx++]);
        root.left = bstFromPreorderV1(preorder, lower, root.val);
        root.right = bstFromPreorderV1(preorder, root.val, upper);
        return root;
    }

    /**
     * Approach 2: Recursive
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * @param preorder int[], the preorder traversal of a BST
     * @return Tree, the root node of BST
     */
    public TreeNode bstFromPreorderV2(int[] preorder) {
        idx = 0;
        return bstFromPreorderV2(preorder, Integer.MAX_VALUE);
    }

    private TreeNode bstFromPreorderV2(int[] preorder, int upper) {
        if (idx == preorder.length || preorder[idx] > upper) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[idx++]);
        root.left = bstFromPreorderV2(preorder, root.val);
        root.right = bstFromPreorderV2(preorder, upper);
        return root;
    }
}