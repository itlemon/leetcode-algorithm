package cn.itlemon.leetcode.recursion.backtracking;

import java.util.ArrayDeque;
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

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        Deque<Integer> stack = new LinkedList<>();
        return backTrack(nums);
    }

    private List<List<Integer>> backTrack(int[] nums) {
        return null;
    }

}
