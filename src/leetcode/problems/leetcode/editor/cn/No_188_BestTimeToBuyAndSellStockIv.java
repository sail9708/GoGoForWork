//给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1： 
//
// 
//输入：k = 2, prices = [2,4,1]
//输出：2
//解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。 
//
// 示例 2： 
//
// 
//输入：k = 2, prices = [3,2,6,5,0,3]
//输出：7
//解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
//     随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 
//。 
//
// 
//
// 提示： 
//
// 
// 0 <= k <= 100 
// 0 <= prices.length <= 1000 
// 0 <= prices[i] <= 1000 
// 
// Related Topics 动态规划 
// 👍 526 👎 0

  
package leetcode.problems.leetcode.editor.cn;
public class No_188_BestTimeToBuyAndSellStockIv{
    public static void main(String[] args) {
       Solution solution = new No_188_BestTimeToBuyAndSellStockIv().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * 优化
     *			解答成功:
     * 			执行耗时:5 ms,击败了87.43% 的Java用户
     * 			内存消耗:36.1 MB,击败了85.79% 的Java用户
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0 || k == 0){
            return 0;
        }
        int n = prices.length;
        //如果天数小于最大操作次数，就可以操作次数k可以等效为操作次数n
        if (n < k){
            k = n;
        }
        int[] bsOperate_Profit = new int[2*k];
        //初始化，所买次数买卖都在第一天进行
        for (int i = 0; i < bsOperate_Profit.length; i++){
            //买入操作
            if (i%2 == 0){
                bsOperate_Profit[i] = -prices[0];
            }
            //卖出操作
            else {
                bsOperate_Profit[i] = 0;
            }
        }

        for (int i = 1; i < n; i++){
            for (int j = 0; j < bsOperate_Profit.length; j++){
                //第一次买
                if (j == 0){
                    bsOperate_Profit[j] = Math.max(bsOperate_Profit[j], -prices[i]);
                    continue;
                }
                //第二次以及之后的买入操作
                if (j % 2 == 0){
                    bsOperate_Profit[j] = Math.max(bsOperate_Profit[j], bsOperate_Profit[j-1]-prices[i]);
                }
                //卖出操作
                else {
                    bsOperate_Profit[j] = Math.max(bsOperate_Profit[j], bsOperate_Profit[j-1]+prices[i]);
                }
            }
        }
        //如果在最终收益为负，则最大收益为0
        if (bsOperate_Profit[bsOperate_Profit.length-1]<0){
            bsOperate_Profit[bsOperate_Profit.length-1] = 0;
        }
        return bsOperate_Profit[bsOperate_Profit.length-1];
    }

    /**
     *          初见
     * 			解答成功:
     * 			执行耗时:7 ms,击败了60.50% 的Java用户
     * 			内存消耗:36 MB,击败了89.31% 的Java用户
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit_1(int k, int[] prices) {
        if (prices.length == 0 || k == 0){
            return 0;
        }
        int n = prices.length;
        int[] bsOperate_Profit = new int[2*k];
        //初始化，所买次数买卖都在第一天进行
        for (int i = 0; i < bsOperate_Profit.length; i++){
            //买入操作
            if (i%2 == 0){
                bsOperate_Profit[i] = -prices[0];
            }
            //卖出操作
            else {
                bsOperate_Profit[i] = 0;
            }
        }

        for (int i = 1; i < n; i++){
            for (int j = 0; j < bsOperate_Profit.length; j++){
                //第一次买
                if (j == 0){
                    bsOperate_Profit[j] = Math.max(bsOperate_Profit[j], -prices[i]);
                    continue;
                }
                //第二次以及之后的买入操作
                if (j % 2 == 0){
                    bsOperate_Profit[j] = Math.max(bsOperate_Profit[j], bsOperate_Profit[j-1]-prices[i]);
                }
                //卖出操作
                else {
                    bsOperate_Profit[j] = Math.max(bsOperate_Profit[j], bsOperate_Profit[j-1]+prices[i]);
                }
            }
        }
        //如果在最终收益为负，则最大收益为0
        if (bsOperate_Profit[bsOperate_Profit.length-1]<0){
            bsOperate_Profit[bsOperate_Profit.length-1] = 0;
        }
        return bsOperate_Profit[bsOperate_Profit.length-1];

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
