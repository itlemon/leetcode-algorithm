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

    public int maxPathSum2(TreeNode root) {
        // 终止条件
        if (root == null) {
            return 0;
        }
        // 分别求左右最大路径和
        int left = Math.max(0, maxPathSum2(root.left));
        int right = Math.max(0, maxPathSum2(root.right));

        // 返回结果，对于某左右分支最大路径和小于0，那么直接剪枝
        ans = Math.max(ans, left + right + root.val);
        return ans;
    }

}
