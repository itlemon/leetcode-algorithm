package cn.itlemon.leetcode.stack;

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
            while (left >= 0 && heights[left] >= height) {
                left--;
            }
            while (right <= heights.length - 1 && heights[right] >= height) {
                right++;
            }
            area = Math.max(height * (right - left - 1), area);
        }
        return area;
    }

}
