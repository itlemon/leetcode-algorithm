package cn.itlemon.leetcode.recursion.backtracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * No.46 全排列 https://leetcode-cn.com/problems/permutations/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-07-12
 */
public class No46Permutations {

    /**
     * 回溯算法
     *
     * @param nums 数组
     * @return 全排列
     */
    public List<List<Integer>> permute(int[] nums) {
        // 保存路径结果
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        // 记录路径
        Deque<Integer> track = new LinkedList<>();
        // 记录使用过的元素
        boolean[] used = new boolean[nums.length];
        backtracking(nums, used, track, result);
        return result;
    }

    private void backtracking(int[] nums, boolean[] used, Deque<Integer> track,
            List<List<Integer>> result) {
        // 触发结束条件
        if (track.size() == nums.length) {
            result.add(new ArrayList<>(track));
            return;
        }

        // 回溯的核心部分
        for (int i = 0; i < nums.length; i++) {
            // 排除已用的元素
            if (used[i]) {
                continue;
            }
            // 做选择
            track.addLast(nums[i]);
            // 标记当前元素已经被选择，相当于从选择列表中移除了
            used[i] = true;
            // 递归
            backtracking(nums, used, track, result);
            // 撤销选择
            track.removeLast();
            // 标记当前元素撤销选择，相当于恢复到了选择列表中
            used[i] = false;
        }


    }

}
