package cn.itlemon.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

import cn.itlemon.leetcode.model.Node;

/**
 * No.590 N 叉树的后序遍历 https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-06-25
 */
public class No590NaryTreePostorderTraversal {

    /**
     * 递归法：O(n)
     *
     * @param root 根节点
     * @return 遍历后的列表
     */
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private void helper(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (root.children != null) {
            for (int i = 0; i < root.children.size(); i++) {
                helper(root.children.get(i), result);
            }
        }

    }

}
