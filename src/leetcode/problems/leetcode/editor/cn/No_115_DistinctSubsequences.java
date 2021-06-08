//给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。 
//
// 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列
//，而 "AEC" 不是） 
//
// 题目数据保证答案符合 32 位带符号整数范围。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "rabbbit", t = "rabbit"
//输出：3
//解释：
//如下图所示, 有 3 种可以从 s 中得到 "rabbit" 的方案。
//(上箭头符号 ^ 表示选取的字母)
//rabbbit
//^^^^ ^^
//rabbbit
//^^ ^^^^
//rabbbit
//^^^ ^^^
// 
//
// 示例 2： 
//
// 
//输入：s = "babgbag", t = "bag"
//输出：5
//解释：
//如下图所示, 有 5 种可以从 s 中得到 "bag" 的方案。 
//(上箭头符号 ^ 表示选取的字母)
//babgbag
//^^ ^
//babgbag
//^^    ^
//babgbag
//^    ^^
//babgbag
//  ^  ^^
//babgbag
//    ^^^ 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length, t.length <= 1000 
// s 和 t 由英文字母组成 
// 
// Related Topics 字符串 动态规划 
// 👍 531 👎 0

  
package leetcode.problems.leetcode.editor.cn;
public class No_115_DistinctSubsequences{
    public static void main(String[] args) {
       Solution solution = new No_115_DistinctSubsequences().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numDistinct(String s, String t) {
        if (s.length()<t.length()){
            return 0;
        }
        //建立dp数组,含义：dp[i][j]表示s[0~j]中t[0~i]的子序列个数
        int[][]dp = new int[t.length()][s.length()];
        //初始化dp数组
        //显然，当j<i时，s比t短，所以都为0
        for (int i = 0; i<t.length(); i++){
            for (int j = 0; j<i; j++){
                dp[i][j] = 0;
            }
        }
        //dp[0][j] = s[0~j]中t[0]的个数
        //dp[0][0]
        if (s.charAt(0) == t.charAt(0)){
            dp[0][0] = 1;
        }
        else {
            dp[0][0] = 0;
        }
        for (int j = 1; j < s.length();j++){
            if (s.charAt(j) == t.charAt(0)){
                dp[0][j] = dp[0][j-1]+1;
            }
            else {
                dp[0][j] = dp[0][j-1];
            }
        }
        //如果s[j] == t[i],则dp[i][j] = dp[i-1][j-1]+dp[i][j-1]
        //否则，dp[i][j] = dp[i][j-1]
        //所以，递推
        for (int i = 1; i< t.length(); i++){
            for (int j = i; j < s.length(); j++){
                if (s.charAt(j) == t.charAt(i)){
                    dp[i][j] = dp[i-1][j-1]+dp[i][j-1];
                }
                else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }

        return dp[t.length()-1][s.length()-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
