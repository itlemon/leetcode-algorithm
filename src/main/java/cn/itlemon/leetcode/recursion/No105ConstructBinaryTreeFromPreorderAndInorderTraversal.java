package cn.itlemon.leetcode.recursion;

import java.util.HashMap;
import java.util.Map;

import cn.itlemon.leetcode.model.TreeNode;

/**
 * No.104 从前序与中序遍历序列构造二叉树 https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-07-03
 */
public class No105ConstructBinaryTreeFromPreorderAndInorderTraversal {

    /**
     * 递归法
     *
     * @param preorder 前序遍历列表
     * @param inorder 中序遍历列表
     * @return 二叉树
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    private TreeNode buildTreeHelper(int[] preorder, int ps, int pe, int[] inorder, int is, int ie,
            Map<Integer, Integer> map) {
        // 递归终止条件
        if (pe < ps || ie < is) {
            return null;
        }

        // 递归本层次需要做的事情
        // 获取根节点
        TreeNode root = new TreeNode(preorder[ps]);
        // 获取根节点在中序遍历结果序列中的位置
        int ri = map.get(preorder[ps]);
        // 确定左子树的数量，从而可以从前序遍历中找到左子树和右子树
        int leftChildTreeNodeNum = ri - is;

        // 递归过程
        root.left = buildTreeHelper(preorder, ps + 1, ps + leftChildTreeNodeNum, inorder, is, ri - 1, map);
        root.right = buildTreeHelper(preorder, ps + leftChildTreeNodeNum + 1, pe, inorder, ri + 1, ie, map);
        return root;
    }

}
