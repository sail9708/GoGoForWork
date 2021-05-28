//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 回溯算法 
// 👍 707 👎 0

  
package leetcode.problems.leetcode.editor.cn;

import java.util.*;

public class No_47_PermutationsIi{
    public static void main(String[] args) {
       Solution solution = new No_47_PermutationsIi().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    //结果存储
    List<List<Integer>> result = new ArrayList<>();
    //栈
    Deque<Integer> temp = new LinkedList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        //定义used数组
        boolean[] used = new boolean[nums.length];
        //给数组排个序
        Arrays.sort(nums);
        backtrack(nums, used);
        return result;
    }

    private void backtrack(int[] nums, boolean[] used) {
        if (temp.size() == nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0;i< nums.length;i++){
            //在相同位上，跳过相同的数
            if (i > 0 && nums[i]==nums[i-1] && !used[i-1]){
                continue;
            }

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
