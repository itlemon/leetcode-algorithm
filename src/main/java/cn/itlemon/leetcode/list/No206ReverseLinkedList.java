package cn.itlemon.leetcode.list;

import java.util.Stack;

import cn.itlemon.leetcode.model.ListNode;

/**
 * No.206 反转链表 https://leetcode-cn.com/problems/reverse-linked-list/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-05-20
 */
public class No206ReverseLinkedList {

    /**
     * 迭代法：O(n)
     *
     * @param head 头节点
     * @return 反转后的链表
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /**
     * 栈：
     *
     * @param head 头节点
     * @return 反转后的链表
     */
    public ListNode reverseList2(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }
        ListNode result = new ListNode();
        ListNode node = result;
        while (!stack.isEmpty()) {
            node.next = stack.pop();
            if (!stack.isEmpty()) {
                node = node.next;
            } else {
                node.next.next = null;
            }
        }
        return result.next;
    }

    /**
     * 递归法
     *
     * @param head 头节点
     * @return 反转后的链表
     */
    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverseList3(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

}
