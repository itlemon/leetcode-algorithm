package cn.itlemon.leetcode.recursion;

import cn.itlemon.leetcode.model.TreeNode;

/**
 * No.226 翻转二叉树 https://leetcode-cn.com/problems/invert-binary-tree/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-06-29
 */
public class No226InvertBinaryTree {

    /**
     * 递归法：O(n)
     *
     * @param root 根节点
     * @return 翻转后的二叉树
     */
    public TreeNode invertTree(TreeNode root) {
        // 第一步：确定终止条件
        if (root == null) {
            return null;
        }
        // 第二步：递归，结果看做是已经是翻转好的左右子树
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        // 第三步：做好本层的事情
        root.left = right;
        root.right = left;
        return root;
    }
}
