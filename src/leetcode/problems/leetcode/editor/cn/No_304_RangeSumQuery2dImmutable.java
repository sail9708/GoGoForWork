//给定一个二维矩阵 matrix，以下类型的多个请求： 
//
// 
// 计算其子矩形范围内元素的总和，该子矩阵的左上角为 (row1, col1) ，右下角为 (row2, col2) 。 
// 
//
// 实现 NumMatrix 类： 
//
// 
// NumMatrix(int[][] matrix) 给定整数矩阵 matrix 进行初始化 
// int sumRegion(int row1, int col1, int row2, int col2) 返回左上角 (row1, col1) 、右下角
// (row2, col2) 的子矩阵的元素总和。 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: 
//["NumMatrix","sumRegion","sumRegion","sumRegion"]
//[[[[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,0,1,7],[1,0,3,0,5]]],[2,1,4,3],[1,
//1,2,2],[1,2,2,4]]
//输出: 
//[null, 8, 11, 12]
//
//解释:
//NumMatrix numMatrix = new NumMatrix([[3,0,1,4,2],[5,6,3,2,1],[1,2,0,1,5],[4,1,
//0,1,7],[1,0,3,0,5]]]);
//numMatrix.sumRegion(2, 1, 4, 3); // return 8 (红色矩形框的元素总和)
//numMatrix.sumRegion(1, 1, 2, 2); // return 11 (绿色矩形框的元素总和)
//numMatrix.sumRegion(1, 2, 2, 4); // return 12 (蓝色矩形框的元素总和)
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 200 
// -105 <= matrix[i][j] <= 105 
// 0 <= row1 <= row2 < m 
// 0 <= col1 <= col2 < n 
// 最多调用 104 次 sumRegion 方法 
// 
// Related Topics 设计 数组 矩阵 前缀和 
// 👍 297 👎 0

  
package leetcode.problems.leetcode.editor.cn;
public class No_304_RangeSumQuery2dImmutable{
    public static void main(String[] args) {
//       NumMatrix solution = new No_304_RangeSumQuery2dImmutable().new NumMatrix();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class NumMatrix {
    /**
     * 解答成功:
     * 			执行耗时:105 ms,击败了15.24% 的Java用户
     * 			内存消耗:62.4 MB,击败了85.34% 的Java用户
     */
    public int[][] m1;
    public NumMatrix(int[][] matrix) {
//        m1 = new int[matrix.length][matrix[0].length];
        m1 = new int[matrix.length+1][matrix[0].length+1];
        //处理m1
//        for (int i = 1; i < m1.length; i++){
//            m1[i][0]+=m1[i-1][0];
//        }
//        for (int i = 1; i < m1[0].length; i++){
//            m1[0][i]+=m1[0][i-1];
//        }
        for (int i = 1; i < m1.length;i++){
            for (int j =1;j <m1[i].length; j++){
                m1[i][j] = matrix[i-1][j-1]+m1[i-1][j]+m1[i][j-1]-m1[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
//        if (row1 == 0 && col1 == 0){
//            return m1[row2][col2];
//        }
//        if (row1 == 0){
//            return m1[row2][col2]-m1[row2][col1-1];
//        }
//        if (col1 == 0){
//            return m1[row2][col2]-m1[row1-1][col2];
//        }
//        return m1[row2][col2]-m1[row2][col1-1]-m1[row1-1][col2]+m1[row1-1][col1-1];
        return m1[row2+1][col2+1]-m1[row2+1][col1-1+1]-m1[row1-1+1][col2+1]+m1[row1-1+1][col1-1+1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
