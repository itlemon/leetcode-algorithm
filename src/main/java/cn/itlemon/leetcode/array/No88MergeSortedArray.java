package cn.itlemon.leetcode.array;

import java.util.Arrays;

/**
 * No.88 合并两个有序数组 https://leetcode-cn.com/problems/merge-sorted-array/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-06-02
 */
public class No88MergeSortedArray {

    /**
     * 暴力法:O(nlogN)，复杂度在排序上
     *
     * @param nums1 数组1
     * @param m 元素个数
     * @param nums2 数组2
     * @param n 元素个数
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[i - m];
        }
        Arrays.sort(nums1);
    }

    /**
     * 后序遍历法：O(n)
     *
     * @param nums1 数组1
     * @param m 元素个数
     * @param nums2 数组2
     * @param n 元素个数
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        int first = m - 1;
        int second = n - 1;
        int i = 0;
        while (first >= 0 && second >= 0) {
            nums1[index - i] = nums1[first] > nums2[second] ? nums1[first--] : nums2[second--];
            i++;
        }
        while (second >= 0) {
            nums1[index - i] = nums2[second--];
            i++;
        }
    }

}
