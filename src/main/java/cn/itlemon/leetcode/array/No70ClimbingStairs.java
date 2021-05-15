package cn.itlemon.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * No.70 爬楼梯 https://leetcode-cn.com/problems/climbing-stairs/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-05-15
 */
public class No70ClimbingStairs {

    /**
     * 递归法：O(2^n)
     *
     * @param n 楼梯数
     * @return 爬楼梯的种数
     */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * 记忆递归法使用的备忘录
     */
    private final Map<Integer, Integer> memo = new HashMap<>();

    /**
     * 记忆递归法：O(n)，自顶向下
     *
     * @param n 楼梯数
     * @return 爬楼梯的种数
     */
    public int climbStairs2(int n) {
        if (n <= 2) {
            return n;
        }
        // 先看有没有计算过，也就是备忘录中是否包含当前需要计算的值
        if (memo.containsKey(n)) {
            return memo.get(n);
        } else {
            // 备忘录中没有，那么直接递归计算并进行备忘录存储
            memo.put(n, climbStairs2(n - 1) + climbStairs2(n - 2));
            return memo.get(n);
        }
    }

    /**
     * 动态规划做法：O(n)
     *
     * @param n 楼梯数
     * @return 爬楼梯的种数
     */
    public int climbStairs3(int n) {
        // 初始值
        if (n <= 2) {
            return n;
        }
        // f2 = f(i-2)
        int f2 = 1;
        // f1 = f(i-1)
        int f1 = 2;
        int res = 0;
        for (int i = 2; i < n; i++) {
            // 状态转移方程式:f(i)=f(i-1)+f(i-2)
            res = f1 + f2;
            // 保存下一轮 f(i-1) 和 f(i-2) 的值,重复利用
            f2 = f1;
            f1 = res;
        }
        return res;
    }

    /**
     * 人才解法，当n为46的时候，解的结果超过了int的最大值，审题可以这么做，一个字：绝~
     *
     * @param n 楼梯数
     * @return 爬楼梯的种数
     */
    public int climbStairs4(int n) {
        int result = 0;
        switch (n) {
            case 1:
                result = 1;
                break;
            case 2:
                result = 2;
                break;
            case 3:
                result = 3;
                break;
            case 4:
                result = 5;
                break;
            case 5:
                result = 8;
                break;
            case 6:
                result = 13;
                break;
            case 7:
                result = 21;
                break;
            case 8:
                result = 34;
                break;
            case 9:
                result = 55;
                break;
            case 10:
                result = 89;
                break;
            case 11:
                result = 144;
                break;
            case 12:
                result = 233;
                break;
            case 13:
                result = 377;
                break;
            case 14:
                result = 610;
                break;
            case 15:
                result = 987;
                break;
            case 16:
                result = 1597;
                break;
            case 17:
                result = 2584;
                break;
            case 18:
                result = 4181;
                break;
            case 19:
                result = 6765;
                break;
            case 20:
                result = 10946;
                break;
            case 21:
                result = 17711;
                break;
            case 22:
                result = 28657;
                break;
            case 23:
                result = 46368;
                break;
            case 24:
                result = 75025;
                break;
            case 25:
                result = 121393;
                break;
            case 26:
                result = 196418;
                break;
            case 27:
                result = 317811;
                break;
            case 28:
                result = 514229;
                break;
            case 29:
                result = 832040;
                break;
            case 30:
                result = 1346269;
                break;
            case 31:
                result = 2178309;
                break;
            case 32:
                result = 3524578;
                break;
            case 33:
                result = 5702887;
                break;
            case 34:
                result = 9227465;
                break;
            case 35:
                result = 14930352;
                break;
            case 36:
                result = 24157817;
                break;
            case 37:
                result = 39088169;
                break;
            case 38:
                result = 63245986;
                break;
            case 39:
                result = 102334155;
                break;
            case 40:
                result = 165580141;
                break;
            case 41:
                result = 267914296;
                break;
            case 42:
                result = 433494437;
                break;
            case 43:
                result = 701408733;
                break;
            case 44:
                result = 1134903170;
                break;
            case 45:
                result = 1836311903;
                break;
            default:
        }
        return result;
    }

}
