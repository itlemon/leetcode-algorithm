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
        // 定义使用过的元素记录表
        boolean[] used = new boolean[9];
        backtracking(k, n, used, track, result);
        return result;
    }

    private void backtracking(int k, int n, boolean[] used, Deque<Integer> track, List<List<Integer>> result) {
        // 触发终止条件
        if (track.size() == k) {
            List<Integer> temp = new ArrayList<>(track);
            if (sum(temp) == n) {
                result.add(new ArrayList<>(track));
            }
            return;
        }
        
        // 回溯的核心部分
        for (int i = 0; i < 9; i++) {
            // 过滤掉已经使用过的元素和小于栈顶的元素
            if (used[i] || (!track.isEmpty() && i + 1 < track.peekLast())) {
                continue;
            }
            // 做选择
            track.addLast(i + 1);
            used[i] = true;
            backtracking(k, n, used, track, result);
            // 撤销选择
            track.removeLast();
            used[i] = false;
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
