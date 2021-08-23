package cn.itlemon.leetcode.dp;

/**
 * No.509 斐波那契数 https://leetcode-cn.com/problems/fibonacci-number/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-08-23
 */
public class No509FibonacciNumber {

    /**
     * 纯暴力解法：O(2^n)，耗时8ms
     *
     * @param n 数值
     * @return 数值
     */
    public int fib(int n) {
        // 终止条件
        if (n == 0 || n == 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    /**
     * 带备忘录解法
     *
     * @param n 数值
     * @return 数值
     */
    public int fib2(int n) {
        if (n < 1) {
            return 0;
        }

        // 定义备忘录，默认值都为0
        int[] memo = new int[n + 1];
        return helper(memo, n);
    }

    private int helper(int[] memo, int n) {
        // base case
        if (n == 1 || n == 2) {
            return 1;
        }

        // 从备忘录中取已经计算过的值
        if (memo[n] != 0) {
            return memo[n];
        }

        // 计算并存储备忘录
        memo[n] = helper(memo, n - 1) + helper(memo, n - 2);
        return memo[n];
    }

    /**
     * DP
     *
     * @param n 数值
     * @return 数值
     */
    public int fib3(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        // 定义dp数组
        int[] dp = new int[n + 1];

        // base case
        dp[1] = 1;
        dp[2] = 1;

        // 递推遍历
        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // 返回结果
        return dp[n];
    }

    /**
     * 优化后的DP
     *
     * @param n 数值
     * @return 数值
     */
    public int fib4(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int prev = 1, curr = 1;
        for (int i = 3; i < n + 1; i++) {
            int sum = prev + curr;
            prev = curr;
            curr = sum;
        }

        return curr;
    }

}
