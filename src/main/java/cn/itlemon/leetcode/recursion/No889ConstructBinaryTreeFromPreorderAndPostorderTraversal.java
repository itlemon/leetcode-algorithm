package cn.itlemon.leetcode.recursion;

import java.util.HashMap;
import java.util.Map;

import cn.itlemon.leetcode.model.TreeNode;

/**
 * No.889 根据前序和后序遍历构造二叉树 https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-07-05
 */
public class No889ConstructBinaryTreeFromPreorderAndPostorderTraversal {

    /**
     * 递归解法
     *
     * @param pre 前序遍历序列
     * @param post 后序遍历序列
     * @return 还原后的二叉树
     */
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < post.length; i++) {
            map.put(post[i], i);
        }
        return buildTreeHelper(pre, 0, pre.length - 1, post, 0, post.length - 1, map);
    }

    private TreeNode buildTreeHelper(int[] preorder, int ps, int pe, int[] postorder, int is, int ie,
            Map<Integer, Integer> map) {
        // 递归终止条件
        if (pe < ps || ie < is) {
            return null;
        }

        // 递归本层次需要做的事情
        // 获取根节点
        TreeNode root = new TreeNode(preorder[ps]);
        // 获取左子树的根节点在后序遍历序列中的索引
        if (ps + 1 > pe) {
            return root;
        }
        int leftRootIndex = map.get(preorder[ps + 1]);
        // 确定左子树的数量，从而可以从前序遍历中找到左子树和右子树
        int leftChildTreeNodeNum = leftRootIndex - is + 1;

        // 递归过程
        root.left = buildTreeHelper(preorder, ps + 1, ps + leftChildTreeNodeNum, postorder, is, leftRootIndex, map);
        root.right =
                buildTreeHelper(preorder, ps + leftChildTreeNodeNum + 1, pe, postorder, leftRootIndex + 1, ie - 1, map);
        return root;
    }

}
