//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，x⁴
//
// Related Topics 递归 数学 👍 743 👎 0

  
package leetcode.problems.leetcode.editor.cn;
public class No_50_PowxN{
    public static void main(String[] args) {
       Solution solution = new No_50_PowxN().new Solution();
       solution.myPow(0.0001,-2147483647);
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 初见思路：分治法
     * 解答成功:
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:37.9 MB,击败了7.29% 的Java用户
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n > 0){
            return helper(x, n);
        }else {
            return 1/helper(x, -n);
        }
    }

    public double helper(double x, int n) {
        if (n == 0){
            return 1.0;
        }
        double res = helper(x, n/2);
        if (n%2 == 0){
            return res*res;
        }else {
            return res*res*x;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
