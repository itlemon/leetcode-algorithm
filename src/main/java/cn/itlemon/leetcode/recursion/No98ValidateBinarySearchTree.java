package cn.itlemon.leetcode.recursion;

import java.util.Deque;
import java.util.LinkedList;

import cn.itlemon.leetcode.model.TreeNode;

/**
 * No.98 验证二叉搜索树 https://leetcode-cn.com/problems/validate-binary-search-tree/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-06-30
 */
public class No98ValidateBinarySearchTree {

    /**
     * 递归法：O(n)
     *
     * @param root 根节点
     * @return 是否是有效BST
     */
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean helper(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return helper(node.left, lower, node.val) && helper(node.right, node.val, upper);
    }

    /**
     * 迭代法，搜索二叉树中序遍历是一个严格递增的数组
     *
     * @param root 根节点
     * @return 是否是有效BST
     */
    public boolean isValidBST2(TreeNode root) {
        // 使用一个栈来暂存遍历结果
        Deque<Integer> container = new LinkedList<>();
        Deque<TreeNode> treeNodeStack = new LinkedList<>();
        while (root != null || !treeNodeStack.isEmpty()) {
            while (root != null) {
                treeNodeStack.push(root);
                root = root.left;
            }
            root = treeNodeStack.pop();
            if (!container.isEmpty() && container.peek() >= root.val) {
                return false;
            }
            container.push(root.val);
            root = root.right;
        }
        return true;
    }
}
