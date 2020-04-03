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
 * @author  StrongXGP (xgp1227@gmail.com)
 * @date    2019/06/11
 */
public class Solution1 {
    /**
     * 解法一：递归
     *
     * 思路：
     * 如果根结点是p或者q之间的一个，则返回该节点，因为此时根结点就是最低公共祖先；否则，在左右子树中进行搜索，
     * 如果左、右子树的返回结果不为空，说明此时p和q位于左右子树，则根节点即为最低公共祖先；
     * 如果左、右子树的返回结果存在空的情况，则p和q位于同一个子树下，此时返回非空子树的结果。
     *
     * 备注：
     * 这种思路的前提是当树不为空时，p和q必须是树的两个不同的结点。否则，一旦根结点是两个结点中的一个，直接就
     * 返回了，也没有判断左右子树中是否存在另一个结点，这也是这种写法的缺陷。
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * Runtime: 5 ms, faster than 100.00% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
     * Memory Usage: 35.9 MB, less than 5.55% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
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

    // ========================================================================================== //
    // 以下是递归解法的另一种写法

    private TreeNode lca;

    public Solution1() {
        this.lca = null;
    }

    /**
     * 解法一：递归
     *
     *      root
     *     /   \
     * left    right
     *
     * 思路：
     * 二叉树的LCA出现在下面的两种情况：
     * 1. 二叉树的根节点为两个结点中的一个且另一个结点位于二叉树的左右子树之中
     * 2. 两个结点分别位于二叉树的左右子树中
     * 假设有方法`findLCA(...)`，当找到两个结点中任意一个结点时，返回true。因此，如果某个结点是两个结点的LCA，
     * 那么`findLCA(root)`、`findLCA(left)`和`findLCA(right)`三个方法的返回值，一定有两个返回true。
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * Runtime: 6 ms, faster than 74.47% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
     * Memory Usage: 35.3 MB, less than 5.55% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
     *
     * @param root TreeNode, the root of a binary tree
     * @param p TreeNode, one node in the binary tree
     * @param q TreeNode, the other node in the binary tree
     * @return TreeNode, the lowest common ancestor of two nodes
     */
    public TreeNode lowestCommonAncestorV2(TreeNode root, TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            // 如果p和q之间有一个为空的话，那么将有多种可能的LCA
            throw new IllegalArgumentException("[ERROR] The input nodes must not be null!!!");
        }
        // 这个函数返回true并不一定意味着找到了LCA，只要出现两个结点中任意一个就会返回true。
        // 所以想判断是否找到了LCA，直接看成员变量`lca`是否为空。
        findLCA(root, p, q);
        return this.lca;
    }

    private boolean findLCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        int mid = root == p || root == q ? 1 : 0;
        int left = findLCA(root.left, p, q) ? 1 : 0;
        int right = findLCA(root.right, p, q) ? 1 : 0;
        if (mid + left + right >= 2) {
            this.lca = root;
        }
        return mid + left + right > 0;
    }
}