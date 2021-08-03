package cn.itlemon.leetcode.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * No.17 电话号码的字母组合 https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-08-03
 */
public class No17LetterCombinationsOfAPhoneNumber {

    /**
     * 定义2 ~ 9对应的字母字典
     */
    private final String[] letterMap = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    /**
     * 回溯算法
     *
     * @param digits 数字
     * @return 组合
     */
    public List<String> letterCombinations(String digits) {
        // 定义结果集
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        // 定义路径
        StringBuilder track = new StringBuilder();
        // 回溯
        backtracking(digits, 0, track, result);
        return result;
    }

    private void backtracking(String digits, int index, StringBuilder track, List<String> result) {
        // 触发终止条件
        if (digits.length() == track.length()) {
            result.add(track.toString());
            return;
        }

        String letter = letterMap[digits.charAt(index) - '2'];
        // 回溯的核心部分
        for (int i = 0; i < letter.length(); i++) {
            // 做选择
            track.append(letter.charAt(i));
            // 递归
            backtracking(digits, index + 1, track, result);
            // 撤销选择，撤销路径中最后一个字母
            track.deleteCharAt(track.length() - 1);
        }
    }
}
