package cn.itlemon.leetcode.list;

import cn.itlemon.leetcode.model.ListNode;

/**
 * No.2 两数相加 https://leetcode-cn.com/problems/add-two-numbers/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-05-23
 */
public class No2AddTwoNumbers {

    /**
     * 两个链表数值想加，时间复杂度：O(n)
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 链表head
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode head = null, tail = null;
        while (l1 != null || l2 != null || carry > 0) {
            int num1 = l1 != null ? l1.val : 0;
            int num2 = l2 != null ? l2.val : 0;
            int sum = num1 + num2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return head;
    }

}
