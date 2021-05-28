//给定一个非负整数数组，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。 
//
// 假设你总是可以到达数组的最后一个位置。 
//
// 
//
// 示例 1: 
//
// 
//输入: [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 示例 2: 
//
// 
//输入: [2,3,0,1,4]
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 105 
// 
// Related Topics 贪心算法 数组 
// 👍 991 👎 0

  
package leetcode.problems.leetcode.editor.cn;
public class No_45_JumpGameIi{
    public static void main(String[] args) {
       Solution solution = new No_45_JumpGameIi().new Solution();
       solution.jump(new int[]{2,3,1,1,4});
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int jump(int[] nums) {

        //本题用贪心算法，局部最优得到全局最优
        //
        if (nums.length == 0 || nums.length == 1 || nums == null){
            return 0;
        }
        //步数
        int step = 0;
        //当前覆盖范围
        int curDistance = 0;
        //最大覆盖范围
        int maxDistance = 0;

        for (int i = 0; i < nums.length; i++){
            maxDistance = Math.max(maxDistance, i+nums[i]);

            //如果最大覆盖范围直接超过数组长度，说明可以直接到达
            if (maxDistance >= nums.length-1){
                step++;
                break;
            }
            //如果在当前步的最大覆盖范围内的后续覆盖范围都已计算完毕，则记录最大覆盖范围
            if (curDistance == i){
                curDistance = maxDistance;
                step++;
            }

        }

        return step;


    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
