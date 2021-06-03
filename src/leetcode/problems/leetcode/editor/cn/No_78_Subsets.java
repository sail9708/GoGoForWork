//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯算法 
// 👍 1205 👎 0

  
package leetcode.problems.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class No_78_Subsets{
    public static void main(String[] args) {
       Solution solution = new No_78_Subsets().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        //本题初见思路
        //运用第77题中的组合代码，因为数组nums中的数各不相同，所以就是将第77题中的k设置为从1到n

    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> temp = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        for (int k = 1; k<=nums.length;k++) {
            backtrack(nums.length, k, nums,0);
        }
        res.add(new ArrayList<>());
        return res;
    }

    public void backtrack(int n, int k, int[] nums, int startIndex){
        int size = temp.size();
        for (int i = startIndex; i <= n-k+1+size-1; i++ ){
            temp.push(nums[i]);
            if (temp.size()<k){
                backtrack(n,k,nums,i+1);
            }
            else {
                res.add(new ArrayList<>(temp));
            }
            temp.pop();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
