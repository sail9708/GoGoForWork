//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1： 
//
// 输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2： 
//
// 输入：candidates = [2,3,5], target = 8,
//所求解集为：
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯算法 
// 👍 1349 👎 0

  
package leetcode.problems.leetcode.editor.cn;

import java.util.*;

public class No_39_CombinationSum{
    public static void main(String[] args) {
       Solution solution = new No_39_CombinationSum().new Solution();
       solution.combinationSum(new int[]{2, 3, 6, 7},7);
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    //定义一个数组存储结果
    List<List<Integer>> result = new ArrayList<>();
    //定义一个栈
    Deque<Integer> temp = new LinkedList<>();
    //
    int curSum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        //初见想法：回溯
        //首先给数组排序
        Arrays.sort(candidates);
        //回溯
        backtrack(candidates,target,0);
        System.out.println(result);
        return result;

    }

    //回溯函数
    private void backtrack(int[] candidates, int target, int startIndex){

        if (target<0){
            return;
        }
        if (target == 0){
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++){
//            if (target<0){break;}
            temp.push(candidates[i]);
            backtrack(candidates,target-candidates[i],i);
            if(target-temp.pop()<=0){
                return;
            }

        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
