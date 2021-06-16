package cn.itlemon.leetcode.stack;

import java.util.Arrays;

/**
 * No.581 最短无序连续子数组 https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-06-15
 */
public class No581ShortestUnsortedContinuousSubarray {

    /**
     * 排序算法
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

}
