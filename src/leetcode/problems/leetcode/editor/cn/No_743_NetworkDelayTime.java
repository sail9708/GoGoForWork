//有 n 个网络节点，标记为 1 到 n。 
//
// 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， w
//i 是一个信号从源节点传递到目标节点的时间。 
//
// 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：times = [[1,2,1]], n = 2, k = 1
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：times = [[1,2,1]], n = 2, k = 2
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= n <= 100 
// 1 <= times.length <= 6000 
// times[i].length == 3 
// 1 <= ui, vi <= n 
// ui != vi 
// 0 <= wi <= 100 
// 所有 (ui, vi) 对都 互不相同（即，不含重复边） 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 最短路 堆（优先队列） 
// 👍 288 👎 0

  
package leetcode.problems.leetcode.editor.cn;
public class No_743_NetworkDelayTime{
    public static void main(String[] args) {
       Solution solution = new No_743_NetworkDelayTime().new Solution();
       solution.networkDelayTime(new int[][]{{2,4,10},{5,2,38},{3,4,33},{4,2,76},{3,2,64},{1,5,54},{1,4,98},{2,3,61},{2,1,0},{3,5,77},{5,1,34},{3,1,79},{5,3,2},{1,2,59},{4,3,46},{5,4,44},{2,5,89},{4,5,21},{1,3,86},{4,1,95}}
        ,5,1);
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 初见思路：DisjKstra
     * @param times
     * @param n
     * @param k
     * @return
     */
    public int networkDelayTime(int[][] times, int n, int k) {
        //所有节点收到信号的时间
        int allTime = 0;
        //先构造有向图的邻接矩阵，0为不连通，非0为传递时间
        int[][] graph = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j){
                    graph[i][j] = 0;
                }else {
                    graph[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for (int i = 0; i < times.length; i++){
            int source = times[i][0];
            int target = times[i][1];
            int time = times[i][2];
            graph[source][target] = time;
        }
        boolean[] used = new boolean[n+1];
        int[] dis = new int[n+1];
        for (int i = 1; i <= n; i++){
            dis[i] = graph[k][i];
        }
        used[k] = true;
        int mark = k;
        for (int i =0; i < n; i++){
            int min = Integer.MAX_VALUE;

            //找到目前到源点最短的点，固定下来
            for (int j =1; j <=n ;j++){
                if (!used[j] && dis[j]<min){
                    mark = j;
                    min = dis[j];
                }
            }
            used[mark] = true;

            //松弛，以新固定的点来更新其他点的距离
            for (int j = 1; j <=n; j++){
                if (graph[mark][j]<Integer.MAX_VALUE){
                    if (dis[j]>min+graph[mark][j]){
                        dis[j]=min+graph[mark][j];
                    }
                }
            }
        }
        for (int i = 1; i <= n; i++){
            if (dis[i] == Integer.MAX_VALUE){
                return -1;
            }
            allTime = Math.max(allTime, dis[i]);
        }
        return allTime;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
