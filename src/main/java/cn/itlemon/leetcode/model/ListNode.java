package cn.itlemon.leetcode.model;

/**
 * 单链表节点类型
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-04-17
 */
public class ListNode {

    /**
     * 值
     */
    public int val;

    /**
     * 链表下一个指针
     */
    public ListNode next;

    public ListNode() {}

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
