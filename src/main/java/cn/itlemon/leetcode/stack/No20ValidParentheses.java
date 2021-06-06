package cn.itlemon.leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * No.20 有效的括号 https://leetcode-cn.com/problems/valid-parentheses/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-06-06
 */
public class No20ValidParentheses {

    /**
     * 类似这种层级的问题，第一想到的就是使用栈来操作：O(n)
     *
     * @param s 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s
     * @return 是否满足要求
     */
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Map<Character, Character> pairs = new HashMap<>(4);
        pairs.put(')', '(');
        pairs.put('}', '{');
        pairs.put(']', '[');
        Stack<Character> stack = new Stack<>();
        for (char character : s.toCharArray()) {
            if (pairs.containsKey(character)) {
                if (!stack.isEmpty() && stack.peek().equals(pairs.get(character))) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(character);
            }
        }
        return stack.isEmpty();
    }

    /**
     * 利用字符串必须成对出现的技巧来处理
     *
     * @param s 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s
     * @return 是否满足要求
     */
    public static boolean isValid2(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        StringBuilder sb = new StringBuilder(s);
        while (sb.indexOf("()") != -1 || sb.indexOf("{}") != -1 || sb.indexOf("[]") != -1) {
            if (sb.indexOf("()") != -1) {
                int index = sb.indexOf("()");
                sb.delete(index, index + 2);
            }
            if (sb.indexOf("{}") != -1) {
                int index = sb.indexOf("{}");
                sb.delete(index, index + 2);
            }
            if (sb.indexOf("[]") != -1) {
                int index = sb.indexOf("[]");
                sb.delete(index, index + 2);
            }
        }
        return sb.length() == 0;
    }

}
