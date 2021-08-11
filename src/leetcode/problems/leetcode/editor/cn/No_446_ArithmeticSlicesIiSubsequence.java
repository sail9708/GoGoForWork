//给你一个整数数组 nums ，返回 nums 中所有 等差子序列 的数目。 
//
// 如果一个序列中 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该序列为等差序列。 
//
// 
// 例如，[1, 3, 5, 7, 9]、[7, 7, 7, 7] 和 [3, -1, -5, -9] 都是等差序列。 
// 再例如，[1, 1, 2, 5, 7] 不是等差序列。 
// 
//
// 数组中的子序列是从数组中删除一些元素（也可能不删除）得到的一个序列。 
//
// 
// 例如，[2,5,10] 是 [1,2,1,2,4,1,5,10] 的一个子序列。 
// 
//
// 题目数据保证答案是一个 32-bit 整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,4,6,8,10]
//输出：7
//解释：所有的等差子序列为：
//[2,4,6]
//[4,6,8]
//[6,8,10]
//[2,4,6,8]
//[4,6,8,10]
//[2,4,6,8,10]
//[2,6,10]
// 
//
// 示例 2： 
//
// 
//输入：nums = [7,7,7,7,7]
//输出：16
//解释：数组中的任意子序列都是等差子序列。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// -231 <= nums[i] <= 231 - 1 
// 
// Related Topics 数组 动态规划 
// 👍 131 👎 0


package leetcode.problems.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class No_446_ArithmeticSlicesIiSubsequence {
    public static void main(String[] args) {
        Solution solution = new No_446_ArithmeticSlicesIiSubsequence().new Solution();
        solution.numberOfArithmeticSlices(new int[]{2, 4, 6, 8, 10});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 动态规划：nums[i]结尾的等差序列，是nums[j]结尾的公差和nums[i]-nums[j]相等的等差序列的个数
         */
        public int numberOfArithmeticSlices(int[] nums) {
            int res = 0;
            int len = nums.length;
            if (len < 3) {
                return 0;
            }
            Map<Long, Integer>[] map = new Map[len];
            for (int i = 0; i < len; i++) {
                map[i] = new HashMap<>();
            }
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < i; j++) {
                    long diff = (long) nums[i] - nums[j];
                    int cnt = map[j].getOrDefault(diff, 0);
                    res += cnt;
                    //此处cnt+1，是因为实际map存储的包括二元的弱等差序列，所以此时要加上nums[i]和nums[j]组成的弱等差序列，所以药+1
                    map[i].put(diff, map[i].getOrDefault(diff, 0) + cnt + 1);
                }
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
