package cn.itlemon.leetcode.recursion;

import java.util.LinkedList;

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

    /**
     * 迭代法，广度优先遍历：O(n)
     *
     * @param root 根节点
     * @return 翻转后的二叉树
     */
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 创建一个队列
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // 处理队列中每一个元素的左右子节点
            TreeNode temp = queue.pollFirst();
            TreeNode left = temp.left;
            TreeNode right = temp.right;
            temp.left = right;
            temp.right = left;
            // 分别处理左右子节点
            if (temp.left != null) {
                queue.add(temp.left);
            }
            if (temp.right != null) {
                queue.add(temp.right);
            }
        }
        return root;
    }
}
