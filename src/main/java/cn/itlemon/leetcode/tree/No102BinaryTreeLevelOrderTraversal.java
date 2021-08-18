package cn.itlemon.leetcode.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import cn.itlemon.leetcode.model.TreeNode;

/**
 * No.102 二叉树的层序遍历 https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-08-11
 */
public class No102BinaryTreeLevelOrderTraversal {

    /**
     * BFS
     *
     * @param root 根节点
     * @return 遍历结果
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 定义结果集
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // 定义一个queue
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                assert node != null;
                levelList.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(levelList);
        }
        return result;
    }

}
