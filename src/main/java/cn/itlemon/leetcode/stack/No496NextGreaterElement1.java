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
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
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

    /**
     * 使用map记录nums2中每个元素和下一个更大元素的关系：O(n)
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 数组
     */
    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        // 设置一个Map来存储nums2中每个元素和它下一个更大元素的关系
        Map<Integer, Integer> map = new HashMap<>((int) (nums2.length / 0.75) + 1);
        Stack<Integer> stack = new Stack<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                stack.pop();
            }
            // 使用map将nums2中的每个元素与其下一个更大元素关联起来
            map.put(nums2[i], stack.isEmpty() ? -1 : stack.peek());
            stack.push(nums2[i]);
        }
        // 遍历nums1，下一个更大元素
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.get(nums1[i]);
        }
        return nums1;
    }
}
