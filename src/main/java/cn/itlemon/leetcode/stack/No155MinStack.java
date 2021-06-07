package cn.itlemon.leetcode.stack;

import java.util.Stack;

/**
 * No.155 最小栈 https://leetcode-cn.com/problems/min-stack/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-06-06
 */
public class No155MinStack {

    Stack<Integer> dataStack;

    /**
     * 最小值辅助栈
     */
    Stack<Integer> minDataStack;

    /**
     * initialize your data structure here.
     */
    public No155MinStack() {
        dataStack = new Stack<>();
        minDataStack = new Stack<>();
        minDataStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        dataStack.push(val);
        minDataStack.push(Math.min(minDataStack.peek(), val));
    }

    public void pop() {
        dataStack.pop();
        minDataStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minDataStack.peek();
    }

}
