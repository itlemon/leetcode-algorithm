package cn.itlemon.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import cn.itlemon.leetcode.model.TreeNode;

/**
 * No.94 二叉树的中序遍历 https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-06-24
 */
public class No94BinaryTreeInorderTraversal {

    /**
     * 递归法：O(n)
     *
     * @param root 根节点
     * @return 遍历后的列表
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private void helper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        helper(root.left, result);
        result.add(root.val);
        helper(root.right, result);
    }

    /**
     * 迭代法：O(n)
     *
     * @param root 根节点
     * @return 遍历后的列表
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }

}
