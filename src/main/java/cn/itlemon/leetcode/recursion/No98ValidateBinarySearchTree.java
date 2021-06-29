package cn.itlemon.leetcode.recursion;

import cn.itlemon.leetcode.model.TreeNode;

/**
 * No.98 验证二叉搜索树 https://leetcode-cn.com/problems/validate-binary-search-tree/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-06-30
 */
public class No98ValidateBinarySearchTree {

    /**
     * 递归法：O(n)
     *
     * @param root 根节点
     * @return 是否是有效BST
     */
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean helper(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return helper(node.left, lower, node.val) && helper(node.right, node.val, upper);
    }


}
