//在有向图中，以某个节点为起始节点，从该点出发，每一步沿着图中的一条有向边行走。如果到达的节点是终点（即它没有连出的有向边），则停止。 
//
// 对于一个起始节点，如果从该节点出发，无论每一步选择沿哪条有向边行走，最后必然在有限步内到达终点，则将该起始节点称作是 安全 的。 
//
// 返回一个由图中所有安全的起始节点组成的数组作为答案。答案数组中的元素应当按 升序 排列。 
//
// 该有向图有 n 个节点，按 0 到 n - 1 编号，其中 n 是 graph 的节点数。图以下述形式给出：graph[i] 是编号 j 节点的一个列表，
//满足 (i, j) 是图的一条有向边。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：graph = [[1,2],[2,3],[5],[0],[5],[],[]]
//输出：[2,4,5,6]
//解释：示意图如上。
// 
//
// 示例 2： 
//
// 
//输入：graph = [[1,2,3,4],[1,2],[3,4],[0,4],[]]
//输出：[4]
// 
//
// 
//
// 提示： 
//
// 
// n == graph.length 
// 1 <= n <= 104 
// 0 <= graph[i].length <= n 
// graph[i] 按严格递增顺序排列。 
// 图中可能包含自环。 
// 图中边的数目在范围 [1, 4 * 104] 内。 
// 
// 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 
// 👍 150 👎 0

  
package leetcode.problems.leetcode.editor.cn;

import java.util.*;

public class No_802_FindEventualSafeStates{
    public static void main(String[] args) {
       Solution solution = new No_802_FindEventualSafeStates().new Solution();
       solution.eventualSafeNodes(new int[][]{{4,9},{3,5,7},{0,3,4,5,6,8},{7,8,9},{5,6,7,8},{6,7,8,9},{7,9},{8,9},{9},{}});
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 根据官方题解优化
     *解答成功:
     * 		执行耗时:4 ms,击败了100.00% 的Java用户
     * 		内存消耗:48.1 MB,击败了57.37% 的Java用户
     * @param graph
     * @return
     */
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        //0为未遍历，1为安全，2为不安全
        int[] colors = new int[n];
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++){
            if (dfs2(graph, colors, i)){
                res.add(i);
            }
        }
        return res;
    }

    public boolean dfs2(int[][] graph, int[] colors, int i){
        if (colors[i] == 2){
            return false;
        }
        if (colors[i] == 1){
            return true;
        }
        colors[i] = 2;
        for (int j : graph[i]){
            if (!dfs2(graph,colors,j)){
                return false;
            }
        }
        colors[i] =1;
        return true;
    }

    /**
     * 初见, 思路和官方题解完全一样，实现有差异，性能没有官方好
     * 解答成功:
     * 		执行耗时:24 ms,击败了42.90% 的Java用户
     * 		内存消耗:47 MB,击败了90.08% 的Java用户
     * @param graph
     * @return
     */
    public List<Integer> eventualSafeNodes1(int[][] graph) {
        HashSet<Integer> res = new HashSet<>();
        HashSet<Integer> set = new HashSet<>();
        int n = graph.length;
        for (int i =0; i < n; i++) {
            dfs(i, graph, set, res);
        }
        List<Integer> resList = new ArrayList<>();
        for (int i : res){
            resList.add(i);
        }
        Collections.sort(resList);
        return resList;
    }

    public boolean dfs(int i, int[][] graph, HashSet<Integer> set, HashSet<Integer> res){
        //如果包含，说明有环，不是安全节点
        if (set.contains(i)){
            return false;
        }
        if (res.contains(i)){
            return true;
        }
        //将当前节点加入set
        set.add(i);
        boolean rt = true;
        int len = graph[i].length;
        for (int j = 0; j< len; j++){
            if (!dfs(graph[i][j], graph, set, res)){
                rt = false;
            }
        }
        //说明该节点是安全的
        if (rt){
            set.remove(i);
            res.add(i);
        }
        return rt;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
