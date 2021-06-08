//给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1: 
//
// 
//输入: prices = [7,1,5,3,6,4]
//输出: 7
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
// 
//
// 示例 2: 
//
// 
//输入: prices = [1,2,3,4,5]
//输出: 4
//解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
// 
//
// 示例 3: 
//
// 
//输入: prices = [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 3 * 104 
// 0 <= prices[i] <= 104 
// 
// Related Topics 贪心算法 数组 
// 👍 1240 👎 0

  
package leetcode.problems.leetcode.editor.cn;
public class No_122_BestTimeToBuyAndSellStockIi{
    public static void main(String[] args) {
       Solution solution = new No_122_BestTimeToBuyAndSellStockIi().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 初见思路 贪心 和121题一样
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0){
            return 0;
        }
        int left = 0, right = 0;
        int profit = 0;
        while (right < prices.length-1){
            //如果当前价格比，比后续价格高，不操作。否则，买入
            if (prices[right]<prices[left]){
                left = right;
            }
            //价格比买入价格高的时候，检查后面一天的价格，如果比当前价格高，就不卖，否则就卖出
            else if (prices[right+1]<prices[right]){
                profit += prices[right]-prices[left];
                left = right+1;
            }
            //如果价格一直在涨直到最后一天，就在最后一天卖出
            else if (right+1 == prices.length-1){
                profit +=prices[right+1]-prices[left];
            }
            right++;
        }
        return profit;
    }

    /**
     * 代码简化版 贪心
     */
    public int maxProfit_1(int[] prices) {
        int profit = 0;
        int i = 0;
        while (i<prices.length-1){
            profit += Math.max(0, prices[i+1]-prices[i]);
            i++;
        }
        return profit;
    }

    /**
     *  动态规划
     * @param prices
     * @return
     */
    public int maxProfit_2(int[] prices) {
        // [天数][是否持有股票]
        int[][] dp = new int[prices.length][2];

        // bad case
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            // dp公式
            // 第i天持股票所剩最多现金 = max(第i-1天持股票所剩现金, 第i-1天持现金-买第i天的股票)
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // 第i天持有最多现金 = max(第i-1天持有的最多现金，第i-1天持有股票的最多现金+第i天卖出股票)
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[prices.length - 1][0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
