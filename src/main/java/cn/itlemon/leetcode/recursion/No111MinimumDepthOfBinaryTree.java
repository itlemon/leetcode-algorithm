package cn.itlemon.leetcode.recursion;

import java.util.Deque;
import java.util.LinkedList;

import cn.itlemon.leetcode.model.TreeNode;

/**
 * No.111 二叉树的最小深度 https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-06-30
 */
public class No111MinimumDepthOfBinaryTree {

    /**
     * 递归法，深度优先遍历：O(n)
     *
     * @param root 根节点
     * @return 最小深度
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return left == 0 || right == 0 ? left + right + 1 : Math.min(left, right) + 1;
    }

    /**
     * 迭代法，广度优先遍历：O(n)
     * @param root 根节点
     * @return 最小深度
     */
    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        // 根节点入队
        queue.addLast(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.removeFirst();
                if (treeNode.left == null && treeNode.right == null) {
                    return depth;
                }
                if (treeNode.left != null) {
                    queue.addLast(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.addLast(treeNode.right);
                }
            }
            depth++;
        }
        return depth;
    }

}
