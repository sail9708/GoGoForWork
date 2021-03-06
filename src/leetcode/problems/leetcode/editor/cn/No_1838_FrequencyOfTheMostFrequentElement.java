//元素的 频数 是该元素在一个数组中出现的次数。 
//
// 给你一个整数数组 nums 和一个整数 k 。在一步操作中，你可以选择 nums 的一个下标，并将该下标对应元素的值增加 1 。 
//
// 执行最多 k 次操作后，返回数组中最高频元素的 最大可能频数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,4], k = 5
//输出：3
//解释：对第一个元素执行 3 次递增操作，对第二个元素执 2 次递增操作，此时 nums = [4,4,4] 。
//4 是数组中最高频元素，频数是 3 。 
//
// 示例 2： 
//
// 
//输入：nums = [1,4,8,13], k = 5
//输出：2
//解释：存在多种最优解决方案：
//- 对第一个元素执行 3 次递增操作，此时 nums = [4,4,8,13] 。4 是数组中最高频元素，频数是 2 。
//- 对第二个元素执行 4 次递增操作，此时 nums = [1,8,8,13] 。8 是数组中最高频元素，频数是 2 。
//- 对第三个元素执行 5 次递增操作，此时 nums = [1,4,13,13] 。13 是数组中最高频元素，频数是 2 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,9,6], k = 2
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// 1 <= nums[i] <= 105 
// 1 <= k <= 105 
// 
// Related Topics 数组 二分查找 前缀和 滑动窗口 
// 👍 51 👎 0

  
package leetcode.problems.leetcode.editor.cn;

import java.util.Arrays;

public class No_1838_FrequencyOfTheMostFrequentElement{
    public static void main(String[] args) {
       Solution solution = new No_1838_FrequencyOfTheMostFrequentElement().new Solution();
       solution.maxFrequency(new int[]{1,2,4}, 5);
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 方法 ： 排序后使用滑动窗口
     * @param nums
     * @param k
     * @return
     */
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        int left=0,right=1;
        int ans=1;
        while(right<n)
        {
            k-=((nums[right]-nums[right-1])*(right-left));
            if(k>=0)
            {
                ans=right-left+1;//符合题意的答案
            }
            else{
                //不符合题意的答案，left要相应右移一位
                left++;
                k+=(nums[right]-nums[left-1]);
            }
            right++;//right是一直右移的
        }
        return ans;

    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
