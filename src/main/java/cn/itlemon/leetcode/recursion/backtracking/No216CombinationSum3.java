package cn.itlemon.leetcode.recursion.backtracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * No.216 组合总和 III https://leetcode-cn.com/problems/combination-sum-iii/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-07-29
 */
public class No216CombinationSum3 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        // 定义结果集
        List<List<Integer>> result = new ArrayList<>();
        if (n <= 0 || k <= 0) {
            return result;
        }
        // 定义路径
        Deque<Integer> track = new LinkedList<>();
        backtracking(k, n, 0, track, result);
        return result;
    }

    private void backtracking(int k, int n, int start, Deque<Integer> track, List<List<Integer>> result) {
        // 触发终止条件
        if (track.size() == k) {
            List<Integer> temp = new ArrayList<>(track);
            if (sum(temp) == n) {
                result.add(new ArrayList<>(track));
            }
            return;
        }
        
        // 回溯的核心部分
        for (int i = start; i < 9; i++) {
            // 做选择
            track.addLast(i + 1);
            backtracking(k, n, i + 1, track, result);
            // 撤销选择
            track.removeLast();
        }
    }

    private int sum(List<Integer> track) {
        int sum = 0;
        for (Integer item : track) {
            sum += item;
        }
        return sum;
    }

}
