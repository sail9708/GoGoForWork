//给定平面上 n 对 互不相同 的点 points ，其中 points[i] = [xi, yi] 。回旋镖 是由点 (i, j, k) 表示的元组 ，其中
// i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。 
//
// 返回平面上所有回旋镖的数量。 
// 
//
// 示例 1： 
//
// 
//输入：points = [[0,0],[1,0],[2,0]]
//输出：2
//解释：两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
// 
//
// 示例 2： 
//
// 
//输入：points = [[1,1],[2,2],[3,3]]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：points = [[1,1]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// n == points.length 
// 1 <= n <= 500 
// points[i].length == 2 
// -10⁴ <= xi, yi <= 10⁴ 
// 所有点都 互不相同 
// 
// Related Topics 数组 哈希表 数学 👍 144 👎 0

  
package leetcode.problems.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;

public class No_447_NumberOfBoomerangs{
    public static void main(String[] args) {
       Solution solution = new No_447_NumberOfBoomerangs().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 解答成功:
     * 		执行耗时:127 ms,击败了83.67% 的Java用户
     * 		内存消耗:37.9 MB,击败了97.96% 的Java用户
     * @param points
     * @return
     */
    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        int n = points.length;

        for (int i = 0; i < n; i++){
            HashMap< Integer, Integer> map = new HashMap<>();
            for (int j =0; j < n; j++){
                if (i == j){
                    continue;
                }
                int dist = getDist(points[i],points[j] );
                ans+=map.getOrDefault(dist,0)*2;
                map.put(dist, map.getOrDefault(dist,0)+1);

            }
        }
        return ans;
    }

    public int getDist(int[] p1, int[] p2){
        return (p1[0]-p2[0])*(p1[0]-p2[0]) + (p1[1]-p2[1])*(p1[1]-p2[1]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
