package cn.itlemon.leetcode.tree;

import cn.itlemon.leetcode.model.TreeNode;

/**
 * 124. 二叉树中的最大路径和
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-04-17
 */
public class No124BinaryTreeMaximumPathSum {

    private int ans = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        max(root);
        return ans;
    }

    private void max(TreeNode root) {
        if (root == null) {
            return;
        }

        int left = Math.max(0, maxPathSum(root.left));
        int right = Math.max(0, maxPathSum(root.right));

        ans = Math.max(ans, left + right + root.val);

    }

}
