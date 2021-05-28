//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 104 
// 
// Related Topics 排序 数组 
// 👍 948 👎 0

  
package leetcode.problems.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class No_56_MergeIntervals{
    public static void main(String[] args) {
       Solution solution = new No_56_MergeIntervals().new Solution();
       solution.merge(new int[][]{{2,6},{1,3},{8,10},{15,18}});
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();

        //重写
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]!=o2[0]){
                    return Integer.compare(o1[0],o2[0]);
                }else{
                    return Integer.compare(o1[1],o2[1]);
                }
            }
        });

        int[] temp = new int[]{intervals[0][0],intervals[0][1]};

        for (int i = 0; i < intervals.length; i++){
            if (intervals[i][0]<=temp[1]){
                if (intervals[i][1]>=temp[1]){
                    temp[1] = intervals[i][1];
                }
            }else {
                res.add(new int[]{temp[0],temp[1]});
                temp[0] = intervals[i][0];
                temp[1] = intervals[i][1];
            }
        }
        res.add(new int[]{temp[0],temp[1]});

        return res.toArray(new int[res.size()][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
