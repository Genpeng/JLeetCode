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
 * preorder = [3,9,20,15,7]
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
    private Map<Integer, Integer> map;

    /**
     * 题意：
     * - 基于二叉树的前序遍历和中序遍历构造二叉树
     *
     * 思路：
     * 利用前序遍历和中序遍历结果的性质，可以利用的性质有：
     * - 前序遍历的第一个元素为根结点
     * - 中序遍历根结点左边的元素为左子树，右边的元素为右子树
     *
     * 解法1：递归
     * 利用前序遍历确定根结点，中序遍历确定左右子树
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * 解法2：迭代（TODO）
     *
     * @param preorder int[], preorder traversal of the binary tree
     * @param inorder int[], inorder traversal of the binary tree
     * @return TreeNode, the root of the binary tree we constructed
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        map = new HashMap<>(n);
        for (int i = 0; i < n; ++i) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, n-1, inorder, 0, n-1);
    }

    private TreeNode build(int[] preorder, int pstart, int pend, int[] inorder, int istart, int iend) {
        // 递归终止条件不是那么容易可以想到
        if (istart > iend) {
            return null;
        }
        int proot = pstart;
        int iroot = map.get(preorder[proot]);
        int leftSize = iroot - istart;
        TreeNode root = new TreeNode(preorder[proot]);
        root.left = build(preorder, proot+1, proot+leftSize, inorder, istart, iroot-1);
        root.right = build(preorder, pstart+leftSize+1, pend, inorder, iroot+1, iend);
        return root;
    }
}