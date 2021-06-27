package cn.itlemon.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

import cn.itlemon.leetcode.model.Node;

/**
 * No.589 N 叉树的前序遍历 https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-06-26
 */
public class No589NaryTreePreorderTraversal {

    /**
     * 递归法：O(n)
     *
     * @param root 根节点
     * @return 遍历后的列表
     */
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private void helper(Node root, List<Integer> result) {
        if (root != null) {
            result.add(root.val);
            for (Node child : root.children) {
                helper(child, result);
            }
        }
    }

}
