package cn.itlemon.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

import cn.itlemon.leetcode.model.TreeNode;

/**
 * No.144 二叉树的前序遍历 https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-06-25
 */
public class No144BinaryTreePreorderTraversal {

    /**
     * 递归法：O(n)
     *
     * @param root 根节点
     * @return 遍历后的列表
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private void helper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        helper(root.left, result);
        helper(root.right, result);
    }



}
