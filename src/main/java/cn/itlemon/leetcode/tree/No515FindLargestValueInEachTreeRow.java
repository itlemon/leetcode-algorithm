package cn.itlemon.leetcode.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import cn.itlemon.leetcode.model.TreeNode;

/**
 * No.515 在每个树行中找最大值 https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-08-19
 */
public class No515FindLargestValueInEachTreeRow {

    /**
     * BFS
     *
     * @param root 根节点
     * @return 结果集
     */
    public List<Integer> largestValues(TreeNode root) {
        // 定义结果集
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        // 定义队列
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                assert node != null;
                max = Math.max(max, node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(max);
        }

        return result;
    }

}
