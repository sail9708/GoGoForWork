//给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
// Related Topics 数组 
// 👍 425 👎 0

  
package leetcode.problems.leetcode.editor.cn;
public class No_59_SpiralMatrixIi{
    public static void main(String[] args) {
       Solution solution = new No_59_SpiralMatrixIi().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int num = 1;
        int startX = 0;
        int startY = 0;

        for (int i = n-1; i>=0; i-=2){

            if (i > 0 ){
                //螺旋一圈
                //上边 从左到右 左闭右开
                for (int j = 0; j < i; j++){
                    result[startX][startY++] = num++;
                }
                //右边 从上到下 上闭下开
                for (int j = 0; j < i; j++){
                    result[startX++][startY] = num++;
                }
                //下边 从右到左 右闭左开
                for (int j = 0; j < i; j++){
                    result[startX][startY--] = num++;
                }
                //左边 从下到上 下闭上开
                for (int j = 0; j < i; j++){
                    result[startX--][startY] = num++;
                }
                startX++;
                startY++;
            }
            else {
                result[startX][startY] = num;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
