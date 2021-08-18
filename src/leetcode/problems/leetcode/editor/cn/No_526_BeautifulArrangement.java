//假设有从 1 到 N 的 N 个整数，如果从这 N 个数字中成功构造出一个数组，使得数组的第 i 位 (1 <= i <= N) 满足如下两个条件中的一个，
//我们就称这个数组为一个优美的排列。条件： 
//
// 
// 第 i 位的数字能被 i 整除 
// i 能被第 i 位上的数字整除 
// 
//
// 现在给定一个整数 N，请问可以构造多少个优美的排列？ 
//
// 示例1: 
//
// 
//输入: 2
//输出: 2
//解释: 
//
//第 1 个优美的排列是 [1, 2]:
//  第 1 个位置（i=1）上的数字是1，1能被 i（i=1）整除
//  第 2 个位置（i=2）上的数字是2，2能被 i（i=2）整除
//
//第 2 个优美的排列是 [2, 1]:
//  第 1 个位置（i=1）上的数字是2，2能被 i（i=1）整除
//  第 2 个位置（i=2）上的数字是1，i（i=2）能被 1 整除
// 
//
// 说明: 
//
// 
// N 是一个正整数，并且不会超过15。 
// 
// Related Topics 位运算 数组 动态规划 回溯 状态压缩 
// 👍 147 👎 0


package leetcode.problems.leetcode.editor.cn;

public class No_526_BeautifulArrangement {
    public static void main(String[] args) {
        Solution solution = new No_526_BeautifulArrangement().new Solution();
        solution.countArrangement(5);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 初见思路：回溯
         * 解答成功:
         * 		执行耗时:52 ms,击败了80.26% 的Java用户
         * 		内存消耗:34.9 MB,击败了92.93% 的Java用户
         * @param n
         * @return
         */
        int res = 0;
        public int countArrangement(int n) {
            boolean[] used = new boolean[n];
            backtrack(1, n, used);
            return res;
        }

        public void backtrack(int i, int n, boolean[] used) {
            if (i > n){
                res++;
                return ;
            }
            for (int j = 0; j < n; j++) {
                if (used[j]) {
                    continue;
                }
                used[j] = true;
                if ((j + 1) % i == 0 || i % (j + 1) == 0) {
                    backtrack(i + 1, n, used);
                }
                used[j] = false;
            }
            return ;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
