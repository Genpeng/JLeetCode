package c04_tree.lc0236_lca_of_a_binary_tree;

import entity.TreeNode;

import javafx.util.Pair;

import java.util.Stack;

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
public class Solution3 {
    private static final int BOTH_PENDING = 2;
    private static final int LEFT_DONE = 1;
    private static final int BOTH_DONE = 0;

    /**
     * 解法三：迭代（不推荐）
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
        if (root == null) {
            return null;
        }
        if (p == null || q == null) {
            // 如果p和q之间有一个为空的话，那么将有多种可能的LCA
            throw new IllegalArgumentException("[ERROR] The input nodes must not be null!!!");
        }
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, BOTH_PENDING));
        boolean oneNodeFound = false;
        TreeNode lca = null;
        TreeNode childNode = null;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> top = stack.peek();
            TreeNode parentNode = top.getKey();
            int parentState = top.getValue();
            if (parentState != BOTH_DONE) {
                if (parentState == BOTH_PENDING) { // parentState == BOTH_PENDING
                    if (parentNode == p || parentNode == q) {
                        if (oneNodeFound) {
                            return lca;
                        } else {
                            oneNodeFound = true;
                            lca = parentNode;
                        }
                    }
                    childNode = parentNode.left;
                } else { // parentState == LEFT_DONE
                    childNode = parentNode.right;
                }
                stack.pop();
                stack.push(new Pair<>(parentNode, parentState - 1));
                if (childNode != null) {
                    stack.push(new Pair<>(childNode, BOTH_PENDING));
                }
            } else { // parentState == BOTH_DONE
                if (lca == stack.pop().getKey() && oneNodeFound) {
                    lca = stack.peek().getKey();
                }
            }
        }
        return null;
    }
}