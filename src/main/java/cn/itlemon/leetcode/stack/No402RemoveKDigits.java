package cn.itlemon.leetcode.stack;

import java.util.Stack;

/**
 * No.402 移掉K位数字 https://leetcode-cn.com/problems/remove-k-digits/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-06-13
 */
public class No402RemoveKDigits {

    /**
     * 移除字符串中K个数字
     *
     * @param num 数字字符串例如1432219
     * @param k 移除K个数字
     * @return 最小数字
     */
    public String removeKdigits(String num, int k) {
        // 处理特殊情况
        if (k == num.length()) {
            return "0";
        }
        // 使用单调栈思想来解题
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            while (k > 0 && !stack.isEmpty() && num.charAt(i) < stack.peek()) {
                stack.pop();
                k--;
            }
            // 这里做一个特殊处理，防止首位为0的入栈
            if (num.charAt(i) != '0' || !stack.isEmpty()) {
                stack.push(num.charAt(i));
            }
        }
        // 如果没有完成所有K个数字的移除，那么直接移除低位数，因为出现没有移除完的情况是因为一直再递增
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }
        return stack.isEmpty() ? "0" : stack2String(stack);
    }

    /**
     * 将一个不为空的stack内的元素转换成字符串
     *
     * @param stack 栈
     * @return 字符串
     */
    private String stack2String(Stack<Character> stack) {
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        return result.toString();
    }

}
