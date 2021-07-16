//给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。 
//
// '?' 可以匹配任何单个字符。
//'*' 可以匹配任意字符串（包括空字符串）。
// 
//
// 两个字符串完全匹配才算匹配成功。 
//
// 说明: 
//
// 
// s 可能为空，且只包含从 a-z 的小写字母。 
// p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。 
// 
//
// 示例 1: 
//
// 输入:
//s = "aa"
//p = "a"
//输出: false
//解释: "a" 无法匹配 "aa" 整个字符串。 
//
// 示例 2: 
//
// 输入:
//s = "aa"
//p = "*"
//输出: true
//解释: '*' 可以匹配任意字符串。
// 
//
// 示例 3: 
//
// 输入:
//s = "cb"
//p = "?a"
//输出: false
//解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
// 
//
// 示例 4: 
//
// 输入:
//s = "adceb"
//p = "*a*b"
//输出: true
//解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
// 
//
// 示例 5: 
//
// 输入:
//s = "acdcb"
//p = "a*c?b"
//输出: false 
// Related Topics 贪心 递归 字符串 动态规划 
// 👍 716 👎 0

  
package leetcode.problems.leetcode.editor.cn;
public class No_44_WildcardMatching{
    public static void main(String[] args) {
       Solution solution = new No_44_WildcardMatching().new Solution();
       solution.isMatch("aa","a");
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isMatch(String s, String p) {
        char[] cs = (" "+s).toCharArray();
        char[] cp = (" "+p).toCharArray();

        boolean[][] dp = new boolean[cp.length][cs.length];
        //初始化dp
        dp[0][0] = true;
        for (int i = 1; i <dp.length; i++){
            if (cp[i] == '*' && dp[i-1][0]){
                dp[i][0] = true;
            }
        }
        //更新dp，
        //状态转移公式：如果cp[i]不是‘*’，则若cp[i]和cs[j]不相同，或者cp[i]和cs[j]相同但dp[i-1][j-1]为false，则dp[i][j]为false，否则为true
        //           如果cp[i]是‘*’,则dp[i-1][j-1]\dp[i][j-1]\dp[i-1][j]中有一个为true，dp[i][j]就为true，否则为false
        for (int i = 1; i< dp.length; i++){
            for (int j = 1; j < dp[0].length; j++){
                if (cp[i] != '*'){
                    if (dp[i-1][j-1]){
                        if (cp[i] == '?' || cp[i] == cs[j]) {
                            dp[i][j] = true;
                        }
                    }
                }else {
                    if (dp[i-1][j-1] || dp[i][j-1] || dp[i-1][j]){
                        dp[i][j] = true;
                    }
                }
            }
        }
        return dp[cp.length-1][cs.length-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
