//给定一个正整数 n，找出小于或等于 n 的非负整数中，其二进制表示不包含 连续的1 的个数。 
//
// 示例 1: 
//
// 输入: 5
//输出: 5
//解释: 
//下面是带有相应二进制表示的非负整数<= 5：
//0 : 0
//1 : 1
//2 : 10
//3 : 11
//4 : 100
//5 : 101
//其中，只有整数3违反规则（有两个连续的1），其他5个满足规则。 
//
// 说明: 1 <= n <= 10⁹ 
// Related Topics 动态规划 👍 118 👎 0

  
package leetcode.problems.leetcode.editor.cn;
public class No_600_NonNegativeIntegersWithoutConsecutiveOnes{
    public static void main(String[] args) {
       Solution solution = new No_600_NonNegativeIntegersWithoutConsecutiveOnes().new Solution();
       solution.findIntegers(4);
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 解答成功:
     * 		执行耗时:1 ms,击败了99.28% 的Java用户
     * 		内存消耗:35.3 MB,击败了84.17% 的Java用户
     * @param n
     * @return
     */
    public int findIntegers(int n) {
        String strN = Integer.toBinaryString(n);
        int len = strN.length();
        //dp数组含义：dp[i]表示 长度为i以及小于i的 二进制数符合条件的数量（0暂时排除在外）
        int[] dp = new int[len+1];
        dp[0] = 0;
        dp[1] = 1;
        int tail0 = 0;
        int tail1 = 1;
        //很容易得到递推公式：向尾部加0或1，结尾为0的可以生成两个新的符合条件的，结尾为1的只能生成1个
        for (int i = 2; i <= len; i++ ){
            int temp0 = tail0+tail1;
            int temp1 = tail0;
            tail0=temp0;
            tail1=temp1;
            dp[i] = tail0+tail1+dp[i-1];
        }
        //假设n的二进制为： 110010
        //显然1~100000中符合条件的个数可以直接由dp数组得到
        int ans = dp[len-1]+1;
        int tempN = n;
        //接下来只需要考虑100001~110010中符合条件的数的个数
        //实际上要考虑的就是1~10010中符合条件的个数
        while (tempN >1) {
            tempN -= Math.pow(2, len - 1);
            if (tempN == 0){
                break;
            }
            String tempStrN = Integer.toBinaryString(tempN);
            //此处分两种情况
            //condition1：原n的二进制表示中，最左边有两位相邻的1。实际在这种情况中，最高位的1已经被固定，
            //            所以次高位不可为1，所以可以直接转化为找1~1111中符合条件的个数，可由dp直接得到
            if (len - tempStrN.length() == 1) {
                ans+=dp[len-2];
                break;
            }
            //condition2：原n的二进制表示中，次高位不为1。
            //              如n的二进制表示为1001001，
            //              我们就可以迭代，转化为求1~1001中符合条件的个数
            else {
                len = tempStrN.length();
                ans+=dp[len-1]+1;
            }
        }
        //此处+1，是加上前面被忽略的0
        return ans+1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
