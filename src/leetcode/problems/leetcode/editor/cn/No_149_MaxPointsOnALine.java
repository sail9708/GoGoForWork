//给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。 
//
// 
//
// 示例 1： 
//
// 
//输入：points = [[1,1],[2,2],[3,3]]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= points.length <= 300 
// points[i].length == 2 
// -104 <= xi, yi <= 104 
// points 中的所有点 互不相同 
// 
// Related Topics 几何 哈希表 数学 
// 👍 335 👎 0

  
package leetcode.problems.leetcode.editor.cn;

import java.util.HashMap;

public class No_149_MaxPointsOnALine{
    public static void main(String[] args) {
       Solution solution = new No_149_MaxPointsOnALine().new Solution();
       solution.maxPoints(new int[][]{{1,1},{2,2},{3,3}});
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 初见思路：分别统计过某一点的直线上最多有多少个点。
     * 即分别将这些点与其他点连线，看他们斜率是否相同（为了避免斜率不存在的情况，判断(x1-x2)*(y3-y4) == (y1-y2)*(x3-x4)
     *
     * 解答成功:
     * 			执行耗时:4 ms,击败了97.83% 的Java用户
     * 			内存消耗:37.7 MB,击败了74.11% 的Java用户
     *
     * @param points
     * @return
     */
    public int maxPoints(int[][] points) {
        if (points.length < 3){
            return points.length;
        }
        int res = 2;
        for (int i = 0; i < points.length-1; i++){
            //存取该点与其余各点的斜率（实际上是横坐标与纵坐标的差值）
            int[][] _x_y = new int[points.length-i-1][2];
            for (int j = i+1; j < points.length; j++){
                _x_y[j-i-1][0] = points[i][0]-points[j][0];
                _x_y[j-i-1][1] = points[i][1] - points[j][1];
            }
            //得到具有相同斜率最多的点的数量
            for (int k = 0; k < _x_y.length-1; k++){
                int temp = 2;
                for (int l = k+1; l < _x_y.length; l++){
                    if (_x_y[k][0]*_x_y[l][1] == _x_y[k][1]*_x_y[l][0]){
                        temp++;
                    }
                }
                res = Math.max(res, temp);
            }
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
