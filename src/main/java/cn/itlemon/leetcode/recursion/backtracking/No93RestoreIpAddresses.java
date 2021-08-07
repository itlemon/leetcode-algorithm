package cn.itlemon.leetcode.recursion.backtracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * No.93 复原IP地址 https://leetcode-cn.com/problems/restore-ip-addresses/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-08-07
 */
public class No93RestoreIpAddresses {

    /**
     * 回溯算法
     *
     * @param s 只含数字的字符串
     * @return IP列表
     */
    public List<String> restoreIpAddresses(String s) {
        // 定义结果集
        List<String> result = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) {
            // 长度不合适，直接返回
            return result;
        }

        // 定义路径
        Deque<String> track = new LinkedList<>();
        char[] charArr = s.toCharArray();
        backtracking(charArr, 0, track, result);
        return result;
    }

    private void backtracking(char[] charArr, int start, Deque<String> track, List<String> result) {
        // 触发终止条件
        if (start == charArr.length) {
            // 说明截取的指针到了最后
            if (track.size() == 4) {
                result.add(String.join(".", track));
            }
        }

        // 剪枝判断：看到剩下的不够了，就退出，len - start 表示剩余的还未分割的字符串的位数
        // 或者剩下的超过了IP段最多需要的字符个数
        int remainingIpSegmentCount = 4 - track.size();
        if (charArr.length - start < remainingIpSegmentCount || charArr.length - start > remainingIpSegmentCount * 3) {
            return;
        }

        // 回溯的核心部分
        // 每个IP子段最多只有3个数组组成
        for (int i = 0; i < 3; i++) {
            // 这里还需要进一步判断，满足条件说明到达了最后一个
            if (start + i >= charArr.length) {
                break;
            }

            // 检查并获取IP段，如果满足，则返回IP段，否则返回-1
            int validIpSegment = getValidIpSegment(charArr, start, start + i);
            if (validIpSegment != -1) {
                // 做选择
                track.addLast(String.valueOf(validIpSegment));
                // 递归
                backtracking(charArr, start + i + 1, track, result);
                // 撤销选择
                track.removeLast();
            }
        }
    }

    /**
     * 检查闭区间[start, end]是否是合理的IP子段
     *
     * @param charArr 数值数组
     * @param start 开始索引
     * @param end 结束索引
     * @return 如果是合理IP子段，则返回，否则返回-1
     */
    private int getValidIpSegment(char[] charArr, int start, int end) {
        int length = end - start + 1;

        // 如果子段长度 > 1，且为0的话，那么是不符合IP段的规范的
        if (length > 1 && charArr[start] == '0') {
            return -1;
        }

        // 构建IP段
        int ipSegment = Integer.parseInt(new String(charArr, start, length));
        return ipSegment > 255 ? -1 : ipSegment;
    }

}
