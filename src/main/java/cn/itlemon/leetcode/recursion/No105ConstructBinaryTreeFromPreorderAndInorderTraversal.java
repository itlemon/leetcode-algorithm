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
        Map<Integer, Integer> indexContainer = new HashMap<>((int) (inorder.length / 0.75) + 1);
        for (int i = 0; i < inorder.length; i++) {
            indexContainer.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length, indexContainer);
    }

    private TreeNode buildTreeHelper(int[] preorder, int preorderStart, int preorderEnd, int[] inorder,
            int inorderStart, int inorderEnd, Map<Integer, Integer> map) {
        // 如果preorder为空，直接返回null
        if (preorderStart == preorderEnd) {
            return null;
        }
        // 获取根节点
        int rootVal = preorder[preorderStart];
        int rootIndex = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        // 确定左子树数量，从而可以从前序遍历的列表中找到所有的左子树
        int leftTreeNodeNum = rootIndex - inorderStart;
        // 确定左右节点
        root.left =
                buildTreeHelper(preorder, preorderStart + 1, preorderStart + leftTreeNodeNum + 1, inorder, inorderStart,
                        rootIndex, map);
        root.right =
                buildTreeHelper(preorder, preorderStart + leftTreeNodeNum + 1, preorderEnd, inorder, rootIndex + 1,
                        inorderEnd, map);
        return root;
    }


}
