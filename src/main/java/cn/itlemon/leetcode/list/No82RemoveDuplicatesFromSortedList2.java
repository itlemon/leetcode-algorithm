package cn.itlemon.leetcode.list;

import java.util.HashSet;
import java.util.Set;

import cn.itlemon.leetcode.model.ListNode;

/**
 * No.82 删除排序链表中的重复元素 II https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-06-05
 */
public class No82RemoveDuplicatesFromSortedList2 {

    private final Set<Integer> duplicateInteger = new HashSet<>();

    /**
     * 删除所有重复的链表元素
     *
     * @param head 头节点
     * @return 符合要求的链表
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = deleteDuplicates2(head);
        if (newHead == null) {
            return null;
        }
        ListNode dummyNode = new ListNode(0, newHead);
        ListNode curr = dummyNode;
        while (curr.next != null) {
            if (duplicateInteger.contains(curr.next.val)) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return dummyNode.next;
    }

    /**
     * 删除排序链表中的重复元素 [1,2,2,3,4,5,5,6] ===> [1,2,3,4,5,6]
     *
     * @param head 头节点
     * @return 不重复的链表
     */
    private ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
                duplicateInteger.add(cur.val);
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    /**
     * 删除排序链表中的重复元素 [1,2,2,3,4,5,5,6] ===> [1,3,4,6]
     *
     * @param head 头节点
     * @return 不重复的链表
     */
    public ListNode deleteDuplicates3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyNode = new ListNode(0, head);
        ListNode curr = dummyNode;
        while (curr.next != null && curr.next.next != null) {
            if (curr.next.val == curr.next.next.val) {
                int value = curr.next.val;
                while (curr.next != null && curr.next.val == value) {
                    curr.next = curr.next.next;
                }
            } else {
                curr = curr.next;
            }
        }
        return dummyNode.next;
    }

}
