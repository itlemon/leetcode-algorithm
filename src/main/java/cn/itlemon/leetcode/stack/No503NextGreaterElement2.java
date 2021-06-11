package cn.itlemon.leetcode.stack;

import java.util.Stack;

/**
 * No.503 下一个更大元素 II https://leetcode-cn.com/problems/next-greater-element-ii/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-06-10
 */
public class No503NextGreaterElement2 {

    /**
     * 环装数组常用的做法就是就是使用模的形式来模拟数组有环，实际是没有增加任何空间
     *
     * @param nums 数组
     * @return 数组
     */
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length * 2 - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i % nums.length] >= stack.peek()) {
                stack.pop();
            }
            result[i % nums.length] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i % nums.length]);
        }
        return result;
    }

}
