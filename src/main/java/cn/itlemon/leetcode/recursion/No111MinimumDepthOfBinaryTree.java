package cn.itlemon.leetcode.recursion;

import cn.itlemon.leetcode.model.TreeNode;

/**
 * No.111 二叉树的最小深度 https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-06-30
 */
public class No111MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return left == 0 || right == 0 ? left + right + 1 : Math.min(left, right) + 1;
    }

}
