package cn.itlemon.leetcode.list;

import java.util.List;
import java.util.Stack;

import cn.itlemon.leetcode.model.ListNode;

/**
 * No.445 两数相加II https://leetcode-cn.com/problems/add-two-numbers-ii/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-05-19
 */
public class No455AddTwoNumbersII {

    /**
     * 使用栈的方式做
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 链表
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stackForL1 = new Stack<>();
        Stack<Integer> stackForL2 = new Stack<>();
        Stack<Integer> stackForResult = new Stack<>();
        while (l1 != null) {
            stackForL1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stackForL2.push(l2.val);
            l2 = l2.next;
        }
        int sizeForL1 = stackForL1.size();
        int sizeForL2 = stackForL2.size();
        // 是否进1的标识
        boolean flag = false;
        while (true) {
            int itemForL1 = 0;
            if (!stackForL1.isEmpty()) {
                itemForL1 = stackForL1.pop();
            }
            int itemForL2 = 0;
            if (!stackForL2.isEmpty()) {
                itemForL2 = stackForL2.pop();
            }
            if (sizeForL1 > 0 || sizeForL2 > 0) {
                int sum = itemForL1 + itemForL2;
                if (flag) {
                    sum += 1;
                }
                if (sum / 10 == 1) {
                    stackForResult.push(sum - 10);
                    flag = true;
                } else {
                    stackForResult.push(sum);
                    flag = false;
                }
                sizeForL1--;
                sizeForL2--;
            } else if (flag) {
                stackForResult.push(1);
                flag = false;
            } else {
                break;
            }
        }
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while (!stackForResult.isEmpty()) {
            temp.next = new ListNode(stackForResult.pop());
            temp = temp.next;
        }
        return head.next;
    }

    /**
     * 使用栈的方式做
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 链表
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Stack<Integer> stackForL1 = new Stack<>();
        Stack<Integer> stackForL2 = new Stack<>();
        while (l1 != null) {
            stackForL1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stackForL2.push(l2.val);
            l2 = l2.next;
        }
        ListNode head = null;
        int carry = 0;
        while (!stackForL1.isEmpty() || !stackForL2.isEmpty() || carry > 0) {
            int num1 = stackForL1.isEmpty() ? 0 : stackForL1.pop();
            int num2 = stackForL2.isEmpty() ? 0 : stackForL2.pop();
            int sum = num1 + num2 + carry;
            ListNode curr = new ListNode(sum % 10);
            curr.next = head;
            head = curr;
            carry = sum / 10;
        }
        return head;
    }
}
