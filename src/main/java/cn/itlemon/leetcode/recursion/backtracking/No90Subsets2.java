package cn.itlemon.leetcode.recursion.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * No.90 子集 II https://leetcode-cn.com/problems/subsets-ii/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-08-07
 */
public class No90Subsets2 {

    /**
     * 回溯
     *
     * @param nums 数组
     * @return 结果集
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 定义结果集
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        // 排序很关键，需要剪枝
        Arrays.sort(nums);
        // 定义路径
        Deque<Integer> track = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        // 通过for循环确定每次组合的个数
        for (int i = 0; i <= nums.length; i++) {
            backtracking(nums, i, 0, used, track, result);
        }
        return result;
    }

    private void backtracking(int[] nums, int count, int start, boolean[] used, Deque<Integer> track,
            List<List<Integer>> result) {
        // 触发终止条件
        if (count == track.size()) {
            result.add(new ArrayList<>(track));
            return;
        }

        // 回溯的核心部分
        for (int i = start; i < nums.length; i++) {
            // 剪枝
            if (i > start && nums[i - 1] == nums[i] && !used[i - 1]) {
                continue;
            }
            // 做选择
            track.addLast(nums[i]);
            used[i] = true;
            // 递归
            backtracking(nums, count, i + 1, used, track, result);
            // 取消选择
            track.removeLast();
            used[i] = false;
        }
    }

}
