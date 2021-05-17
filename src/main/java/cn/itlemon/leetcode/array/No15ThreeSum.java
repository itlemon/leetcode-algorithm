package cn.itlemon.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * No.15 三数之和 https://leetcode-cn.com/problems/3sum/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-05-15
 */
public class No15ThreeSum {

    /**
     * 暴力法：O(n^3)
     *
     * @param nums 数组
     * @return 数组列表
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Map<String, List<Integer>> container = new HashMap<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        int[] arr = new int[] {nums[i], nums[j], nums[k]};
                        Arrays.sort(arr);
                        if (!container.containsKey(Arrays.toString(arr))) {
                            List<Integer> item = new ArrayList<>();
                            for (int i1 : arr) {
                                item.add(i1);
                            }

                            container.put(Arrays.toString(arr), item);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(container.values());
    }

    /**
     * 排序+双指针解法：O(n^2)
     *
     * @param nums 数组
     * @return 数组列表
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) {
                break;
            }
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            int i = k + 1;
            int j = nums.length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum > 0) {
                    while (i < j && nums[j] == nums[--j]) {
                    }
                } else if (sum < 0) {
                    while (i < j && nums[i] == nums[++i]) {
                    }
                } else {
                    result.add(new ArrayList<>(Arrays.asList(nums[k], nums[i], nums[j])));
                    while (i < j && nums[j] == nums[--j]) {
                    }
                    while (i < j && nums[i] == nums[++i]) {
                    }
                }
            }
        }
        return result;
    }

}
