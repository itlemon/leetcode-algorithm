package cn.itlemon.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * No.n nSum问题 发散自2Sum、3Sum以及nSum问题
 *
 * @author itlemon <lemon_jiang@aliyun.com>
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
     * 三数之和，No.15 https://leetcode-cn.com/problems/3sum/
     *
     * @param nums 数组
     * @param target 目标和
     * @return 不重复的数组
     */
    public List<List<Integer>> threeSum(int[] nums, int target) {
        Arrays.sort(nums);
        return threeSumTarget(nums, 0, 0);
    }

    /**
     * 四数之和问题：No.18 https://leetcode-cn.com/problems/4sum/
     *
     * @param nums 数组
     * @param target 目标和
     * @return 不重复的数组
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return fourSumTarget(nums, 0, target);
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
                while (lo < hi && nums[lo] == nums[++lo]) {
                }
            } else if (sum > target) {
                while (lo < hi && nums[hi] == nums[--hi]) {
                }
            } else {
                result.add(new ArrayList<>(Arrays.asList(nums[lo], nums[hi])));
                while (lo < hi && nums[lo] == nums[++lo]) {
                }
                while (lo < hi && nums[hi] == nums[--hi]) {
                }
            }
        }
        return result;
    }


    /**
     * 三数之和公式：其实就是两数之和的延伸，穷举第一个数，后面两个数之和就是两数之问题
     *
     * @param nums 数组
     * @param start 开始指针
     * @param target 目标和
     * @return 不重复的数组
     */
    private List<List<Integer>> threeSumTarget(int[] nums, int start, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int size = nums.length;
        for (int i = start; i < size; i++) {
            List<List<Integer>> lists = twoSumTarget(nums, i + 1, target - nums[i]);
            for (List<Integer> list : lists) {
                list.add(nums[i]);
                result.add(list);
            }
            while (i < size - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return result;
    }

    /**
     * 四数之和公式
     *
     * @param nums 数组
     * @param start 开始指针
     * @param target 目标和
     * @return 不重复的数组
     */
    private List<List<Integer>> fourSumTarget(int[] nums, int start, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int size = nums.length;
        for (int i = start; i < size; i++) {
            List<List<Integer>> lists = threeSumTarget(nums, i + 1, target - nums[i]);
            for (List<Integer> list : lists) {
                list.add(nums[i]);
                result.add(list);
            }
            while (i < size - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
        return result;
    }

    private List<List<Integer>> nSumTarget(int[] nums, int n, int start, int target) {
        int size = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if (n < 2 || size < n) {
            // 2Sum是base问题
            return result;
        }
        if (n == 2) {
            // 2Sum的问题
            int lo = start;
            int li = size - 1;
            while (lo < li) {
                int sum = nums[lo] + nums[li];
                if (sum < target) {
                    while (lo < li && nums[lo] == nums[++lo]) {
                    }
                } else if (sum > target) {
                    while (lo < li && nums[li] == nums[--li]) {
                    }
                } else {
                    result.add(new ArrayList<>(Arrays.asList(nums[lo], nums[li])));
                    while (lo < li && nums[lo] == nums[++lo]) {
                    }
                    while (lo < li && nums[li] == nums[--li]) {
                    }
                }
            }
        } else {
            // nSum问题，n>2时，递归计算(n - 1)Sum问题
            for (int i = start; i < size; i++) {
                List<List<Integer>> lists = nSumTarget(nums, n - 1, i + 1, target - nums[i]);
                for (List<Integer> list : lists) {
                    list.add(nums[i]);
                    result.add(list);
                }
                while (i < size - 1 && nums[i] == nums[i + 1]) {
                    // 如果这里的条件不满足，那么就交由外部的i++进行自增
                    i++;
                }
            }
        }
        return result;
    }

}
