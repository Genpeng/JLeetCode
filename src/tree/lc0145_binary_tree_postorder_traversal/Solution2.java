package tree.lc0145_binary_tree_postorder_traversal;

import entity.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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
public class Solution2 {
    /**
     * 解法二：迭代
     * 后序遍历的顺序为：左子树 -> 右子树 -> 结点，迭代的思路是先求出后序遍历的逆，即 结点 -> 右子树 -> 左子树，
     * 然后再将得到的结果进行逆序。
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param root TreeNode, the root of binary tree
     * @return List<Integer>, the postorder traversal of binary tree
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode node;
        while (!stack.isEmpty()) {
            node = stack.pop();
            ans.addFirst(node.val);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return ans;
    }

    /**
     * 解法二：迭代
     * 后序遍历的顺序为：左子树 -> 右子树 -> 结点，迭代的思路是先求出后序遍历的逆，即 结点 -> 右子树 -> 左子树，
     * 然后再将得到的结果进行逆序。
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param root TreeNode, the root of binary tree
     * @return List<Integer>, the postorder traversal of binary tree
     */
    public List<Integer> postorderTraversalV2(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                ans.addFirst(curr.val);
                stack.push(curr);
                curr = curr.right;
            } else {
                curr = stack.pop().left;
            }
        }
        return ans;
    }

    /**
     * 解法二：迭代
     * 后序遍历的顺序为：左子树 -> 右子树 -> 结点，迭代的思路是先求出后序遍历的逆，即 结点 -> 右子树 -> 左子树，
     * 然后再将得到的结果进行逆序。
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param root TreeNode, the root of binary tree
     * @return List<Integer>, the postorder traversal of binary tree
     */
    public List<Integer> postorderTraversalV3(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                ans.addFirst(curr.val);
                stack.push(curr);
                curr = curr.right;
            }
            curr = stack.pop().left;
        }
        return ans;
    }
}