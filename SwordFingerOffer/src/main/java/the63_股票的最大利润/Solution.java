package the63_股票的最大利润;

/**
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可获得的最大利润是多少？
 * 例如，一只股票在某些时间节点的价格为{9,11,8,5,7,12,16,14}。
 * 如果我们能在价格为5的时候买入并在价格为16时卖出，则能获得最大的利润为11.
 * author@ pinnuli
 * date@ 2019/3/28
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            minPrice = minPrice < prices[i] ? minPrice : prices[i];
            int currentProfit = prices[i] - minPrice;
            maxProfit = maxProfit > currentProfit ? maxProfit : currentProfit;
        }
        return maxProfit;
    }
}
