package cn.itlemon.leetcode.list;

import cn.itlemon.leetcode.model.ListNode;

/**
 * 反转链表系列：使用递归方法来解决链表反转问题
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-05-23
 */
public class No1ReverseLinkedListSeries {

    /**
     * No.206 反转链表 https://leetcode-cn.com/problems/reverse-linked-list/
     *
     * @param head 头节点
     * @return 反转后的链表
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    /**
     * 用tail变量记录n+1往后的节点
     */
    ListNode tail = null;

    /**
     * 反转链表前N个节点，当n等于链表节点个数的时候，就转化为了反转整个链表的问题
     *
     * @param head 头节点
     * @param n 前n个节点
     * @return 反转后的链表
     */
    public ListNode reversePreNList(ListNode head, int n) {
        if (n == 1) {
            // base case
            tail = head.next;
            return head;
        }
        ListNode last = reversePreNList(head.next, n - 1);
        head.next.next = head;
        head.next = tail;
        return last;
    }

    /**
     * No.92 反转链表 II https://leetcode-cn.com/problems/reverse-linked-list-ii/
     * 反转指定区间[m, n]（索引从1开始）的链表节点
     * 如果m=1，就转换为了反转前N个节点的问题：{@link No1ReverseLinkedListSeries#reversePreNList(ListNode, int)}
     * 如果m=1，n等于链表长度，那么问题就转化为了反转整个链表的问题 {@link No1ReverseLinkedListSeries#reverseList(ListNode)}
     *
     * @param head 头节点
     * @param m m，开始节点索引
     * @param n n，结束节点索引
     * @return 反转后的链表
     */
    public ListNode reverseBetweenList(ListNode head, int m, int n) {
        // base case
        if (m == 1) {
            // 转换为反转前N个节点的问题
            return reversePreNList(head, n);
        }
        head.next = reverseBetweenList(head.next, m - 1, n - 1);
        return head;
    }

}
