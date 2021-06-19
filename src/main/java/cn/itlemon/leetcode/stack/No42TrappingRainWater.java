package cn.itlemon.leetcode.stack;

import java.util.Stack;

/**
 * No.42 接雨水 https://leetcode-cn.com/problems/trapping-rain-water/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-06-19
 */
public class No42TrappingRainWater {

    /**
     * 单调栈：O(n)
     *
     * @param height 高度数组
     * @return 雨水面积
     */
    public int trap(int[] height) {
        // 对于数组个数为0，1，2均无法接到雨水，所以为0
        if (height.length == 0 || height.length == 1 || height.length == 2) {
            return 0;
        }
        // 构建单调递减栈
        Stack<Integer> stack = new Stack<>();
        // 记录雨水面积
        int rainWaterArea = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int currentIndex = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                // 获取左边界需要使用peek，而不能使用pop，这是因为需要一层一层计算雨水面积
                int leftIndex = stack.peek();
                int currentHeight = Math.min(height[leftIndex], height[i]) - height[currentIndex];
                rainWaterArea += currentHeight * (i - leftIndex - 1);
            }
            stack.push(i);
        }
        return rainWaterArea;
    }

}
