package cn.itlemon.leetcode.recursion.backtracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * No.491 递增子序列 https://leetcode-cn.com/problems/increasing-subsequences/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-08-07
 */
public class No491IncreasingSubsequences {

    /**
     * 回溯
     *
     * @param nums 数组
     * @return 递增子序列列表
     */
    public List<List<Integer>> findSubsequences(int[] nums) {
        // 定义结果集
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        // 定义路径
        Deque<Integer> track = new LinkedList<>();
        backtracking(nums, 0, track, result);
        return result;
    }

    private void backtracking(int[] nums, int start, Deque<Integer> track, List<List<Integer>> result) {
        // 这里无终止条件，只要达到2个都可以加入到结果集中
        if (track.size() >= 2) {
            result.add(new ArrayList<>(track));
        }

        // 定义本层的used数组：题目提示nums[i] 在-100 到 100之间，共计201个数
        boolean[] used = new boolean[201];
        // 回溯的核心部分
        for (int i = start; i < nums.length; i++) {
            // 剪枝
            if (!track.isEmpty() && nums[i] < track.peekLast() || used[nums[i] + 100]) {
                continue;
            }
            // 做选择
            track.addLast(nums[i]);
            used[nums[i] + 100] = true;
            // 递归
            backtracking(nums, i + 1, track, result);
            // 撤销选择
            track.removeLast();
            // 这里无需操作used数组，因为同一层不能重复使用
        }
    }

}
