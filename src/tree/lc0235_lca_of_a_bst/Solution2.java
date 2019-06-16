package tree.lc0235_lca_of_a_bst;

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
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2019/05/28
 */
public class Solution2 {
    /**
     * 解法二：迭代
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param root TreeNode, the root of a BST
     * @param p TreeNode, one node in the BST
     * @param q TreeNode, other node in the BST
     * @return TreeNode, the lowest common ancestor (LCA) of two given nodes
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        while ((root.val - p.val) * (root.val - q.val) > 0) {
            root = root.val > p.val ? root.left : root.right;
        }
        return root;
    }
}