package cn.itlemon.leetcode.recursion.backtracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * No.39 组合总和 https://leetcode-cn.com/problems/combination-sum/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-07-19
 */
public class No39CombinationSum {

    /**
     * 回溯算法
     *
     * @param candidates 数组
     * @param target 目标和
     * @return 组合
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 定义结果集
        List<List<Integer>> result = new ArrayList<>();
        if (candidates.length == 0) {
            return result;
        }
        // 定义路径
        Deque<Integer> track = new LinkedList<>();
        // 回溯
        backtracking(candidates, 0, target, track, result);
        return result;
    }

    private void backtracking(int[] candidates, int begin, int target, Deque<Integer> track,
            List<List<Integer>> result) {
        // 结束条件
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(track));
            return;
        }

        // 重点理解这里是从begin开始的
        for (int i = begin; i < candidates.length; i++) {
            // 做选择
            track.addLast(candidates[i]);
            // 递归:注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
            backtracking(candidates, i, target - candidates[i], track, result);
            // 撤销选择
            track.removeLast();
        }
    }


}
