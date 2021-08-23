package cn.itlemon.leetcode.dp;

/**
 * No.1646 获取生成数组中的最大值 https://leetcode-cn.com/problems/get-maximum-in-generated-array/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-08-23
 */
public class No1646GetMaximumInGeneratedArray {

    /**
     * 动态规划
     *
     * @param n 数值
     * @return 最大值
     */
    public int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        }

        // 定义数组
        int[] nums = new int[n + 1];
        nums[1] = 1;
        // 定义结果
        int result = nums[1];

        for (int i = 2; i < n + 1; i++) {
            result = Math.max(result,
                    i % 2 == 0 ? (nums[i] = nums[i / 2]) : (nums[i] = nums[(i - 1) / 2] + nums[(i - 1) / 2 + 1]));
        }
        return result;
    }

}
