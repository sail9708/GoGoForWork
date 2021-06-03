//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。 
//
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
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
// 
// 
// 
// Related Topics 数组 回溯算法 
// 👍 584 👎 0

  
package leetcode.problems.leetcode.editor.cn;

import java.util.*;

public class No_90_SubsetsIi{
    public static void main(String[] args) {
       Solution solution = new No_90_SubsetsIi().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        //本题和78题一样，多了一个去重操作

    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> temp =  new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        //因为要去重，所以得首先给数组排序
        Arrays.sort(nums);

        //本题新增一个used数组，用于去重
        boolean[] used = new boolean[nums.length];

        for (int k = 1; k<=nums.length;k++) {
            backtrack(nums.length, k, nums,0, used);
        }
        res.add(new ArrayList<>());
        return res;
    }

    private void backtrack(int n, int k, int[] nums, int startIndex, boolean[] used) {
        int size = temp.size();
        for (int i = startIndex; i <= n-k+1+size-1; i++ ){

            if (i > startIndex && used[i] == used[i-1] && nums[i] == nums[i-1]){
                continue;
            }
            temp.push(nums[i]);
            used[i] = true;


            if (temp.size()<k){
                backtrack(n,k,nums,i+1, used);
            }
            else {
                res.add(new ArrayList<>(temp));
            }
            temp.pop();
            used[i] = false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
