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

}
