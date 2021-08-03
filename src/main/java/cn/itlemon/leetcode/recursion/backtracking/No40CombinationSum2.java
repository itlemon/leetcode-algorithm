package cn.itlemon.leetcode.recursion.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * No.40 组合总和 II https://leetcode-cn.com/problems/combination-sum-ii/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-08-03
 */
public class No40CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 定义结果集
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        // 定义路径
        Deque<Integer> track = new LinkedList<>();
        // 定义一个元素使用记录表
        boolean[] used = new boolean[candidates.length];
        // 回溯
        backtracking(candidates, used, 0, target, track, result);
        return result;
    }

    private void backtracking(int[] candidates, boolean[] used, int start, int target, Deque<Integer> track,
            List<List<Integer>> result) {
        // 触发结束条件
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(track));
            return;
        }

        // 回溯的核心部分
        for (int i = 0; i < candidates.length; i++) {
            if (used[i] || (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1])) {
                continue;
            }
            // 做选择
            track.addLast(candidates[i]);
            used[i] = true;
            // 回溯
            backtracking(candidates, used, i + 1, target - candidates[i], track, result);
            // 撤销选择
            track.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] candidates = {1, 1, 2, 5, 6, 7, 10};
        int target = 8;
        System.out.println(new No40CombinationSum2().combinationSum2(candidates, target));
    }

}
