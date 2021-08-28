package cn.itlemon.leetcode.greedy;

import java.util.Arrays;

/**
 * No.455 分发饼干 https://leetcode-cn.com/problems/assign-cookies/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-08-28
 */
public class No455AssignCookies {

    /**
     * 贪心算法：小饼干先喂饱小胃口的，时间复杂度在于排序O(nlogn)
     *
     * @param g 小孩胃口
     * @param s 饼干
     * @return 满足的小孩人数
     */
    public int findContentChildren(int[] g, int[] s) {
        // 从小到大排序
        Arrays.sort(g);
        Arrays.sort(s);

        // 定义结果
        int result = 0;

        // 定义小孩索引
        int index = 0;

        // 这里是遍历小孩数组还是饼干数组有讲究，一不留神就错了
        // 小孩子胃口和饼干从小到大排成一排，拿出一个饼干，给第一个小孩，问他满足不满足，满足的话，就给他，否则拿第二块饼干再次问他，直到他满意为止
        // 这么分析后，很明显，我们需要遍历饼干数组，如果我们遍历小孩胃口数组，那就是相当于挨个问所有小孩，问他们对第一块饼干满意吗？答案很明显，第一个
        // 小孩不满意的话，后面的小孩肯定也不会满意，因为第一个小孩胃口是最小的，最小都不满意，胃口大的还会满意吗？
        for (int i = 0; i < s.length; i++) {
            if (index < g.length && s[i] >= g[index]) {
                // 说明当前饼干满足了当前这个小孩
                result++;
                index++;
            }
        }
        return result;
    }

}
