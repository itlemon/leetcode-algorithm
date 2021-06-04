package cn.itlemon.leetcode.list;

import cn.itlemon.leetcode.model.ListNode;

/**
 * No.61 旋转链表 https://leetcode-cn.com/problems/rotate-list/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-06-04
 */
public class No61RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        // k得出的结果是[0, length - 1]之间的值
        k %= length;
        if (k == 0) {
            return head;
        } else {
            // 这里计算出来的是新头节点的索引，从1开始
            int index = length - k + 1;
            int count = 0;
            temp = head;
            ListNode newHead = null;
            while (temp != null) {
                if (++count + 1 == index) {
                    newHead = temp.next;
                    temp.next = null;
                    temp = newHead;
                } else {
                    if (temp.next == null) {
                        temp.next = head;
                        break;
                    }
                    temp = temp.next;
                }
            }
            return newHead;
        }
    }

}
