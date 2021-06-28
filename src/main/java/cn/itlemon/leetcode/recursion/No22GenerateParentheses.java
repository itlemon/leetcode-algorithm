package cn.itlemon.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * No22. 括号生成 https://leetcode-cn.com/problems/generate-parentheses/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-06-29
 */
public class No22GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper("", 0, 0, n, result);
        return result;
    }

    private void helper(String s, int left, int right, int max, List<String> result) {
        // 终止条件
        if (left == max && right == max) {
            result.add(s);
            return;
        }

        // 本层要做的事情及递归
        if (left < max) {
            helper(s + "(", left + 1, right, max, result);
        }
        if (right < left) {
            helper(s + ")", left, right + 1, max, result);
        }
    }

}
