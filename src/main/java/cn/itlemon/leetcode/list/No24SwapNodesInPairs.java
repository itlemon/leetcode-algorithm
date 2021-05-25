package cn.itlemon.leetcode.list;

import cn.itlemon.leetcode.model.ListNode;

/**
 * No.24 两两交换链表中的节点 https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-05-23
 */
public class No24SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        return reverseKGroup(head, 2);
    }

    public ListNode swapPairs2(ListNode head) {
        // 终止条件
        if (head == null || head.next == null) {
            return head;
        }
        // 反转当前的节点
        ListNode next = head.next;
        head.next = swapPairs2(next.next);
        next.next = head;
        return next;
    }

    /**
     * 以K个节点为一组反转链表，不足K个的保持原有
     *
     * @param head 头节点
     * @param k 数字K
     * @return 反转后的链表
     */
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
     * 反转指定区间的[head, tail)之间的链表，灵感来源于反转整个链表，反转整个链表就是反转指定区间[head, null)之间的链表
     *
     * @param head 头节点
     * @param tail 尾节点（不含）
     * @return 反转后的链表
     */
    public ListNode reverse(ListNode head, ListNode tail) {
        ListNode prev = null;
        ListNode curr = head;
        // 当tail=null的时候，就是反转整个链表
        while (curr != tail) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

}
