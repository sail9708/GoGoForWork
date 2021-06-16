//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
// Related Topics 深度优先搜索 动态规划 回溯算法 
// 👍 750 👎 0

  
package leetcode.problems.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class No_131_PalindromePartitioning{
    public static void main(String[] args) {
       Solution solution = new No_131_PalindromePartitioning().new Solution();
       solution.partition("efe");
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 本题可以用 记忆化搜索 和 动态规划预处理数组  来优化回溯
     */

    List<List<String>> res = new ArrayList<>();
    Deque<String> temp = new LinkedList<>();
    //记忆数组
    int[][] memory;

    public List<List<String>> partition(String s) {
        if (s.length() == 0){
            return res;
        }
        memory = new int[s.length()][s.length()];

        //backtrack(s,0);
        backtrack_memory(s,0);

        return res;

    }

/***************(初见)正常回溯，无任何优化********************/
    //左闭右开
    public void backtrack(String s, int start){
        if (start == s.length()){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start+1; i<=s.length(); i++){
            if (isValid(s.substring(start, i))){
                temp.addLast(s.substring(start,i));
                backtrack(s, i);
                temp.removeLast();
            }
        }
    }

    //判断子串是否是回文子串
    public boolean isValid(String s){
        //单个字符一定是回文串
        if (s.length() == 1){
            return true;
        }
        //判断是否为回文串
        for (int left = 0, right = s.length()-1; left < right; left++, right--){
            if (s.charAt(left) != s.charAt(right)){
                return false;
            }
        }
        return true;
    }
/********************************************************************************/

/******************************回溯+记忆化搜索********************************/
    public void backtrack_memory(String s, int start){
        if (start == s.length()){
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start+1; i<=s.length(); i++){
            if (isValid_memory(s,start,i-1) == 1){
                temp.addLast(s.substring(start,i));
                backtrack_memory(s, i);
                temp.removeLast();
            }
        }
    }

    //判断子串是否是回文子串+记忆化搜索 以节约重复计算时间
    public int isValid_memory(String s,int i, int j){
        if (memory[i][j] != 0) {
            return memory[i][j];
        }
        if (i >= j) {
            memory[i][j] = 1;
        } else if (s.charAt(i) == s.charAt(j)) {
            memory[i][j] = isValid_memory(s, i + 1, j - 1);
        } else {
            memory[i][j] = -1;
        }
        return memory[i][j];

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
