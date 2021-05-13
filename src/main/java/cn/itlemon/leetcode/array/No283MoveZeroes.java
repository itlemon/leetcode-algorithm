package cn.itlemon.leetcode.array;

/**
 * No.283 移动零 https://leetcode-cn.com/problems/move-zeroes/
 *
 * @author jiangpingping <jiangpingping@kuaishou.com>
 * Created on 2021-05-13
 */
public class No283MoveZeroes {

    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
    }

}
