package cn.itlemon.leetcode.recursion;

import java.util.HashMap;
import java.util.Map;

import cn.itlemon.leetcode.model.TreeNode;

/**
 * No.106 从中序与后序遍历序列构造二叉树 https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-07-03
 */
public class No105ConstructBinaryTreeFromInorderAndPostorderTraversal {

    /**
     * 递归解法
     *
     * @param inorder 中序遍历序列
     * @param postorder 后序遍历序列
     * @return 还原后的二叉树
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> indexContainer = new HashMap<>((int) (inorder.length / 0.75) + 1);
        for (int i = 0; i < inorder.length; i++) {
            indexContainer.put(inorder[i], i);
        }
        return buildTreeHelper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, indexContainer);
    }

    private TreeNode buildTreeHelper(int[] inorder, int is, int ie, int[] postorder, int pos, int poe,
            Map<Integer, Integer> map) {
        // 如果postorder为空，直接返回null
        if (ie < is || poe < pos) {
            return null;
        }
        // 获取根节点
        TreeNode root = new TreeNode(postorder[poe]);
        int ri = map.get(postorder[poe]);
        // 获取左子树的节点个数，这样就可以在后序遍历列表中确定左右子树
        int leftTreeNodeNum = ri - is;
        // 确定左右子树
        root.left = buildTreeHelper(inorder, is, ri - 1, postorder, pos, pos + leftTreeNodeNum - 1, map);
        root.right = buildTreeHelper(inorder, ri + 1, ie, postorder, pos + leftTreeNodeNum, poe - 1, map);
        return root;
    }

}
