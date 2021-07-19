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

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int length = candidates.length;
        if (length == 0) {
            return result;
        }
        Deque<Integer> track = new LinkedList<>();
        backtracking(candidates, 0, length, target, track, result);
        return result;
    }

    private void backtracking(int[] candidates, int begin, int length, int target, Deque<Integer> track,
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
        for (int i = begin; i < length; i++) {
            // 做选择
            track.addLast(candidates[i]);
            // 递归:注意：由于每一个元素可以重复使用，下一轮搜索的起点依然是 i，这里非常容易弄错
            backtracking(candidates, i, length, target - candidates[i], track, result);
            // 撤销选择
            track.removeLast();
        }
    }


}
