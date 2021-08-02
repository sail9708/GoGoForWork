//给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。 
//
// 请你找出符合题意的 最短 子数组，并输出它的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：nums = [2,6,4,8,10,9,15]
//输出：5
//解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 104 
// -105 <= nums[i] <= 105 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？ 
// 
// 
// Related Topics 栈 贪心 数组 双指针 排序 单调栈 
// 👍 589 👎 0

  
package leetcode.problems.leetcode.editor.cn;

import java.util.Arrays;

public class No_581_ShortestUnsortedContinuousSubarray{
    public static void main(String[] args) {
       Solution solution = new No_581_ShortestUnsortedContinuousSubarray().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 初见思路：先对数组进行排序，在和原数组进行对比
     * @param nums
     * @return
     */
    public int findUnsortedSubarray(int[] nums) {
        int[] numsSorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(numsSorted);
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            if (nums[left] != numsSorted[left] && nums[right] != numsSorted[right]){
                break;
            }else {
                if (nums[left] == numsSorted[left]) {
                    left++;
                }
                if (nums[right] == numsSorted[right]) {
                    right--;
                }
            }
        }
        if (left>=right){
            return 0;
        }else {
            return right-left+1;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
