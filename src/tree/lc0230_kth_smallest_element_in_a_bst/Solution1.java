package tree.lc0230_kth_smallest_element_in_a_bst;

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
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2019/06/21
 */
public class Solution1 {
    /**
     * 解法一：利用BST中序遍历的性质（迭代版）
     * 中序遍历BST，将遍历的结果存储起来，则索引为k-1的元素即为第k小的元素
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param root TreeNode, the root of bst
     * @param k int, an integer used to specify the element to fetch
     * @return int, the kth smallest element in the bst
     */
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> elements = new ArrayList<>();
        // Inorder traversal to take all elements
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                TreeNode node = stack.pop();
                elements.add(node.val);
                curr = node.right;
            }

            // or can write like this, a little faster
//            while (curr != null) {
//                stack.push(curr);
//                curr = curr.left;
//            }
//            TreeNode node = stack.pop();
//            elements.add(node.val);
//            curr = node.right;
        }
        return elements.get(k-1);
    }

    /**
     * 解法一：利用BST中序遍历的性质（递归版）
     * 中序遍历BST，将遍历的结果存储起来，则索引为k-1的元素即为第k小的元素
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param root TreeNode, the root of bst
     * @param k int, an integer used to specify the element to fetch
     * @return int, the kth smallest element in the bst
     */
    public int kthSmallestV2(TreeNode root, int k) {
        List<Integer> elements = new ArrayList<>();
        inorderTraversal(root, elements);
        return elements.get(k - 1);
    }

    private void inorderTraversal(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, res);
        res.add(root.val);
        inorderTraversal(root.right, res);
    }
}