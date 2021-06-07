package cn.itlemon.leetcode.array;

/**
 * No.495 提莫攻击 https://leetcode-cn.com/problems/teemo-attacking/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-06-04
 */
public class No495TeemoAttacking {

    /**
     * 迭代法：O(n)
     *
     * @param timeSeries 时间序列组
     * @param duration 持续时间
     * @return 持续时长
     */
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) {
            return 0;
        }
        if (timeSeries.length == 1) {
            return duration;
        }
        // 考虑到最后一次中毒的是肯定是持续duration，所以这里提前算好
        int result = duration;
        for (int i = 1; i < timeSeries.length; i++) {
            result += Math.min(timeSeries[i] - timeSeries[i - 1], duration);
        }
        return result;
    }

}
