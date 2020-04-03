package c04_tree.lc0230_kth_smallest_element_in_a_bst;

import entity.TreeNode;

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
public class Solution2 {
    /**
     * 解法二：在解法一的基础上进行改进，同样地，中序遍历二叉搜索树，当遍历到第k个元素的时候就停止遍历
     * 时间复杂度：O(log(N) + k)
     * 空间复杂度：O(log(N) + k)
     *
     * 疑问：
     * 对下面文章中时间复杂度和空间复杂度分析有疑惑
     * https://leetcode.com/articles/kth-smallest-element-in-a-bst/
     *
     * @param root TreeNode, the root of bst
     * @param k int, an integer used to specify the element to fetch
     * @return int, the kth smallest element in the bst
     */
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            TreeNode node = stack.pop();
            if (k-- == 1) {
                return node.val;
            }
            curr = node.right;
        }
        // 异常的两种情况：
        // 1. BST为空
        // 2. k < 1 or k > n，其中n表示BST结点数目
        throw new IllegalArgumentException("[ERROR] The BST is null or the value of k is illegal!!!");
    }
}