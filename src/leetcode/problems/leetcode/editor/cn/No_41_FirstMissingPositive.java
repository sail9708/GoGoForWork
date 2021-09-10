//给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。 
//请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,0]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,4,-1,1]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,8,9,11,12]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10⁵ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
// Related Topics 数组 哈希表 👍 1198 👎 0


package leetcode.problems.leetcode.editor.cn;

import java.util.HashSet;

public class No_41_FirstMissingPositive {
    public static void main(String[] args) {
        Solution solution = new No_41_FirstMissingPositive().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 官方题解：打标记 具体参照：https://leetcode-cn.com/problems/first-missing-positive/solution/que-shi-de-di-yi-ge-zheng-shu-by-leetcode-solution/
         * 解答成功:
         * 			执行耗时:2 ms,击败了91.23% 的Java用户
         * 			内存消耗:94.6 MB,击败了48.74% 的Java用户
         * 		时间：O(n)  额外空间：O(1)
         */
        public int firstMissingPositive(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < n; ++i) {
                if (nums[i] <= 0) {
                    nums[i] = n + 1;
                }
            }
            for (int i = 0; i < n; ++i) {
                int num = Math.abs(nums[i]);
                if (num <= n) {
                    nums[num - 1] = -Math.abs(nums[num - 1]);
                }
            }
            for (int i = 0; i < n; ++i) {
                if (nums[i] > 0) {
                    return i + 1;
                }
            }
            return n + 1;
        }


        /**
         * 初见思路：最笨办法，并没有满足题目要求的 常数级 空间复杂度
         * 解答成功:
         * 执行耗时:23 ms,击败了10.75% 的Java用户
         * 内存消耗:99.7 MB,击败了5.05% 的Java用户
         *
         * @param nums
         * @return
         */
        public int firstMissingPositive1(int[] nums) {
            HashSet<Integer> set = new HashSet<>();
            for (int i : nums) {
                set.add(i);
            }
            for (int i = 1; i <= nums.length; i++) {
                if (!set.contains(i)) {
                    return i;
                }
            }
            return nums.length + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
