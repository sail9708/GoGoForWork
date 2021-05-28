//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：n = 4
//输出：2
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 皇后彼此不能相互攻击，也就是说：任何两个皇后都不能处于同一条横行、纵行或斜线上。 
// 
// 
// 
// Related Topics 回溯算法 
// 👍 263 👎 0

  
package leetcode.problems.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No_52_NQueensIi{
    public static void main(String[] args) {
       Solution solution = new No_52_NQueensIi().new Solution();
        System.out.println(solution.totalNQueens(9));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    int result=0;

    public int totalNQueens(int n) {
        //定义棋盘
        char[][] chessboard = new char[n][n];
        //初始化棋盘
        for (int i = 0; i<n;i++){
            Arrays.fill(chessboard[i],'.');
        }
        backtrack(chessboard, n, 0);

        return result;
    }


    public void backtrack(char[][] chessboard, int n, int row){
        if (row == n){
            result++;
            return;
        }
        for (int col = 0; col<n; col++){
            if(isValid(row, col, chessboard)){
                chessboard[row][col] = 'Q';
                backtrack(chessboard, n, row+1);
                chessboard[row][col] = '.';
            }
        }

    }

    //判断在row行，col列放置Queen是否合法
    public boolean isValid(int row, int col, char[][] board){
        //判断同列是否有Q
        for (int i = row-1; i>=0; i--){
            if (board[i][col] == 'Q'){
                return false;
            }
        }
        //判断斜角是否有Q
        for (int i = row-1,j = col-1; i>=0&&j>=0; i--,j--){
            if (board[i][j] == 'Q'){
                return false;
            }
        }
        for (int i = row -1, j = col+1;i>=0&&j< board.length;i--,j++){
            if (board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
