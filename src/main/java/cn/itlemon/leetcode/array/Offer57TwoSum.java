package cn.itlemon.leetcode.array;

/**
 * 剑指 Offer 57. 和为s的两个数字 https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-05-18
 */
public class Offer57TwoSum {

    /**
     * 双指针法：O(n)
     *
     * @param nums 数组
     * @param target 目标值
     * @return 两个数字组成的数组
     */
    public int[] twoSum(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum < target) {
                start++;
            } else if (sum > target) {
                end--;
            } else {
                return new int[] {nums[start], nums[end]};
            }
        }
        return new int[2];
    }

}
