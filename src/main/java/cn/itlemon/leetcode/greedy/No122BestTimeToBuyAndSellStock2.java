package cn.itlemon.leetcode.greedy;

/**
 * No.122 买卖股票的最佳时机 II https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2021-09-01
 */
public class No122BestTimeToBuyAndSellStock2 {

    /**
     * 贪心算法
     *
     * @param prices 股票价格
     * @return 最大利润
     */
    public int maxProfit(int[] prices) {
        int length = prices.length;
        if (length <= 1) {
            return 0;
        }

        // 定义结果
        int result = 0;
        int sum = 0;
        for (int i = 0; i < length - 1; i++) {
            if (prices[i] <= prices[i + 1]) {
                sum += (prices[i + 1] - prices[i]);
                if (i == length - 2) {
                    // 说明遍历到了最后
                    result += sum;
                }
            } else {
                // 出现价格下降，这里就卖出，并设置sum为0，重新开始计算利润
                result += sum;
                sum = 0;
            }
        }
        return result;
    }

}
