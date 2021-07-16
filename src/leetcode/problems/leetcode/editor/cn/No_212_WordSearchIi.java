//给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。 
//
// 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使
//用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l"
//,"v"]], words = ["oath","pea","eat","rain"]
//输出：["eat","oath"]
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], words = ["abcb"]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 12 
// board[i][j] 是一个小写英文字母 
// 1 <= words.length <= 3 * 104 
// 1 <= words[i].length <= 10 
// words[i] 由小写英文字母组成 
// words 中的所有字符串互不相同 
// 
// Related Topics 字典树 数组 字符串 回溯 矩阵 
// 👍 408 👎 0

  
package leetcode.problems.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class No_212_WordSearchIi{
    public static void main(String[] args) {
       Solution solution = new No_212_WordSearchIi().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 初见思路：回溯法+hashset+stringbuilder
     * 解答成功:
     * 			执行耗时:423 ms,击败了35.91% 的Java用户
     * 			内存消耗:38.7 MB,击败了42.31% 的Java用户
     *
     * 	优化思路：初次实现中，只是简单的剪枝，可以使用Trie树（前缀树）更加提高效率
     *
     * @param board
     * @param words
     * @return
     */
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> set = new HashSet<>();
        int maxLen = 0;
        int minLen = Integer.MAX_VALUE;
        for (String s : words){
            set.add(s);
            if (s.length()>maxLen){
                maxLen = s.length();
            }
            if (s.length()<minLen){
                minLen = s.length();
            }
        }
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean[][] used = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                backtrack(res,board,i,j, (HashSet<String>) set,maxLen,minLen,sb,used);
            }
        }

        return res;
    }

    public void backtrack(List<String> res, char[][] board, int x, int y, HashSet<String> set, int maxLen, int minLen, StringBuilder sb, boolean[][] used){
        sb.append(board[x][y]);
        used[x][y] = true;
        if (sb.length()>maxLen){
            sb.deleteCharAt(sb.length()-1);
            used[x][y] = false;
            return;
        }
        if (sb.length()>=minLen){
            if (set.contains(sb.toString())){
                res.add(sb.toString());
                set.remove(sb.toString());
            }
        }
        //按照右、下、左、上的顺序回溯递归
        if (y<board[0].length-1 && !used[x][y+1]){
            backtrack(res, board, x, y+1,set,maxLen,minLen,sb,used);
        }
        if (x<board.length-1 && !used[x+1][y]){
            backtrack(res,board,x+1,y,set,maxLen,minLen,sb,used);
        }
        if (y>0 && !used[x][y-1]){
            backtrack(res,board,x,y-1,set,maxLen,minLen,sb,used);
        }
        if (x>0 && !used[x-1][y]){
            backtrack(res,board,x-1,y,set,maxLen,minLen,sb,used);
        }

        sb.deleteCharAt(sb.length() - 1);
        used[x][y] = false;
        return;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
