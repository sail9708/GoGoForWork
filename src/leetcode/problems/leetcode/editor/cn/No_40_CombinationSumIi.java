//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 说明： 
//
// 
// 所有数字（包括目标数）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//] 
// Related Topics 数组 回溯算法 
// 👍 589 👎 0

  
package leetcode.problems.leetcode.editor.cn;

import java.util.*;

public class No_40_CombinationSumIi{
    public static void main(String[] args) {
       Solution solution = new No_40_CombinationSumIi().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        List<List<Integer>> result = new ArrayList<>();
        Deque<Integer> temp = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        boolean[] flag = new boolean[candidates.length];
        backtrack(candidates,target,0,flag);
        return result;
    }

    public void backtrack(int[] candidates, int target, int startIndex, boolean[] flag){
        if(target<0){
            return;
        }
        if (target == 0){
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = startIndex; i< candidates.length; i++){
            if (i>0 && candidates[i]==candidates[i-1] && !flag[i-1]){
                flag[i] = false;
                continue;
            }
            flag[i] = true;
            temp.push(candidates[i]);
            backtrack(candidates, target-candidates[i], i+1, flag);
            if(target-temp.pop()<=0){
                return;
            }
            flag[i]=false;
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
