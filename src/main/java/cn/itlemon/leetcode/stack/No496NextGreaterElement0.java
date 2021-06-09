package cn.itlemon.leetcode.stack;

import java.util.Stack;

/**
 * No.496 下一个更大元素 I 的基础题，来自labuladong的算法小抄
 * 比如输入一个数组[2,1,2,4,3]，算法返回[4,2,4,-1,-1]
 * 解释：第一个2后面比2大的是4；1后面比1大的是2；第二个2后面比2大的是4；4后面没有比4大的；3后面也没有比3大的
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-06-09
 */
public class No496NextGreaterElement0 {

    /**
     * 这就是单调队列题目的集体模板，for循环要从后面往前扫描元素，因为我们借助的是栈的元素，倒着入栈，其实就是正着出栈
     * 这个时间复杂度是O(n)，因为每个元素只遍历异常，while循环里面并没有对数组有遍历，仅仅是为了弹栈
     *
     * @param nums 数组
     * @return 数组
     */
    public int[] nextGreaterElement(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] >= stack.peek()) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return result;
    }

}
