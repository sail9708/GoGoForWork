//给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。 
//
// 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。 
//
// 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
// 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 12
//输出：3 
//解释：12 = 4 + 4 + 4 
//
// 示例 2： 
//
// 
//输入：n = 13
//输出：2
//解释：13 = 4 + 9 
// 
//
// 提示： 
//
// 
// 1 <= n <= 104 
// 
// Related Topics 广度优先搜索 数学 动态规划 
// 👍 1011 👎 0

  
package leetcode.problems.leetcode.editor.cn;
public class No_279_PerfectSquares{
    public static void main(String[] args) {
       Solution solution = new No_279_PerfectSquares().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 初见思路：动态规划， 背包问题， 用最少的完全平方数填满n
     * @param n
     * @return
     */
    public int numSquares(int n) {
        //动态规划
        // 1. 定义dp数组，dp[i]表示装满i需要的最少完全平方数
        int[] dp = new int[n+1];
        //初始化dp,默认全用1来装
        for (int i = 0; i <= n; i++){
            dp[i] = i;
        }
        //更新dp数组
        //外层遍历背包，内存遍历物品
        //解答成功:
        //			执行耗时:46 ms,击败了33.18% 的Java用户
        //			内存消耗:37.4 MB,击败了75.59% 的Java用户
//        for (int i = 1; i < n+1; i++){
//            for (int j = 1; j*j<=i; j++){
//                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
//            }
//        }

        //外层遍历物品，内层遍历背包
        //解答成功:
        //			执行耗时:28 ms,击败了88.63% 的Java用户
        //			内存消耗:37.5 MB,击败了60.68% 的Java用户
        for (int i = 1; i * i <= n; i++) {
            for (int j = i * i; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
            }
        }
        return dp[dp.length-1];


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
