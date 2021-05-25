package cn.itlemon.leetcode.tree;

import cn.itlemon.leetcode.model.TreeNode;

/**
 * No.104 二叉树的最大深度 https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 *
 * @author jiangpingping <jiangpingping@kuaishou.com>
 * Created on 2021-05-26
 */
public class No104MaximumDepthOfBinaryTree {

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
