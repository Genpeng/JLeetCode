package c04_tree.lc0235_lca_of_a_bst;

import entity.TreeNode;

/**
 * This is the solution of No. 235 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined
 * between two nodes p and q as the lowest node in T that has both p and q as descendants
 * (where we allow a node to be a descendant of itself).”
 *
 * Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 *         _______6______
 *        /              \
 *     ___2__          ___8__
 *    /      \        /      \
 *    0      _4       7       9
 *          /  \
 *          3   5
 *
 * Example 1:
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 *
 * Example 2:
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * Output: 2
 * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself
 * according to the LCA definition.
 *
 * Note:
 * - All of the nodes' values will be unique.
 * - p and q are different and both values will exist in the BST.
 * ==========================================================================================================
 *
 * Tags: tree;
 *
 * | Date          | #   | Desc   |
 * | ------------- | --- | ------ |
 * | May 28, 2019  | 1   | ×      |
 * | June 18, 2020 | 3   | ×      |
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution2 {
    /**
     * Approach 2: Iteration (v1)
     * This problem is just want us to find the split point from where p and q won't be
     * part of the same subtree or when one is the parent of other, that is
     * (A.val - p.val) * (A.val - q.val) <= 0
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     *
     * Reference:
     * [1] https://leetcode.com/articles/lowest-common-ancestor-of-a-binary-search-tree/
     *
     * @param root TreeNode, the root of a BST
     * @param p TreeNode, one node in the BST
     * @param q TreeNode, other node in the BST
     * @return TreeNode, the lowest common ancestor (LCA) of two given nodes
     */
    public TreeNode lowestCommonAncestorV1(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;
        while ((curr.val - p.val) * (curr.val - q.val) > 0) {
            curr = curr.val > p.val ? curr.left : curr.right;
        }
        return curr;
    }

    /**
     * Approach 2: Iteration (v2)
     * This problem is just want us to find the split point from where p and q won't be
     * part of the same subtree or when one is the parent of other, that is
     * (A.val - p.val) * (A.val - q.val) <= 0
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     *
     * Reference:
     * [1] https://leetcode.com/articles/lowest-common-ancestor-of-a-binary-search-tree/
     *
     * @param root TreeNode, the root of a BST
     * @param p TreeNode, one node in the BST
     * @param q TreeNode, other node in the BST
     * @return TreeNode, the lowest common ancestor (LCA) of two given nodes
     */
    public TreeNode lowestCommonAncestorV2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;
        while (curr != null) {
            if (p.val < curr.val && q.val < curr.val) {
                curr = curr.left;
            } else if (p.val > curr.val && q.val > curr.val) {
                curr = curr.right;
            } else {
                return curr;
            }
        }
        return null;
    }
}