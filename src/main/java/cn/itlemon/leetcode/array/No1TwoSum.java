package cn.itlemon.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * No.1 两数之和 https://leetcode-cn.com/problems/two-sum/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-05-15
 */
public class No1TwoSum {

    /**
     * 暴力遍历法：O(n^2)
     *
     * @param nums 数组
     * @param target 目标值
     * @return 下标数组
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[0];
    }

    /**
     * 一遍HashMap法：O(n)
     *
     * @param nums 数组
     * @param target 目标值
     * @return 小标数组
     */
    public int[] towSum2(int[] nums, int target) {
        Map<Integer, Integer> container = new HashMap<>((int) (nums.length / 0.75 + 1));
        for (int i = 0; i < nums.length; i++) {
            if (container.containsKey(target - nums[i])) {
                return new int[] {container.get(target - nums[i]), i};
            }
            container.put(nums[i], i);
        }
        return new int[0];
    }

}
