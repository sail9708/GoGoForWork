//给你一个二维整数数组 ranges 和两个整数 left 和 right 。每个 ranges[i] = [starti, endi] 表示一个从 star
//ti 到 endi 的 闭区间 。 
//
// 如果闭区间 [left, right] 内每个整数都被 ranges 中 至少一个 区间覆盖，那么请你返回 true ，否则返回 false 。 
//
// 已知区间 ranges[i] = [starti, endi] ，如果整数 x 满足 starti <= x <= endi ，那么我们称整数x 被覆盖了
//。 
//
// 
//
// 示例 1： 
//
// 
//输入：ranges = [[1,2],[3,4],[5,6]], left = 2, right = 5
//输出：true
//解释：2 到 5 的每个整数都被覆盖了：
//- 2 被第一个区间覆盖。
//- 3 和 4 被第二个区间覆盖。
//- 5 被第三个区间覆盖。
// 
//
// 示例 2： 
//
// 
//输入：ranges = [[1,10],[10,20]], left = 21, right = 21
//输出：false
//解释：21 没有被任何一个区间覆盖。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= ranges.length <= 50 
// 1 <= starti <= endi <= 50 
// 1 <= left <= right <= 50 
// 
// Related Topics 数组 哈希表 前缀和 
// 👍 95 👎 0

  
package leetcode.problems.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

public class No_1893_CheckIfAllTheIntegersInARangeAreCovered{
    public static void main(String[] args) {
       Solution solution = new No_1893_CheckIfAllTheIntegersInARangeAreCovered().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        //将ranges先按左端排列，再按右端排列
        Arrays.sort(ranges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]){
                    return o1[0]-o2[0];
                }
                return o1[1]-o2[1];
            }
        });
        int n = ranges.length;
        int l = ranges[0][0];
        int r = ranges[0][1];
        for (int i =1 ; i < n; i++){
            if (ranges[i][0] == l){
                r = ranges[i][1];
                continue;
            }else {
                if (ranges[i][0] <= r + 1) {
                    if (ranges[i][1] > r) {
                        r = ranges[i][1];
                    }
                } else {
                    l = ranges[i][0];
                    r = ranges[i][1];
                }

                if (l>left){
                    return false;
                }
            }
            if (r>=right){
                return true;
            }
        }
        if (r>=right && l<=left){
            return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
