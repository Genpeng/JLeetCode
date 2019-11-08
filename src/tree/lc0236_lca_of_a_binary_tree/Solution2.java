package tree.lc0236_lca_of_a_binary_tree;

import entity.TreeNode;

import java.util.*;

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
public class Solution2 {
    /**
     * 解法二：迭代（分别保留从根结点到p和q的路径，再回溯第一个公共结点）
     *
     * 步骤：
     * - 遍历二叉树，保存孩子结点到父亲结点的映射，直到找到p和q
     * - 通过保存的映射关系，回溯从p到根结点的路径，并将路径结点保存到一个set中
     * - 同样地，也回溯从q到根结点的路径，则第一个出现在set中的结点即为LCA
     *
     * 备注：
     * 下面的写法有一个前提，就是二叉树不为空，且两个结点一定是二叉树的孩子结点。
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
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, TreeNode> child2Parent = new HashMap<>();
        stack.push(root);
        child2Parent.put(root, null);
        while (!child2Parent.containsKey(p) || !child2Parent.containsKey(q)) {
            TreeNode node = stack.pop();
            if (node.right != null) {
                stack.push(node.right);
                child2Parent.put(node.right, node);
            }
            if (node.left != null) {
                stack.push(node.left);
                child2Parent.put(node.left, node);
            }
        }
        Set<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = child2Parent.get(p);
        }
        while (!ancestors.contains(q)) {
            q = child2Parent.get(q);
        }
        return q;
    }

    // ========================================================================================== //
    // 为了使程序更加鲁棒一些，添加了对于边界、异常情况的处理

    /**
     * 解法二：迭代（分别保留从根结点到p和q的路径，再回溯第一个公共结点）
     * - 遍历二叉树，保存孩子结点到父亲结点的映射，直到找到p和q
     * - 通过保存的映射关系，回溯从p到根结点的路径，并将路径结点保存到一个set中
     * - 同样地，也回溯从q到根结点的路径，则第一个出现在set中的结点即为LCA
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param root TreeNode, the root of a binary tree
     * @param p TreeNode, one node in the binary tree
     * @param q TreeNode, the other node in the binary tree
     * @return TreeNode, the lowest common ancestor of two nodes
     */
    public TreeNode lowestCommonAncestorV2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (p == null || q == null) {
            // 如果p和q之间有一个为空的话，那么将有多种可能的LCA
            throw new IllegalArgumentException("[ERROR] The input nodes must not be null!!!");
        }
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, TreeNode> child2Parent = new HashMap<>();
        stack.push(root);
        child2Parent.put(root, null);
        TreeNode node;
        while (!stack.isEmpty()) {
            node = stack.pop();
            if (node.right != null) {
                stack.push(node.right);
                child2Parent.put(node.right, node);
            }
            if (node.left != null) {
                stack.push(node.left);
                child2Parent.put(node.left, node);
            }
            if (child2Parent.containsKey(p) && child2Parent.containsKey(q)) {
                break;
            }
        }
        Set<TreeNode> ancestors = new HashSet<>();
        node = p;
        while (node != null) {
            ancestors.add(node);
            node = child2Parent.get(node);
        }
        node = q;
        while (node != null && !ancestors.contains(node)) {
            node = child2Parent.get(node);
        }
        return node;
    }
}