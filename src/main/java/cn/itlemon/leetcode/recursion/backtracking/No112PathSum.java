package cn.itlemon.leetcode.recursion.backtracking;

import cn.itlemon.leetcode.model.TreeNode;

/**
 * No.112 路径总和 https://leetcode-cn.com/problems/path-sum/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-08-04
 */
public class No112PathSum {

    /**
     * 递归算法
     *
     * @param root 根节点
     * @param targetSum 目标和
     * @return 是否有路径的和为目标和
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        // 判断root是否是叶子节点，这一点很重要
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

}
