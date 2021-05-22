package cn.itlemon.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * No.18 四数之和 https://leetcode-cn.com/problems/4sum/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-05-17
 */
public class No18FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4) {
            return result;
        }
        for (int i = 0; i < nums.length - 3; i++) {
            if (nums[i] >= target) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (nums[j] >= target) {
                    break;
                }
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int k = j + 1;
                int n = nums.length - 1;
                while (k < n) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[n];
                    if (sum > target) {
                        while (k < n && nums[n] == nums[--n]) {}
                    } else if (sum < target) {
                        while (k < n && nums[k] == nums[++k]) {}
                    } else {
                        result.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k], nums[n])));
                        while (k < n && nums[n] == nums[--n]) {}
                        while (k < n && nums[k] == nums[++k]) {}
                    }
                }
            }
        }
        return result;
    }
}
