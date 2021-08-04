package cn.itlemon.leetcode.recursion.backtracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import cn.itlemon.leetcode.model.TreeNode;

/**
 * No.113 路径总和 II https://leetcode-cn.com/problems/path-sum-ii/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-08-04
 */
public class No113PathSum2 {

    /**
     * 回溯
     *
     * @param root 根节点
     * @param targetSum 目标和
     * @return 路径和为目标值的列表
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        // 定义结果集
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // 定义路径
        Deque<Integer> track = new LinkedList<>();
        // 这里需要将根节点提前放进去
        track.addLast(root.val);
        backtracking(root, targetSum - root.val, track, result);
        return result;
    }

    private void backtracking(TreeNode root, int targetSum, Deque<Integer> track,
            List<List<Integer>> result) {
        // 触发终止条件
        if (root.left == null && root.right == null) {
            // 说明到达叶子节点
            if (targetSum == 0) {
                result.add(new ArrayList<>(track));
            }
            return;
        }

        // 回溯核心部分
        if (root.left != null) {
            // 做选择
            track.addLast(root.left.val);
            targetSum -= root.left.val;
            // 递归
            backtracking(root.left, targetSum, track, result);
            // 撤销选择
            track.removeLast();
            targetSum += root.left.val;
        }
        if (root.right != null) {
            // 做选择
            track.addLast(root.right.val);
            targetSum -= root.right.val;
            // 递归
            backtracking(root.right, targetSum, track, result);
            // 撤销选择
            track.removeLast();
            // 其实最后一个targetSum的撤销可以不用做了，因为已经在右分支了，不会再有其他分支，参数用不到了
            targetSum += root.right.val;
        }
    }

}
