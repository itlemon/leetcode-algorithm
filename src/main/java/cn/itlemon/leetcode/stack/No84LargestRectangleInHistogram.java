package cn.itlemon.leetcode.stack;

import java.util.Stack;

/**
 * No.84 柱状图中最大的矩形 https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-06-07
 */
public class No84LargestRectangleInHistogram {

    /**
     * 暴力解法：O(n^2)，超出时间限制，固定高度，找到左右边界，它的边界是左右遇见的第一个比它矮的柱子
     *
     * @param heights 高度数组
     * @return 面积
     */
    public int largestRectangleArea(int[] heights) {
        int area = 0;
        for (int i = 0; i < heights.length; i++) {
            int left = i;
            int right = i;
            int height = heights[i];
            while (left > 0 && heights[left - 1] >= height) {
                left--;
            }
            while (right < heights.length - 1 && heights[right + 1] >= height) {
                right++;
            }
            area = Math.max(height * (right - left + 1), area);
        }
        return area;
    }

    /**
     * 单调栈+哨兵解法：O(n)
     *
     * @param heights 高度数组
     * @return 最大面积
     */
    public int largestRectangleArea2(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        if (heights.length == 1) {
            return heights[0];
        }
        // 面积
        int area = 0;
        // 添加哨兵:数组两端各加上一个为0的元素
        int[] newHeights = new int[heights.length + 2];
        System.arraycopy(heights, 0, newHeights, 1, heights.length);
        newHeights[0] = 0;
        newHeights[heights.length + 1] = 0;
        heights = newHeights;

        // 单调栈
        Stack<Integer> stack = new Stack<>();
        // 加入哨兵，stack中就无需做非空判断，因为0索引对应的高度为0，肯定是数组中最小的
        stack.push(0);
        for (int i = 1; i < heights.length; i++) {
            while (heights[i] < heights[stack.peek()]) {
                int currentHeight = heights[stack.pop()];
                int currentWight = i - stack.peek() - 1;
                area = Math.max(area, currentHeight * currentWight);
            }
            stack.push(i);
        }
        return area;
    }

}
