package cn.itlemon.leetcode.dp;

/**
 * No.1137 第 N 个泰波那契数 https://leetcode-cn.com/problems/n-th-tribonacci-number/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-08-23
 */
public class No1137NthTribonacciNumber {

    /**
     * DP
     *
     * @param n 数值
     * @return 数值
     */
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        // 定义dp数组
        int[] dp = new int[n + 1];
        // base case
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }

    public int tribonacci2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        int prev1 = 0, prev2 = 1, curr = 1;
        for (int i = 3; i < n + 1; i++) {
            int sum = prev1 + prev2 + curr;
            prev1 = prev2;
            prev2 = curr;
            curr = sum;
        }
        return curr;
    }

}
