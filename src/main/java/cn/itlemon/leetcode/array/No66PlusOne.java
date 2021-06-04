package cn.itlemon.leetcode.array;

/**
 * No.66 加一 https://leetcode-cn.com/problems/plus-one/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-06-04
 */
public class No66PlusOne {

    /**
     * 迭代法：O(n)
     *
     * @param digits 数组
     * @return 加一后的数组
     */
    public int[] plusOne(int[] digits) {
        int index = digits.length - 1;
        while (index >= 0) {
            if (digits[index] == 9) {
                digits[index--] = 0;
            } else {
                digits[index] = digits[index] + 1;
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

}
