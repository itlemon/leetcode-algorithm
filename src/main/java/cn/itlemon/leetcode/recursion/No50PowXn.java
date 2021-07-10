package cn.itlemon.leetcode.recursion;

/**
 * No.50 Pow(x, n) https://leetcode-cn.com/problems/powx-n/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-07-10
 */
public class No50PowXn {

    /**
     * 分治算法：O(logn)
     *
     * @param x x值
     * @param n 次幂
     * @return 结果
     */
    public double myPow(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return n == 0 ? 1.0 : fastPow(x , n);
    }

    private double fastPow(double x, int n) {
        // 递归终止条件
        if (n == 0) {
            return 1.0;
        }
        // 递归过程
        double subResult = fastPow(x, n / 2);
        // 处理本层的内容
        return n % 2 == 0 ? subResult * subResult : subResult * subResult * x;
    }

}
