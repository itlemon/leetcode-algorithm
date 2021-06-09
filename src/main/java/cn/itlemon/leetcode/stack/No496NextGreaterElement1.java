package cn.itlemon.leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * No.496 下一个更大元素 I https://leetcode-cn.com/problems/next-greater-element-i/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-06-09
 */
public class No496NextGreaterElement1 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // 记录num2的值和键的关系
        Map<Integer, Integer> map = new HashMap<>((int) (nums2.length / 0.75) + 1);
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }
        int[] index = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            index[i] = map.get(nums1[i]);
        }
        Stack<Integer> stack = new Stack<>();
        int[] temp = new int[nums2.length];
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums2[i] >= stack.peek()) {
                stack.pop();
            }
            temp[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums2[i]);
        }
        // 将index的每个元素作为索引去获取temp中的值
        for (int i = 0; i < index.length; i++) {
            index[i] = temp[index[i]];
        }
        return index;
    }
}
