package cn.itlemon.leetcode.array;

/**
 * No.189 旋转数组 https://leetcode-cn.com/problems/rotate-array/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-05-30
 */
public class No189RotateArray {

    /**
     * 暴力解法:O(n^2)
     *
     * @param nums 数组
     * @param k K值
     */
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        for (int i = 0; i < k; i++) {
            int temp = nums[nums.length - 1];
            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }

    /**
     * 数组反转：O(n)
     * @param nums 数组
     * @param k K值
     */
    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        // 全局反转
        reverse(nums, 0, nums.length - 1);
        // 再反转前k个元素
        reverse(nums, 0, k - 1);
        // 再反转后nums.length - k个元素
        reverse(nums, k, nums.length - 1);
    }

    /**
     * 数组反转
     *
     * @param nums 数组
     * @param start 开始位置
     * @param end 结束位置
     */
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

}
