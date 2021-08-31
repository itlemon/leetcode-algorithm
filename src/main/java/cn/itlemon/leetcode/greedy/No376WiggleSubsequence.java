package cn.itlemon.leetcode.greedy;

/**
 * No.376 摆动序列 https://leetcode-cn.com/problems/wiggle-subsequence/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-08-28
 */
public class No376WiggleSubsequence {

    /**
     * 记录起伏
     *
     * @param nums 原始数组
     * @return 最长摆动子数组长度
     */
    public int wiggleMaxLength(int[] nums) {
        int length = nums.length;
        // 长度小于等于1（等于2的还不能确定，因为有可能两个元素一样）的数组直接就是摆动数组
        if (length <= 1) {
            return length;
        }

        // 定义遍历记录起伏：asc上升，desc下降
        int asc = 1;
        int desc = 1;
        for (int i = 1; i < length; i++) {
            // 记录上升
            if (nums[i] > nums[i - 1]) {
                asc = desc + 1;
            }
            // 记录下降
            if (nums[i] < nums[i - 1]) {
                desc = asc + 1;
            }
            // 这里直接舍弃相等的情况
        }

        return Math.max(asc, desc);
    }

    /**
     * 贪心算法：删除单调递增或者递减路径上的点，保留路径上两个端点
     *
     * @param nums 数组
     * @return 最长摆动子数组长度
     */
    public int wiggleMaxLength2(int[] nums) {
        int length = nums.length;
        // 长度小于等于1（等于2的还不能确定，因为有可能两个元素一样）的数组直接就是摆动数组
        if (length <= 1) {
            return length;
        }

        // 定义当前差值和前一对差值
        int currDiff = 0;
        int preDiff = 0;
        // 定义结果，记录峰值个数，默认序列最右侧有一个峰值
        int result = 1;
        for (int i = 0; i < length - 1; i++) {
            currDiff = nums[i + 1] - nums[i];
            if ((currDiff > 0 && preDiff <= 0) || (currDiff < 0 && preDiff >= 0)) {
                // 出现峰值
                result++;
                preDiff = currDiff;
            }
        }

        return result;
    }

}
