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

    /**
     * 贪心算法：大饼干先喂饱大胃口的，时间复杂度在于排序O(nlogn)
     *
     * @param g 小孩胃口
     * @param s 饼干
     * @return 满足的小孩人数
     */
    public int findContentChildren2(int[] g, int[] s) {
        // 从小到大排序
        Arrays.sort(g);
        Arrays.sort(s);

        // 定义结果
        int result = 0;

        // 定义饼干索引，从最后一个开始
        int index = s.length - 1;

        // 这里是遍历小孩数组还是饼干数组有讲究，一不留神就错了
        // 小孩子胃口和饼干从小到大排成一排，我们让最后一个小孩出出来选择一个最大的饼干，问他是否满意，如果满意，则他拿了使他满意的最大的一块饼干，
        // 如果他不满意，说明这些饼干中没有能使他满意的了，直接问倒数第二个小孩，让他挑一个最大的能使他满意的，这么分析过来，我们就知道我们应该遍历
        // 小孩的胃口数组，然后让其拿最大的那一块饼干，直到遍历完所有的小孩或者饼干分完为止。
        for (int i = g.length - 1; i >= 0; i--) {
            if (index >= 0 && s[index] >= g[i]) {
                // 说明当前饼干满足了当前这个小孩
                result++;
                index--;
            }
        }
        return result;
    }

}
