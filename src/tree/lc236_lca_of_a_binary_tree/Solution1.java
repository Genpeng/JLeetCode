package tree.lc236_lca_of_a_binary_tree;

import entity.TreeNode;

/**
 * This is the solution of No. 236 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q
 * as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 * Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 *         _______3______
 *        /              \
 *     ___5__          ___1__
 *    /      \        /      \
 *    6      _2       0       8
 *          /  \
 *          7   4
 *
 * Example 1:
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of of nodes 5 and 1 is 3.
 *
 * Example 2:
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 *
 * Note:
 * - All of the nodes’ values will be unique.
 * - p and q are different and both values will exist in the binary tree.
 * ==========================================================================================================
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2019/06/11
 */
public class Solution1 {
    /**
     * 解法一：递归（推荐）
     * 递归的语意是：如果根节点是p或者q之间的一个，则返回该节点，因为根节点就是最低公共祖先；否则，在左右子树中进行搜索，
     * 如果左、右子树的返回结果不为空，则说明此时p和q位于左右子树，则根节点即为最低公共祖先，如果左、右子树的返回结果
     * 存在空的情况，则p和q位于同一个子树下，返回的结果即为最低公共祖先。
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param root TreeNode, the root of a binary tree
     * @param p TreeNode, one node in the binary tree
     * @param q TreeNode, the other node in the binary tree
     * @return TreeNode, the lowest common ancestor of two nodes
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }
}