//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 回溯算法 
// 👍 1379 👎 0

  
package leetcode.problems.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class No_46_Permutations{
    public static void main(String[] args) {
       Solution solution = new No_46_Permutations().new Solution();
       solution.permute(new int[]{1,2,3});
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    //结果存储
    List<List<Integer>> result = new ArrayList<>();
    //栈
    Deque<Integer> temp = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        //判断nums里的各数是否已经使用
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used);
        return result;
    }

    public void backtrack(int[] nums, boolean[] used){
        if (temp.size() == nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i  = 0; i < nums.length; i++){
            if (used[i] == true){
                continue;
            }

            temp.push(nums[i]);
            used[i] = true;
            backtrack(nums, used);
            temp.pop();
            used[i] = false;

        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
