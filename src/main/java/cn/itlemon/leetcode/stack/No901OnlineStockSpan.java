package cn.itlemon.leetcode.stack;

import java.util.Stack;

/**
 * No.901 股票价格跨度 https://leetcode-cn.com/problems/online-stock-span/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-06-12
 */
public class No901OnlineStockSpan {

    /**
     * 栈priceStack和widthStack分别用来记录元素和跨跨度
     */
    private final Stack<Integer> priceStack;
    private final Stack<Integer> widthStack;

    public No901OnlineStockSpan() {
        this.priceStack = new Stack<>();
        this.widthStack = new Stack<>();
    }

    public int next(int price) {
        // 跨度至少为1，就是自身，所以这里是1，如果不包含自身，那么这里就是0
        int width = 1;
        while (!priceStack.isEmpty() && priceStack.peek() <= price) {
            priceStack.pop();
            width += widthStack.pop();
        }
        priceStack.push(price);
        widthStack.push(width);
        return width;
    }
}
