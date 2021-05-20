//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 
// 👍 3355 👎 0

  
package leetcode.problems.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No_15_ThreeSum{
    public static void main(String[] args) {
       Solution solution = new No_15_ThreeSum().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);
            for(int i = 0; i < nums.length; i++){
                if(nums[i] > 0){
                    return result;
                }

                if (i>0 && nums[i]==nums[i-1]){
                    continue;
                }

                int left = i+1;
                int right = nums.length-1;
                while(right>left){
                    int sum = nums[i]+nums[right]+nums[left];
                    if( sum == 0){
                        result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        while (right > left && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        while (right > left && nums[left] == nums[left + 1]) {
                            left++;
                        }

                        right--;
                        left++;
                    }
                    else if(sum < 0){
                        left++;
                    }
                    else if(sum > 0){
                        right--;
                    }

                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
