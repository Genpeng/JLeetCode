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
 * Difficulty: Easy
 * Tags: tree;
 *
 * @author  Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * Approach 1: Recursion (v1)
     * If node A is the LCA of two nodes (p and q), then it must be one of two following cases:
     * - node A is one of two nodes (A is either p or q), that is
     *   (A.val - p.val) * (A.val - q.val) == 0
     * - p and q are located at the left and right subtrees of node A respectively, that is
     *   (A.val - p.val) * (A.val - q.val) < 0
     * Time Complexity: O(N)
     * Space Complexity: O(N)
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
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestorV1(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestorV1(root.right, p, q);
        } else {
            return root;
        }
    }

    /**
     * Approach 1: Recursion (v1)
     * If node A is the LCA of two nodes (p and q), then it must be one of two following cases:
     * - node A is one of two nodes (A is either p or q), that is
     *   (A.val - p.val) * (A.val - q.val) == 0
     * - p and q are located at the left and right subtrees of node A respectively, that is
     *   (A.val - p.val) * (A.val - q.val) < 0
     * Time Complexity: O(N)
     * Space Complexity: O(N)
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
        if ((root.val - p.val) * (root.val - q.val) > 0) { // p and q are in the same subtree
            return lowestCommonAncestorV2(root.val > p.val ? root.left : root.right, p, q);
        } else {
            return root;
        }
    }
}