package cn.itlemon.leetcode.model;

/**
 * 二叉树节点类型
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-04-17
 */
public class TreeNode {

    /**
     * 值
     */
    int val;

    /**
     * 左节点指针
     */
    TreeNode left;

    /**
     * 右节点指针
     */
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
