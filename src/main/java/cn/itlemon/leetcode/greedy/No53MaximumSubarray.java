package cn.itlemon.leetcode.greedy;

/**
 * No.53 最大子序和 https://leetcode-cn.com/problems/maximum-subarray/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-08-31
 */
public class No53MaximumSubarray {

    /**
     * 暴力解法：O(2^n)
     *
     * @param nums 数组
     * @return 最大子序和
     */
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                result = Math.max(sum, result);
            }
        }
        return result;
    }

    /**
     * 贪心算法：O(n)
     *
     * @param nums 数组
     * @return 最大子序和
     */
    public int maxSubArray2(int[] nums) {
        int result = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            result = Math.max(result, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return result;
    }

}
