package cn.itlemon.leetcode.array;

/**
 * No.26 删除有序数组中的重复项 https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-05-29
 */
public class No26RemoveDuplicatesFromSortedArray {

    /**
     * 迭代法：O(n)
     *
     * @param nums 数组
     * @return 不重复数组长度
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[index] != nums[i]) {
                index++;
                nums[index] = nums[i];
            }
        }
        return index + 1;
    }

}
