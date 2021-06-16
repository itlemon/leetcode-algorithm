package cn.itlemon.leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * No.581 最短无序连续子数组 https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-06-15
 */
public class No581ShortestUnsortedContinuousSubarray {

    /**
     * 排序+双指针算法：O(nlogn)
     *
     * @param nums 数组
     * @return 最短无序连续子数组长度
     */
    public int findUnsortedSubarray(int[] nums) {
        int[] nums2 = nums.clone();
        Arrays.sort(nums2);
        int start = nums2.length;
        int end = 0;
        for (int i = 0; i < nums2.length; i++) {
            if (nums[i] != nums2[i]) {
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        return end - start >= 0 ? end - start + 1 : 0;
    }

    /**
     * 单调栈解法：O(n)
     *
     * @param nums 数组
     * @return 最短无序连续子数组长度
     */
    public int findUnsortedSubarray2(int[] nums) {
        int left = nums.length - 1;
        int right = 0;
        // 单调递增栈
        Stack<Integer> incrementalStack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!incrementalStack.isEmpty() && nums[incrementalStack.peek()] > nums[i]) {
                left = Math.min(left, incrementalStack.pop());
            }
            incrementalStack.push(i);
        }
        // 单调递减栈
        Stack<Integer> decreasingStack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!decreasingStack.isEmpty() && nums[decreasingStack.peek()] < nums[i]) {
                right = Math.max(right, decreasingStack.pop());
            }
            decreasingStack.push(i);
        }
        return right > left ? right - left + 1 : 0;
    }

}
