//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 0 <= n <= 3 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 动态规划 
// 👍 2384 👎 0

  
package leetcode.problems.leetcode.editor.cn;
public class No_42_TrappingRainWater{
    public static void main(String[] args) {
       Solution solution = new No_42_TrappingRainWater().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        //本题解法：双指针法
        if (height.length == 0){
            return 0;
        }
        //left为左指针，right为右指针，二者从两头往中间遍历
        int left = 0, right = height.length-1;
        //结果
        int ans = 0;
        //leftmax为左边最高的值，rightmax为右边最高的值
        int leftmax = height[left], rightmax = height[right];
        //当left和right相遇，表示遍历完成，结束
        while (left != right){
            //更新左右最高的值
            leftmax = Math.max(leftmax, height[left]);
            rightmax = Math.max(rightmax, height[right]);
            //如果左边最高的值小于右边最高的值，根据木桶原理，存的水量不能超过左边的，反之同理
            //且哪边的最高高度小，该边就该往中间遍历
            if(leftmax < rightmax){
                //计算当前块可以存水的容量
                ans += leftmax-height[left++];
            }
            else {
                ans += rightmax - height[right--];
            }

        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
