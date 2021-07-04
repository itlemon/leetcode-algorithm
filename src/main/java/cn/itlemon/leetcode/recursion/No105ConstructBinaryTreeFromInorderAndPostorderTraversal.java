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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> indexContainer = new HashMap<>((int) (inorder.length / 0.75) + 1);
        for (int i = 0; i < inorder.length; i++) {
            indexContainer.put(inorder[i], i);
        }
        return buildTreeHelper(postorder, 0, postorder.length, inorder, 0, inorder.length, indexContainer);
    }

    private TreeNode buildTreeHelper(int[] postorder, int postorderStart, int postorderEnd, int[] inorder,
            int inorderStart, int inorderEnd,
            Map<Integer, Integer> map) {
        // 如果postorder为空，直接返回null
        if (postorderStart == postorderEnd) {
            return null;
        }
        // 获取根节点
        int rootVal = inorder[inorderEnd - 1];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = map.get(rootVal);
        // 获取左子树的节点个数，这样就可以在后序遍历列表中确定左右子树
        int leftTreeNodeNum = rootIndex - inorderStart;
        // 确定左右子树
        root.left = buildTreeHelper(postorder, postorderStart, postorderStart + leftTreeNodeNum, inorder, inorderStart,
                rootIndex, map);
        root.right = buildTreeHelper(postorder, postorderStart + leftTreeNodeNum, postorderEnd - 1, inorder,
                rootIndex + 1, inorderEnd, map);
        return root;
    }

}
