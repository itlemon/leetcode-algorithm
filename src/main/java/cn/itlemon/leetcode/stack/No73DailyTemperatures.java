package cn.itlemon.leetcode.stack;

import java.util.Stack;

/**
 * No.739 每日温度 https://leetcode-cn.com/problems/daily-temperatures/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-06-09
 */
public class No73DailyTemperatures {

    /**
     * 单调栈：O(n)
     *
     * @param temperatures 温度数组
     * @return 数组
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();
            }
            // 求取距离就是两索引的差
            result[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            // 存储当前元素的索引
            stack.push(i);
        }
        return result;
    }
}
