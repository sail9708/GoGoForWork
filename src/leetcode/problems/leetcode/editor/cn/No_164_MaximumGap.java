//给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。 
//
// 如果数组元素个数小于 2，则返回 0。 
//
// 示例 1: 
//
// 输入: [3,6,9,1]
//输出: 3
//解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。 
//
// 示例 2: 
//
// 输入: [10]
//输出: 0
//解释: 数组元素个数小于 2，因此返回 0。 
//
// 说明: 
//
// 
// 你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。 
// 请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。 
// 
// Related Topics 数组 桶排序 基数排序 排序 
// 👍 391 👎 0

  
package leetcode.problems.leetcode.editor.cn;

import java.util.Arrays;

public class No_164_MaximumGap{
    public static void main(String[] args) {
       Solution solution = new No_164_MaximumGap().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 使用基数排序，时间复杂度为O(N*k)
     * @param nums
     * @return
     */
    public int maximumGap(int[] nums) {
        int len = nums.length;
        //数组的长度若小于2，则直接返回0
        if (len < 2){
            return 0;
        }

        //下面对数组进行基数排序（使用的是LSD，也可使用MSD）
        //buf数组用来存储每一轮排序后的数组
        int[] buf = new int[len];
        //exp为用来获取每一位上的数字
        int exp = 1;
        //获取nums数组中的最大值
        int maxVal = Arrays.stream(nums).max().getAsInt();

        while (maxVal >= exp){
            //用于计数
            int[] cnt = new int[10];
            //获得nums数组中所有数在每一位上，在0-9出现的次数
            for (int i = 0; i < len; i++){
                int digit = (nums[i]/exp)%10;
                cnt[digit]++;
            }
            //累加得到，nums中所有数在该位上小于等于【0-9】数的个数
            // 如cnt[1]==2,表示nums所有数该位上小于等于1的数有两个
            //用途：用来确定后续在buf中填充这一轮排序后的数的位置
            for (int i = 1; i < 10; i++){
                cnt[i]+=cnt[i-1];
            }
            //在buf数组中插入该轮排序后的数组
            for (int i = len-1; i >= 0; i--){
                int digit = (nums[i] / exp)%10;
                buf[cnt[digit]-1] = nums[i];
                cnt[digit]--;
            }
            //将这一轮排序后的buf复制到nums中，进行下一轮排序
            System.arraycopy(buf,0,nums,0,len);
            //exp*10，在下一轮排序中取下一位的值
            exp*=10;
        }

        //贪心获取最大插值
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < len; i++){
            res = Math.max(res, nums[i] - nums[i-1]);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
