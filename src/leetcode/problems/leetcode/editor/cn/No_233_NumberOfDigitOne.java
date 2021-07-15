//给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 13
//输出：6
// 
//
// 示例 2： 
//
// 
//输入：n = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 2 * 109 
// 
// Related Topics 递归 数学 动态规划 
// 👍 228 👎 0

  
package leetcode.problems.leetcode.editor.cn;
public class No_233_NumberOfDigitOne{
    public static void main(String[] args) {
       Solution solution = new No_233_NumberOfDigitOne().new Solution();
       solution.countDigitOne(10);
    }
//leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 考虑分位算1，即个位 十位， 百位。。。
     */
    class Solution {
    public int countDigitOne(int n) {

        int res = 0;
        int i = 1;
        while(i<=n){
            int a = n/(i*10);
            int b = n%(i*10);
            if(b/i>1){
                res+=(a+1)*i;
            }else if (b/i == 1){
                res+=a*i+(b%i)+1;
            }else{
                res+=a*i;
            }
            i*=10;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
