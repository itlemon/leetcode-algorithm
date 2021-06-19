package cn.itlemon.leetcode.stack;

import java.util.Stack;

/**
 * No.316 去除重复字母 https://leetcode-cn.com/problems/remove-duplicate-letters/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-06-19
 */
public class No316RemoveDuplicateLetters {

    /**
     * 单调栈：O(n)
     *
     * @param s 字符串
     * @return 去除重复字母后的字符串
     */
    public String removeDuplicateLetters(String s) {
        // 字符串是小写字母组成，小写字母a~z的ascii的取值范围是97~122
        // 创建一个26个英文字母的数组来记录每个小写字母出现的次数
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c % 97]++;
        }
        // 创建一个数组记录栈中是否已经有了该字符，默认值均为false
        boolean[] inStackArray = new boolean[26];
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            // 每遍历一个字符，该字符出现的次数就少一次
            count[c % 97]--;
            // 如果字符已经在栈中了，那么就不再进栈了
            if (inStackArray[c % 97]) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > c) {
                if (count[stack.peek() % 97] == 0) {
                    break;
                }
                inStackArray[stack.pop() % 97] = false;
            }
            stack.push(c);
            inStackArray[c % 97] = true;
        }
        // 将栈中的元素取出拼成字符串
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

}
