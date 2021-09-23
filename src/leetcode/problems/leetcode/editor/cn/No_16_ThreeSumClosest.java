//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。 
//
// 
//
// 示例： 
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 10^3 
// -10^3 <= nums[i] <= 10^3 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 双指针 排序 👍 888 👎 0

  
package leetcode.problems.leetcode.editor.cn;

import java.util.*;

public class No_16_ThreeSumClosest{
    public static void main(String[] args) {
       Solution solution = new No_16_ThreeSumClosest().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length;
        Arrays.sort(nums);
        int sum = nums[0]+nums[1]+nums[2];
        for (int idx1 = 0; idx1 < len-2; idx1++){
            for (int idx2 = idx1+1; idx2 < len -1; idx2++){
                for (int idx3 = idx2+1; idx3 < len; idx3++){
                    int temp = nums[idx1]+nums[idx2]+nums[idx3];
                    if (Math.abs(temp-target)<Math.abs(sum-target)){
                        sum = temp;
                        continue;
                    }
                    if(temp > target){
                        break;
                    }
                }
            }
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
