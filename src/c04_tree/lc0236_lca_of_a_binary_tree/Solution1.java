package c04_tree.lc0236_lca_of_a_binary_tree;

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
 * Difficulty: Medium
 * Tags: tree;
 *
 * @author Genpeng Xu (xgp1227atgmail.com)
 */
public class Solution1 {
    /**
     * TODO: 把思路用英文表达（英文太烂 -_-||）
     *
     * Approach 1: Recursion (v1)
     * 思路：
     * 如果根结点是 p 或者 q 中间的一个，返回根结点，此时根结点即为 LCA；否则在左右子树中查找
     * 如果左右子树的返回结果都不为空，说明 p 和 q 分别位于左右子树中，此时根结点即为 LCA
     * 如果左右子树的返回结果存在为空的情况，说明 p 和 q 位于同一棵子树，此时 LCA 为非空子树的结果
     *
     * 这道题如果没有备注说明的两点的话，会存在下面几种边界条件
     * 1. 树为空
     * 2. p 和 q 存在至少一个为 null
     * 3. p 和 q 都不为 null，只有一个在树中
     * 4. p 和 q 都不为 null，而且两个都不在树中
     * 本解法可以解决的边界条件有 1 和 4
     *
     * Complexity Analysis:
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * Result of Submission:
     * Runtime: 5 ms, faster than 100.00% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
     * Memory Usage: 35.9 MB, less than 5.55% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
     *
     * @param root TreeNode, the root of a binary tree
     * @param p TreeNode, one node in the binary tree
     * @param q TreeNode, the other node in the binary tree
     * @return TreeNode, the lowest common ancestor of two nodes
     */
    public TreeNode lowestCommonAncestorV1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestorV1(root.left, p, q);
        TreeNode right = lowestCommonAncestorV1(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }

    private TreeNode lca;

    /**
     * 题意：
     * - 找出二叉树中指定结点的最近公共祖先（LCA）
     *
     * 思路：
     * - 假设一个结点 t 是结点 p 和 q 的 LCA，则必须是以下的两种情况
     *   a) t 是 p 和 q 中的一个，剩余的一个结点是 t 的子树（左或者右）
     *   b) p 和 q 都是 t 的子树（左或者右）
     * - 假设 f(t, p, q) 表示以 t 为根结点的树中是否包含 p 或者 q，如果 t 是 p 和 q 的 LCA，则有
     * - f(t, p, q) + f(t.left, p, q) + f(t.right, p, q) >= 2
     *
     * 解法1：递归
     * 时间复杂度：O(N)
     * 空间复杂度：O(N)
     *
     * Approach 1: Recursion (v2, recommended)
     * 思路：
     * 二叉树的 LCA 出现在下面的两种情况：
     * 1. 根结点为两个结点中的一个且另一个结点位于二叉树的左右子树之中
     * 2. 两个结点分别位于二叉树的左右子树中
     * 假设有方法 `search(...)`，当找到两个结点中任意一个结点时，返回 `true`。因此，如果某个结点是两个结点的 LCA，
     * 那么 `search(root)`、`search(left)` 和 `search(right)` 三个方法的返回值，一定有两个返回 `true`。
     *
     * 这道题如果如果没有备注说明的两点的话，会存在下面几种边界条件
     * 1. 树为空
     * 2. p 和 q 存在至少一个为 null
     * 3. p 和 q 都不为 null，只有一个在树中
     * 4. p 和 q 都不为 null，而且两个都不在树中
     * 本解法可以解决所有的边界条件
     *
     * Complexity Analysis:
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * Result of Submission:
     * Runtime: 6 ms, faster than 74.47% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
     * Memory Usage: 35.3 MB, less than 5.55% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
     *
     * @param root TreeNode, the root of a binary tree
     * @param p TreeNode, one node in the binary tree
     * @param q TreeNode, the other node in the binary tree
     * @return TreeNode, the lowest common ancestor of two nodes
     */
    public TreeNode lowestCommonAncestorV2(TreeNode root, TreeNode p, TreeNode q) {
        if (p == null || q == null) { // 解决边界条件 2
            throw new IllegalArgumentException("[ERROR] The input nodes must not be null!!!");
        }
        this.lca = null;
        // 这个函数返回 `true` 并不一定意味着找到了 LCA，只要出现两个结点中任意一个就会返回 `true`
        // 所以想判断是否找到了 LCA，直接看成员变量 `lca` 是否为空
        search(root, p, q);
        return this.lca;
    }

    private boolean search(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        int mid = root == p || root == q ? 1 : 0;
        int left = search(root.left, p, q) ? 1 : 0;
        int right = search(root.right, p, q) ? 1 : 0;
        if (mid + left + right >= 2) {
            this.lca = root;
        }
        return mid + left + right > 0;
    }
}