//给定一个含有 n 个正整数的数组和一个正整数 target 。 
//
// 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长
//度。如果不存在符合条件的子数组，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：target = 7, nums = [2,3,1,2,4,3]
//输出：2
//解释：子数组 [4,3] 是该条件下的长度最小的子数组。
// 
//
// 示例 2： 
//
// 
//输入：target = 4, nums = [1,4,4]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：target = 11, nums = [1,1,1,1,1,1,1,1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target <= 109 
// 1 <= nums.length <= 105 
// 1 <= nums[i] <= 105 
// 
//
// 
//
// 进阶： 
//
// 
// 如果你已经实现 O(n) 时间复杂度的解法, 请尝试设计一个 O(n log(n)) 时间复杂度的解法。 
// 
// Related Topics 数组 双指针 二分查找 
// 👍 661 👎 0

  
package leetcode.problems.leetcode.editor.cn;
public class No_209_MinimumSizeSubarraySum{
    public static void main(String[] args) {
       Solution solution = new No_209_MinimumSizeSubarraySum().new Solution();
       solution.minSubArrayLen(7, new int[]{2,3,1,2,4,3});
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 初见思路：双指针（滑动窗口），如果窗口内和小于target，窗口有边界右移一位；如果窗口内和大于等于target，窗口左边界右移一位；
     * 总的时间复杂度为O(n),空间复杂度为O(1)
     *			解答成功:
     * 			执行耗时:2 ms,击败了83.64% 的Java用户
     * 			内存消耗:38.3 MB,击败了76.61% 的Java用户
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0, right =0;
        int sum = 0;
        int length = 0;
        boolean flag = true;

        while (right<n && left<=right){
            if (flag){
                sum+=nums[right];
            }
            if (sum>=target){
                if (length == 0){
                    length = right-left+1;
                }else {
                     length = Math.min(right-left+1, length);
                }
                sum-=nums[left];
                left++;
                flag=false;
            }else {
                right++;
                flag = true;
            }
        }
        return length;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
