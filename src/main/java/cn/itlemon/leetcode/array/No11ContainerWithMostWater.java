package cn.itlemon.leetcode.array;

/**
 * No.11 盛最多水的容器 https://leetcode-cn.com/problems/container-with-most-water/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-05-15
 */
public class No11ContainerWithMostWater {

    /**
     * 暴力法，O(n^2)
     *
     * @param height 数组
     * @return 最大值
     */
    public int maxArea(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return max;
    }

    /**
     * 双指针法
     *
     * @param height 数组
     * @return 最大值
     */
    public int maxArea2(int[] height) {
        int max = 0;
        for (int i = 0, j = height.length - 1; i < j; ) {
            max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }

    public int maxArea3(int[] height) {
        int max = 0, start = 0, end = height.length - 1;
        while (start < end) {
            max = Math.max(max, Math.min(height[start], height[end]) * (end - start));
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return max;
    }

    /**
     * 当同时遇见相等高度的时候，两个指针同时移动
     *
     * @param height 数组
     * @return 最大值
     */
    public int maxArea4(int[] height) {
        int max = 0, start = 0, end = height.length - 1;
        while (start < end) {
            max = Math.max(max, Math.min(height[start], height[end]) * (end - start));
            if (height[start] < height[end]) {
                start++;
            } else if (height[start] > height[end]) {
                end--;
            } else {
                start++;
                end--;
            }
        }
        return max;
    }

}
