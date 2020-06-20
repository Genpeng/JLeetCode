package c04_tree.lc0236_lca_of_a_binary_tree;

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
 * Tags: tree;
 *
 * | Date          | #   | Desc   |
 * | ------------- | --- | ------ |
 * | June 11, 2019 | 1   | ×      |
 * | June 17, 2020 | 3   | ×      |
 */
public class Solution2 {
    /**
     * Approach 2: Iteration (v1, no consider boundary conditions)
     * The idea is to save the paths from node p and node q to root node respectively, and
     * then backtrack the first intersection node of two paths
     *
     * Complexity Analysis:
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * Result of Submission:
     * Runtime: 10 ms, faster than 22.37% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
     * Memory Usage: 40.2 MB, less than 95.75% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
     *
     * @param root TreeNode, the root of a binary tree
     * @param p TreeNode, one node in the binary tree
     * @param q TreeNode, the other node in the binary tree
     * @return TreeNode, the lowest common ancestor of two nodes
     */
    public TreeNode lowestCommonAncestorV1(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, TreeNode> path = new HashMap<>();
        stack.push(root);
        path.put(root, null);
        while (!stack.isEmpty()) {
            if (path.containsKey(p) && path.containsKey(q)) {
                break;
            }
            TreeNode node = stack.pop();
            if (node.right != null) {
                stack.push(node.right);
                path.put(node.right, node);
            }
            if (node.left != null) {
                stack.push(node.left);
                path.put(node.left, node);
            }
        }
        Set<TreeNode> ancestors = new HashSet<>();
        TreeNode node = p;
        while (node != null) {
            ancestors.add(node);
            node = path.get(node);
        }
        node = q;
        while (!ancestors.contains(node)) {
            node = path.get(node);
        }
        return node;
    }

    /**
     * Approach 2: Iteration (v2, more robust)
     * The idea is to save the paths from node p and node q to root node respectively, and
     * then backtrack the first intersection node of two paths
     *
     * Complexity Analysis:
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     *
     * Result of Submission:
     * Runtime: 10 ms, faster than 22.37% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
     * Memory Usage: 40.2 MB, less than 95.75% of Java online submissions for Lowest Common Ancestor of a Binary Tree.
     *
     * @param root TreeNode, the root of a binary tree
     * @param p TreeNode, one node in the binary tree
     * @param q TreeNode, the other node in the binary tree
     * @return TreeNode, the lowest common ancestor of two nodes
     */
    public TreeNode lowestCommonAncestorV2(TreeNode root, TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            throw new IllegalArgumentException("[ERROR] The input nodes must not be null!!!");
        }
        if (root == null) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, TreeNode> path = new HashMap<>();
        stack.push(root);
        path.put(root, null);
        TreeNode node;
        while (!stack.isEmpty()) {
            if (path.containsKey(p) && path.containsKey(q)) {
                break;
            }
            node = stack.pop();
            if (node.right != null) {
                stack.push(node.right);
                path.put(node.right, node);
            }
            if (node.left != null) {
                stack.push(node.left);
                path.put(node.left, node);
            }
        }
        Set<TreeNode> ancestors = new HashSet<>();
        node = p;
        while (node != null) {
            ancestors.add(node);
            node = path.get(node);
        }
        node = q;
        while (node != null && !ancestors.contains(node)) {
            node = path.get(node);
        }
        return node;
    }
}