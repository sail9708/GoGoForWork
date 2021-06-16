//给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。 
//
// 说明： 
//
// 
// 拆分时可以重复使用字典中的单词。 
// 你可以假设字典中没有重复的单词。 
// 
//
// 示例 1： 
//
// 输入: s = "leetcode", wordDict = ["leet", "code"]
//输出: true
//解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
// 
//
// 示例 2： 
//
// 输入: s = "applepenapple", wordDict = ["apple", "pen"]
//输出: true
//解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
//     注意你可以重复使用字典中的单词。
// 
//
// 示例 3： 
//
// 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
//输出: false
// 
// Related Topics 动态规划 
// 👍 1020 👎 0

  
package leetcode.problems.leetcode.editor.cn;

import java.util.List;

public class No_139_WordBreak{
    public static void main(String[] args) {
       Solution solution = new No_139_WordBreak().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //dp[i]表示非空字符串的前i个字符，是否可以被拆分成字典中的字符串
        boolean[] dp = new boolean[s.length()+1];
        //初始化dp数组
        dp[0] = true;
        for (int i = 1; i < s.length()+1; i++){
            for (int j = i-1; j>=0; j--){
                if (dp[j] == true){
                    dp[i] = dp[i] || wordDict.contains(s.substring(j, i));
                    if (dp[i] == true){
                        break;
                    }
                }
            }
        }
        return dp[s.length()];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
