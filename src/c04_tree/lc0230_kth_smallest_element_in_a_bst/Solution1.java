package c04_tree.lc0230_kth_smallest_element_in_a_bst;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * This is the solution of No. 230 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 *
 * Example 1:
 * Input: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * Output: 1
 *
 * Example 2:
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * Output: 3
 *
 * Follow up:
 * - What if the BST is modified (insert/delete operations) often and you need to find
 * the kth smallest frequently? How would you optimize the kthSmallest routine?
 * ==========================================================================================================
 *
 *  Tags: tree;
 *
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2019/06/21
 */
public class Solution1 {
    /**
     * Approach 1: Use the property of BST (Iteration)
     * The inorder traversal of BST is an array sorted in the ascending order
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * @param root TreeNode, the root of bst
     * @param k int, an integer used to specify the element to fetch
     * @return int, the kth smallest element in the bst
     */
    public int kthSmallestV1(TreeNode root, int k) {
        List<Integer> vals = new ArrayList<>();
        // Inorder traversal to take all elements
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            TreeNode node = stack.pop();
            vals.add(node.val);
            curr = node.right;
        }
        return vals.get(k-1);
    }

    /**
     * Approach 1: Use the property of BST (Recursion)
     * The inorder traversal of BST is an array sorted in the ascending order
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * @param root TreeNode, the root of bst
     * @param k int, an integer used to specify the element to fetch
     * @return int, the kth smallest element in the bst
     */
    public int kthSmallestV2(TreeNode root, int k) {
        List<Integer> vals = new ArrayList<>();
        inorderTraversal(root, vals);
        return vals.get(k - 1);
    }

    private void inorderTraversal(TreeNode root, List<Integer> vals) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, vals);
        vals.add(root.val);
        inorderTraversal(root.right, vals);
    }
}