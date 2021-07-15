//城市的天际线是从远处观看该城市中所有建筑物形成的轮廓的外部轮廓。给你所有建筑物的位置和高度，请返回由这些建筑物形成的 天际线 。 
//
// 每个建筑物的几何信息由数组 buildings 表示，其中三元组 buildings[i] = [lefti, righti, heighti] 表示： 
//
//
// 
// lefti 是第 i 座建筑物左边缘的 x 坐标。 
// righti 是第 i 座建筑物右边缘的 x 坐标。 
// heighti 是第 i 座建筑物的高度。 
// 
//
// 天际线 应该表示为由 “关键点” 组成的列表，格式 [[x1,y1],[x2,y2],...] ，并按 x 坐标 进行 排序 。关键点是水平线段的左端点。
//列表中最后一个点是最右侧建筑物的终点，y 坐标始终为 0 ，仅用于标记天际线的终点。此外，任何两个相邻建筑物之间的地面都应被视为天际线轮廓的一部分。 
//
// 注意：输出天际线中不得有连续的相同高度的水平线。例如 [...[2 3], [4 5], [7 5], [11 5], [12 7]...] 是不正确的答
//案；三条高度为 5 的线应该在最终输出中合并为一个：[...[2 3], [4 5], [12 7], ...] 
//
// 
//
// 示例 1： 
//
// 
//输入：buildings = [[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
//输出：[[2,10],[3,15],[7,12],[12,0],[15,10],[20,8],[24,0]]
//解释：
//图 A 显示输入的所有建筑物的位置和高度，
//图 B 显示由这些建筑物形成的天际线。图 B 中的红点表示输出列表中的关键点。 
//
// 示例 2： 
//
// 
//输入：buildings = [[0,2,3],[2,5,3]]
//输出：[[0,3],[5,0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= buildings.length <= 104 
// 0 <= lefti < righti <= 231 - 1 
// 1 <= heighti <= 231 - 1 
// buildings 按 lefti 非递减排序 
// 
// Related Topics 树状数组 线段树 数组 分治 有序集合 扫描线 堆（优先队列） 
// 👍 510 👎 0

  
package leetcode.problems.leetcode.editor.cn;

import java.util.*;
import java.util.Map.Entry;

public class No_218_TheSkylineProblem{
    public static void main(String[] args) {
       Solution solution = new No_218_TheSkylineProblem().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 初见思路：这题有点懵，没有初见思路
     * 参考答案思路：妙啊！
     *
     * @param buildings
     * @return
     */
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        //记录所有矩形的左右顶点
        List<int[]> points = new ArrayList<>();
        //记录，并预处理（这个预处理妙啊）
        //分别记录左右顶点的横坐标值和高度，
        //若是左顶点，高度取负值，用以区分左右顶点
        for(int[] i:buildings){
            int l = i[0];
            int r = i[1];
            int h = i[2];
            points.add(new int[]{l,-h});
            points.add(new int[]{r,h});
        }
        //对所有顶点进行排序
        Collections.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]!=o2[0]){
                    return o1[0]-o2[0];
                }
                return o1[1]-o2[1];
            }
        });

        //建立一个优先队列（最大根堆堆），来保证可以拿到当前最高的高度
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        int prev = 0;
        pq.add(prev);

        for (int[] i:points){
            int point = i[0];
            int height = i[1];
            if(height<0){
                //表示是左顶点，从该节点开始有高度为height的线衍生到右顶点处
                pq.add(-height);
            }else{
                //表示是右节点,说明该height的线衍生到此结束了，删除该高度
                pq.remove(height);
            }
            //当前的最大高度
            int cur = pq.peek();
            //如果当前的最大高度大于先前的最大高度，则说明该点没有被遮挡，可以记录下来
            if(cur!=prev){
                List<Integer> p = new ArrayList<>();
                p.add(point);
                p.add(cur);
                prev = cur;
                res.add(p);
            }
        }
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
