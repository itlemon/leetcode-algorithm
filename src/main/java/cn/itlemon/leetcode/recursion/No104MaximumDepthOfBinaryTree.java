package cn.itlemon.leetcode.recursion;

import cn.itlemon.leetcode.model.TreeNode;

/**
 * No.104 二叉树的最大深度 https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-06-30
 */
public class No104MaximumDepthOfBinaryTree {

    /**
     * 递归法：O(n)
     * @param root 根节点
     * @return 最大深度
     */
    public int maxDepth(TreeNode root) {
        // 终止条件
        if (root == null) {
            return 0;
        }
        // 二叉树左右子树最大深度
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        // 返回结果
        return Math.max(left, right) + 1;
    }

}
