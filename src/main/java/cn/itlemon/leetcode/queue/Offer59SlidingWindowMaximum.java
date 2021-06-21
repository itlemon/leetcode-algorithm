package cn.itlemon.leetcode.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer 59 - I. 滑动窗口的最大值 https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-06-20
 */
public class Offer59SlidingWindowMaximum {

    /**
     * 滑动窗口
     *
     * @param nums 数组
     * @param k k值
     * @return 最大值组成的数组
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue monotonicQueue = new MonotonicQueue();
        List<Integer> tempList = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                monotonicQueue.push(nums[i]);
            } else {
                monotonicQueue.push(nums[i]);
                tempList.add(monotonicQueue.max());
                monotonicQueue.pop(nums[i - k + 1]);
            }
        }
        // 将List转换成数组
        int[] result = new int[tempList.size()];
        for (int i = 0; i < tempList.size(); i++) {
            result[i] = tempList.get(i);
        }
        return result;
    }

    /**
     * 单调队列
     */
    class MonotonicQueue {

        LinkedList<Integer> queue = new LinkedList<>();

        /**
         * 向队尾添加元素
         *
         * @param n 元素
         */
        public void push(int n) {
            while (!queue.isEmpty() && queue.getLast() < n) {
                queue.pollLast();
            }
            queue.addLast(n);
        }

        /**
         * 取队列中最大值
         *
         * @return 最大值
         */
        public int max() {
            return queue.getFirst();
        }

        /**
         * 从队头移除指定值，如果队头不是该值，则不作任何操作
         *
         * @param n 指定值
         */
        public void pop(int n) {
            if (n == queue.getFirst()) {
                queue.pollFirst();
            }
        }
    }

}
