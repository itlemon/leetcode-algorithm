package cn.itlemon.leetcode.recursion.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * No.77 组合 https://leetcode-cn.com/problems/combinations/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-07-10
 */
public class No77Combinations {

    /**
     * 回溯算法
     *
     * @param n 数组[1, n]
     * @param k k个数
     * @return 组合
     */
    public List<List<Integer>> combine(int n, int k) {
        // 定义结果集
        List<List<Integer>> result = new ArrayList<>();
        if (n == 1) {
            result.add(new ArrayList<>(Collections.singletonList(1)));
            return result;
        }
        // 构成数组
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        // 定义路径
        Deque<Integer> track = new LinkedList<>();
        // 记录使用过的元素
        boolean[] used = new boolean[nums.length];
        // 回溯
        backtracking(nums, used, k, track, result);
        return result;
    }

    private void backtracking(int[] nums, boolean[] used, int k, Deque<Integer> track, List<List<Integer>> result) {
        // 触发终止条件
        if (track.size() == k) {
            result.add(new ArrayList<>(track));
            return;
        }

        // 回溯的核心部分
        for (int i = 0; i < nums.length; i++) {
            // 排除已经使用过的元素和小于栈顶的元素
            if (used[i] || (!track.isEmpty() && nums[i] < track.peekLast())) {
                continue;
            }
            // 做选择
            track.addLast(nums[i]);
            used[i] = true;
            // 递归
            backtracking(nums, used, k, track, result);
            // 撤销选择
            track.removeLast();
            used[i] = false;
        }

    }

}
