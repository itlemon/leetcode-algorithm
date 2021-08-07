package cn.itlemon.leetcode.recursion.backtracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * No.131 分割回文串 https://leetcode-cn.com/problems/palindrome-partitioning/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-08-05
 */
public class No131PalindromePartitioning {

    public List<List<String>> partition(String s) {
        // 定义结果集
        List<List<String>> result = new ArrayList<>();
        if (s.length() == 0) {
            return result;
        }

        // 定义路径
        Deque<String> track = new LinkedList<>();
        // 减少字符串裁剪过程，使用字符数组
        char[] chars = s.toCharArray();
        // 回溯
        backtracking(chars, 0, track, result);
        return result;
    }

    private void backtracking(char[] chars, int start, Deque<String> track, List<List<String>> result) {
        // 触发终止条件
        if (start == chars.length) {
            result.add(new ArrayList<>(track));
            return;
        }

        // 回溯的核心部分
        for (int i = start; i < chars.length; i++) {
            // 剪枝
            if (!isPalindrome(chars, start, i)) {
                continue;
            }
            // 做选择
            track.addLast(new String(chars, start, i + 1 - start));
            // 递归
            backtracking(chars, i + 1, track, result);
            // 撤销选择
            String s = track.removeLast();
        }
    }

    /**
     * 检查是否是回文字符串
     *
     * @param chars 字符数组
     * @param start 开始索引
     * @param end 结束索引
     * @return 是否是回文字符串
     */
    private boolean isPalindrome(char[] chars, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            if (chars[i] != chars[j]) {
                return false;
            }
        }
        return true;
    }
}
