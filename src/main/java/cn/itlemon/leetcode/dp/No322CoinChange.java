package cn.itlemon.leetcode.dp;

/**
 * No.322 零钱兑换 https://leetcode-cn.com/problems/coin-change/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-08-23
 */
public class No322CoinChange {

    /**
     * 暴力递归，自顶向下
     *
     * @param coins 面值
     * @param amount 总金额
     * @return 最少硬币个数
     */
    public int coinChange(int[] coins, int amount) {
        // base case
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }

        // 定义结果
        int result = Integer.MAX_VALUE;

        // 递归
        for (int coin : coins) {
            // 子问题
            int sub = coinChange(coins, amount - coin);
            if (sub == -1) {
                continue;
            }
            result = Math.min(result, sub + 1);
        }

        // 返回结果
        return result == Integer.MAX_VALUE ? -1 : result;
    }

}
