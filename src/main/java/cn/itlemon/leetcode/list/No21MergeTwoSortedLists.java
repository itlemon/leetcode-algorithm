package cn.itlemon.leetcode.list;

import cn.itlemon.leetcode.model.ListNode;

/**
 * No.21 合并两个有序链表 https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-06-01
 */
public class No21MergeTwoSortedLists {

    /**
     * 递归法：O(n)
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 合并后的链表
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

}
