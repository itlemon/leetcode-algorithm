package cn.itlemon.leetcode.dp;

import java.util.HashMap;
import java.util.Map;

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

    /**
     * 备忘录，自顶向下
     *
     * @param coins 面值
     * @param amount 总金额
     * @return 最少硬币个数
     */
    public int coinChange2(int[] coins, int amount) {
        // 定义备忘录
        Map<Integer, Integer> memo = new HashMap<>();
        return helper(coins, amount, memo);
    }

    private int helper(int[] coins, int amount, Map<Integer, Integer> memo) {
        // base case
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }

        // 查看备忘录
        if (memo.get(amount) != null) {
            return memo.get(amount);
        }

        // 定义结果
        int result = Integer.MAX_VALUE;

        for (int coin : coins) {
            int sub = helper(coins, amount - coin, memo);
            if (sub == -1) {
                continue;
            }
            result = Math.min(result, sub + 1);
        }

        // 计入到备忘录中
        memo.put(amount, result == Integer.MAX_VALUE ? -1 : result);
        return memo.get(amount);
    }

    /**
     * DP
     *
     * @param coins 面值
     * @param amount 总金额
     * @return 最少硬币个数
     */
    public int coinChange3(int[] coins, int amount) {
        // 定义dp数组，索引为0 ~ amount，值为最少硬币个数
        int[] dp = new int[amount + 1];
        for (int i = 1; i < dp.length; i++) {
            // 这里除0索引外，其他的值都设置为amount + 1，这已经是最大值了，无需设置Integer.MAX_VALUE
            dp[i] = amount + 1;
        }
        // base case就是dp[0] = 0
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

}
