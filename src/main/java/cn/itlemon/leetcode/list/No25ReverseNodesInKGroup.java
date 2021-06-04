package cn.itlemon.leetcode.list;

import cn.itlemon.leetcode.model.ListNode;

/**
 * No.25 K 个一组翻转链表 https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-05-26
 */
public class No25ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        // 区间[a, b)包含K个待反转节点
        ListNode a = head;
        ListNode b = head;
        for (int i = 0; i < k; i++) {
            if (b == null) {
                // 不足K个，直接返回头节点，不进行反转
                return head;
            }
            b = b.next;
        }
        // 反转[a, b)之间的链表
        ListNode newHeadNode = reverse(a, b);
        // 原链表的head，也就是a的next将指向下一个反转的链表的新头节点
        a.next = reverseKGroup(b, k);
        return newHeadNode;
    }

    /**
     * 反转[a, b)的链表，当b=null的时候，就是反转整个链表
     *
     * @param a 头节点
     * @param b 尾节点（不含）
     * @return 反转后的链表
     */
    public ListNode reverse(ListNode a, ListNode b) {
        ListNode prev = null;
        ListNode curr = a;
        while (curr != b) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
