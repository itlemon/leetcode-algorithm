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
        backtracking(k, n, 0, 0, track, result);
        return result;
    }

    private void backtracking(int k, int n, int start, int sum, Deque<Integer> track, List<List<Integer>> result) {
        // 剪枝：如何sum已经大于n了，后面就无需再遍历了，也无意义了，因为后面的肯定大于n
        if (sum > n) {
            return;
        }

        // 触发终止条件
        if (track.size() == k) {
            if (sum == n) {
                result.add(new ArrayList<>(track));
            }
            return;
        }
        
        // 回溯的核心部分
        for (int i = start; i < 9; i++) {
            // 做选择
            track.addLast(i + 1);
            sum += i + 1;
            backtracking(k, n, i + 1, sum, track, result);
            // 撤销选择
            track.removeLast();
            sum -= i + 1;
        }
    }
}
