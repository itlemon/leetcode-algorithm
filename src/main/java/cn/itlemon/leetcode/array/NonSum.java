package cn.itlemon.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * No.n nSum问题 发散自2Sum、3Sum以及nSum问题
 *
 * @author jiangpingping <jiangpingping@kuaishou.com>
 * Created on 2021-05-21
 */
public class NonSum {

    /**
     * 两数之和，返回的结果中不能重复，这个和No1TwoSum不同，那个是返回下标
     *
     * @param nums 数组
     * @param target 目标和
     * @return 不重复的数组
     */
    public List<List<Integer>> twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        return twoSumTarget(nums, 0, target);
    }

    /**
     * 两数之和公式
     *
     * @param nums 数组
     * @param start 开始索引
     * @param target 目标和
     * @return 不重复的数组
     */
    private List<List<Integer>> twoSumTarget(int[] nums, int start, int target) {
        int lo = start;
        int hi = nums.length - 1;
        List<List<Integer>> result = new ArrayList<>();
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            if (sum < target) {
                while (lo < hi && nums[lo] == nums[lo + 1]) {
                    lo++;
                }
            } else if (sum > target) {
                while (lo < hi && nums[hi] == nums[hi - 1]) {
                    hi--;
                }
            } else {
                result.add(new ArrayList<>(Arrays.asList(nums[lo], nums[hi])));
                while (lo < hi && nums[lo] == nums[lo + 1]) {
                    lo++;
                }
                while (lo < hi && nums[hi] == nums[hi - 1]) {
                    hi--;
                }
            }
        }
        return result;
    }


    /**
     * 三数之和问题：其实就是两数之和的延伸，穷举第一个数，后面两个数之和就是两数之问题
     *
     * @param nums 数组
     * @param target 目标和
     * @return 不重复的数组
     */
    public List<List<Integer>> threeSumTarget(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int size = nums.length;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> lists = twoSumTarget(nums, start + 1, target - nums[start]);
            for (List<Integer> list : lists) {
                list.add(nums[start]);
                result.add(list);
            }
            while (start < size - 1 && nums[start] == nums[start + 1]) {
                start++;
            }
        }
        return result;
    }


}
