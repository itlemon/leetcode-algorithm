package cn.itlemon.leetcode.list;

import java.util.Stack;

import cn.itlemon.leetcode.model.ListNode;

/**
 * @author jiangpingping <jiangpingping@kuaishou.com>
 * Created on 2021-05-19
 */
public class No455AddTwoNumbersII {

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
            if (itemForL1 != 0 || itemForL2 != 0) {
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
            } else {
                break;
            }
        }
        ListNode head = new ListNode();
        if (!stackForResult.isEmpty()) {
            head.val = stackForResult.pop();
        }
        while (!stackForResult.isEmpty()) {
            head.next = new ListNode(stackForResult.pop());
        }
        return head;
    }
}
