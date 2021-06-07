package cn.itlemon.leetcode.list;

import cn.itlemon.leetcode.model.ListNode;

/**
 * No.83 删除排序链表中的重复元素 https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-06-05
 */
public class No83RemoveDuplicatesFromSortedList {

    /**
     * 递归法
     *
     * @param head 头节点
     * @return 处理后的节点
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        head.next = deleteDuplicates(head.next);
        if (head.val == head.next.val) {
            head.next = head.next.next;
        }
        return head;
    }

    /**
     * 迭代法：O(n)
     *
     * @param head 头节点
     * @return 处理后的节点
     */
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

}
