package cn.itlemon.leetcode.list;

import java.util.HashSet;
import java.util.Set;

import cn.itlemon.leetcode.model.ListNode;

/**
 * No.141 环形链表 https://leetcode-cn.com/problems/linked-list-cycle/
 *
 * @author jiangpingping <jiangpingping@kuaishou.com>
 * Created on 2021-05-27
 */
public class No141LinkedListCycle {

    /**
     * 龟兔赛跑法（快慢指针法）
     *
     * @param head 头节点
     * @return 是否有环
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * HashSet法
     *
     * @param head 头节点
     * @return 是否有环
     */
    public boolean hasCycle2(ListNode head) {
        Set<ListNode> container = new HashSet<>();
        while (head != null) {
            boolean addResult = container.add(head);
            if (!addResult) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

}
