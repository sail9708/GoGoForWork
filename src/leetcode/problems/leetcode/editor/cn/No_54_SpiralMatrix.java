//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 矩阵 模拟 👍 868 👎 0

  
package leetcode.problems.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class No_54_SpiralMatrix{
    public static void main(String[] args) {
       Solution solution = new No_54_SpiralMatrix().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int bottom = matrix.length-1;
        int right = matrix[0].length-1;
        int left = 0;
        int top = 0;
        int x = 0;
        int y = 0;
        List<Integer> ans = new ArrayList<>();
        boolean flag = true;
        while (bottom>top&&right>left){
            //左->右
            while (y<right){
                ans.add(matrix[x][y]);
                y++;
            }

            //上->下
            while (x < bottom) {
                ans.add(matrix[x][y]);
                x++;
            }

            //右->左
            while (y>left){
                ans.add(matrix[x][y]);
                y--;
            }

            //下->上
            while (x>top){
                ans.add(matrix[x][y]);
                x--;
            }
            x++;
            y++;
            right--;
            left++;
            top++;
            bottom--;
        }
        if (bottom == top && right == left){
            ans.add(matrix[x][y]);
        }else if (bottom == top && right > left){
            while (y<=right){
                ans.add(matrix[x][y++]);
            }
        }else if (bottom > top && right == left){
            while (x<=bottom){
                ans.add(matrix[x++][y]);
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
