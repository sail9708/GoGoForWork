//给定一个由整数数组 A 表示的环形数组 C，求 C 的非空子数组的最大可能和。 
//
// 在此处，环形数组意味着数组的末端将会与开头相连呈环状。（形式上，当0 <= i < A.length 时 C[i] = A[i]，且当 i >= 0 时 
//C[i+A.length] = C[i]） 
//
// 此外，子数组最多只能包含固定缓冲区 A 中的每个元素一次。（形式上，对于子数组 C[i], C[i+1], ..., C[j]，不存在 i <= k1, 
//k2 <= j 其中 k1 % A.length = k2 % A.length） 
//
// 
//
// 示例 1： 
//
// 输入：[1,-2,3,-2]
//输出：3
//解释：从子数组 [3] 得到最大和 3
// 
//
// 示例 2： 
//
// 输入：[5,-3,5]
//输出：10
//解释：从子数组 [5,5] 得到最大和 5 + 5 = 10
// 
//
// 示例 3： 
//
// 输入：[3,-1,2,-1]
//输出：4
//解释：从子数组 [2,-1,3] 得到最大和 2 + (-1) + 3 = 4
// 
//
// 示例 4： 
//
// 输入：[3,-2,2,-3]
//输出：3
//解释：从子数组 [3] 和 [3,-2,2] 都可以得到最大和 3
// 
//
// 示例 5： 
//
// 输入：[-2,-3,-1]
//输出：-1
//解释：从子数组 [-1] 得到最大和 -1
// 
//
// 
//
// 提示： 
//
// 
// -30000 <= A[i] <= 30000 
// 1 <= A.length <= 30000 
// 
// Related Topics 队列 数组 分治 动态规划 单调队列 
// 👍 174 👎 0

  
package leetcode.problems.leetcode.editor.cn;

import java.util.Arrays;

public class No_918_MaximumSumCircularSubarray{
    public static void main(String[] args) {
       Solution solution = new No_918_MaximumSumCircularSubarray().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * @ program: leet-code
     * @ description: 918.环形子数组的最大和
     * 根据题解可知：
     *    环形子数组的最大和具有两种可能，一种是不使用环的情况，另一种是使用环的情况
     *      不使用环的情况时，直接通过53题的思路，逐步求出整个数组中的最大子序和即可
     *      使用到了环，则必定包含 A[n-1]和 A[0]两个元素且说明从A[1]到A[n-2]这个子数组中必定包含负数
     *      【否则只通过一趟最大子序和就可以的出结果】
     *    因此只需要把A[1]-A[n-2]间这些负数的最小和求出来
     *    用整个数组的和 sum减掉这个负数最小和即可实现原环型数组的最大和
     **/
    public int maxSubarraySumCircular(int[] nums) {

        int dp = nums[0];
        int max = dp;
        int sum = dp;

        for (int i = 1; i < nums.length; i++){
            sum+=nums[i];
            dp = nums[i] + Math.max(0, dp);
            max = Math.max(dp, max);
        }

        dp = nums[0];
        int min = dp;
        for (int i = 1; i < nums.length-1; i++){
            dp = nums[i]+Math.min(0, dp);
            min = Math.min(dp, min);
        }
        if (min == max){
            return max;
        }
        return  Math.max(max, sum-min);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
