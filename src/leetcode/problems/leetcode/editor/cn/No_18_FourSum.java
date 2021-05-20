//给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c +
// d 的值与 target 相等？找出所有满足条件且不重复的四元组。 
//
// 注意：答案中不可以包含重复的四元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [], target = 0
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 200 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 
// Related Topics 数组 哈希表 双指针 
// 👍 855 👎 0

  
package leetcode.problems.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No_18_FourSum{
    public static void main(String[] args) {
       Solution solution = new No_18_FourSum().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //先给数组排序
        Arrays.sort(nums);
        //创建结果列表
        List<List<Integer>> result = new ArrayList();
        //存储四数相加之和
        int sum;

        //
        for(int i = 0; i < nums.length - 3; i++){
            //避免获取重复结果
            if(i > 0 && nums[i] == nums[i-1]){ continue; }

            for(int j = i + 1; j < nums.length-2; j++){
                //避免获取重复结果
                if(j > i + 1 && nums[j] == nums[j-1]){ continue; }
                //左右指针
                int left = j + 1;
                int right = nums.length - 1;

                while(left < right){
                    sum = nums[i]+ nums[j]+ nums[left]+ nums[right];
                    if( sum > target){
                        right--;
                    }
                    else if( sum < target){
                        left++;
                    }
                    else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while( left < right && nums[left] == nums[left+1]) {
                            left++;
                        }
                        while( left < right && nums[right] == nums[right-1]) {
                            right--;
                        }
                        left++;
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
