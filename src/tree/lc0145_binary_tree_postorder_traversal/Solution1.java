package tree.lc0145_binary_tree_postorder_traversal;

import entity.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * This is the solution of No. 145 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/binary-tree-postorder-traversal/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a binary tree, return the postorder traversal of its nodes' values.
 *
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [3,2,1]
 *
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 * ==========================================================================================================
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2019/05/15
 */
public class Solution1 {
    /**
     * 解法一：递归
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param root TreeNode, the root of binary tree
     * @return List<Integer>, the postorder traversal of binary tree
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        postorderTraversal(root, ans);
        return ans;
    }

    private void postorderTraversal(TreeNode root, List<Integer> vals) {
        if (root == null) {
            return;
        }
        postorderTraversal(root.left, vals);
        postorderTraversal(root.right, vals);
        vals.add(root.val);
    }
}