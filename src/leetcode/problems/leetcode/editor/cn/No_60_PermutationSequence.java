//给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。 
//
// 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下： 
//
// 
// "123" 
// "132" 
// "213" 
// "231" 
// "312" 
// "321" 
// 
//
// 给定 n 和 k，返回第 k 个排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3, k = 3
//输出："213"
// 
//
// 示例 2： 
//
// 
//输入：n = 4, k = 9
//输出："2314"
// 
//
// 示例 3： 
//
// 
//输入：n = 3, k = 1
//输出："123"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 1 <= k <= n! 
// 
// Related Topics 递归 数学 👍 568 👎 0


package leetcode.problems.leetcode.editor.cn;

public class No_60_PermutationSequence {
    public static void main(String[] args) {
        Solution solution = new No_60_PermutationSequence().new Solution();
        solution.getPermutation(3,3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 康托展开 he 逆康托展开 方法
         * 解答成功:
         * 			执行耗时:1 ms,击败了98.54% 的Java用户
         * 			内存消耗:35.8 MB,击败了55.24% 的Java用户
         * @param n
         * @param k
         * @return
         */
        public String getPermutation(int n, int k) {
            boolean[] used = new boolean[n];
            StringBuilder sb = new StringBuilder();
            k--;
            for (int i = 0; i < n; i++){
                int x = 1;
                for (int j = 1; j <= n-1-i;j++ ){
                    x*=j;
                }
                int num = k/x;
                k = k%x;
                int cnt = 0;
                while (num >=0){
                    if (used[cnt]){
                        cnt++;
                        continue;
                    }
                    if (num == 0) {
                        used[cnt] = true;
                    }
                    cnt++;
                    num--;
                }
                sb.append(cnt);

            }
            return sb.toString();
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
