//给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1: 
//
// 
//输入：prices = [3,3,5,0,0,3,1,4]
//输出：6
//解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
//     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。 
//
// 示例 2： 
//
// 
//输入：prices = [1,2,3,4,5]
//输出：4
//解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。   
//     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。   
//     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
// 
//
// 示例 3： 
//
// 
//输入：prices = [7,6,4,3,1] 
//输出：0 
//解释：在这个情况下, 没有交易完成, 所以最大利润为 0。 
//
// 示例 4： 
//
// 
//输入：prices = [1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 105 
// 0 <= prices[i] <= 105 
// 
// Related Topics 数组 动态规划 
// 👍 791 👎 0

  
package leetcode.problems.leetcode.editor.cn;
public class No_123_BestTimeToBuyAndSellStockIii{
    public static void main(String[] args) {
       Solution solution = new No_123_BestTimeToBuyAndSellStockIii().new Solution();
       solution.maxProfit(new int[]{3,5,0,1,4});
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * 标准答案版，用变量代替数组，效率大为提高
     *
     * 		执行耗时:4 ms,击败了97.99% 的Java用户
     * 		内存消耗:51.1 MB,击败了86.07% 的Java用户
     *
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < n; ++i) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }


    /** 自写答案
     * 初见思路 贪心（否定，没有想到可以实现的方法）
     *  所以用 动态规划
     *
     *      执行耗时:29 ms,击败了43.12% 的Java用户
     * 		内存消耗:49 MB,击败了95.90% 的Java用户
     *
     * @param prices
     * @return
     */
    public int maxProfit_1(int[] prices) {
        //因为最多只可以有两次买卖，所以一共有4个操作：第一次买，第一次卖，第二次买，第二次卖
        //如果只买卖一次的话，可以看作为在第一次卖的当天，又直接进行了第二次买卖
        //所以我们定义dp数组:
        // dp[i][0]表示在i处 或者之前 第一次买的 最大资金
        // dp[i][1]表示在i处 或者之前 第一次卖的 最大资金
        // dp[i][2]表示在i处 或者之前 第二次买的 最大资金
        // dp[i][3]表示在i处 或者之前 第二次卖的 最大资金
        int[][] dp = new int[prices.length][4];
        //初始化dp数组
        //我们默认手里资金为0，最终手里资金最多，则为最高收益，如果最多资金为负，则就最高收益为0
        //dp[i][0]  第一次买   总资金为手里的资金（0）减去当天的股票价格
        // dp[0][j]  第一次买卖全在第0处完成
        dp[0][0] = 0-prices[0];
        dp[0][1] = 0;
        dp[0][2] = dp[0][0];
        dp[0][3] = 0;

        for (int i = 1; i < prices.length; i++){
            dp[i][0] = Math.max(0 - prices[i], dp[i-1][0]);
        }

        for (int i = 1; i<prices.length;i++){
            for (int j = 1; j<=3; j++){
                if (j ==2){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]-prices[i]);
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]+prices[i]);
                }
            }
        }
        return dp[prices.length-1][3];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
