package cn.itlemon.leetcode.recursion.backtracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * No.78 子集 https://leetcode-cn.com/problems/subsets/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-07-11
 */
public class No78Subsets {

    /**
     * 回溯
     *
     * @param nums 数组
     * @return 子集列表
     */
    public List<List<Integer>> subsets(int[] nums) {
        // 定义结果集
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        // 定义路径
        Deque<Integer> track = new LinkedList<>();
        // 通过for循环确定每次组合的个数
        for (int i = 0; i <= nums.length; i++) {
            backtracking(nums, i, 0, track, result);
        }
        return result;
    }

    private void backtracking(int[] nums, int count, int start, Deque<Integer> track, List<List<Integer>> result) {
        // 触发终止条件
        if (count == track.size()) {
            result.add(new ArrayList<>(track));
        }

        // 回溯的核心部分
        for (int i = start; i < nums.length; i++) {
            // 做选择
            track.addLast(nums[i]);
            // 递归
            backtracking(nums, count, i + 1, track, result);
            // 做选择
            track.removeLast();
        }
    }

}
