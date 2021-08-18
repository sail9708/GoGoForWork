//如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。 
//
// 
// 例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。 
// 
//
// 
// 
// 给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。 
//
// 子数组 是数组中的一个连续序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,4]
//输出：3
//解释：nums 中有三个子等差数组：[1, 2, 3]、[2, 3, 4] 和 [1,2,3,4] 自身。
// 
//
// 示例 2： 
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
// 1 <= nums.length <= 5000 
// -1000 <= nums[i] <= 1000 
// 
// 
// 
// Related Topics 数组 动态规划 
// 👍 267 👎 0

  
package leetcode.problems.leetcode.editor.cn;
public class No_413_ArithmeticSlices{
    public static void main(String[] args) {
       Solution solution = new No_413_ArithmeticSlices().new Solution();
       solution.numberOfArithmeticSlices(new int[]{1,2,3,8,9,10});
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;
        if (len < 3){
            return 0;
        }
        int res = 0;
        for (int i =0; i < len-2; i++){
            int diff = nums[i+1]-nums[i];
            for (int j = i+2; j <len; j++){
                if (diff != nums[j]-nums[j-1]){
                    res+=getCount(j-i);
                    i = j-2;
                    break;
                }
                if (j == len-1){
                    res+=getCount(j-i+1);
                    i = j;
                }
            }
        }
        return res;
    }
    public int getCount(int len){
        if (len < 3){
            return 0;
        }
        int rt = 0;
        for (int i = 3; i <= len; i++){
            rt+=len-i+1;
        }
        return rt;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
