//找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。 
//
// 说明： 
//
// 
// 所有数字都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: k = 3, n = 7
//输出: [[1,2,4]]
// 
//
// 示例 2: 
//
// 输入: k = 3, n = 9
//输出: [[1,2,6], [1,3,5], [2,3,4]]
// 
// Related Topics 数组 回溯算法 
// 👍 316 👎 0

  
package leetcode.problems.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class No_216_CombinationSumIii{
    public static void main(String[] args) {
       Solution solution = new No_216_CombinationSumIii().new Solution();
       solution.combinationSum3(3,7);
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 初见思路：回溯法（暴力）   没有剪枝，可优化
     * 			解答成功:
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:36.2 MB,击败了21.76% 的Java用户
     * @param k
     * @param n
     * @return
     */
    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> que = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(k,n,1);
        return res;
    }
    public void backtrack(int k, int n, int start){
        for (int i = start; i < 10; i++){
            if (n-i>0){
                if (k>0) {
                    que.addLast(i);
                    backtrack(k - 1, n - i, i + 1);
                    que.pollLast();
                    continue;
                }else {
                    return;
                }
            }
            else if (n-i == 0){
                if (k == 1){
                    que.addLast(i);
                    res.add(new ArrayList<>(que));
                    que.pollLast();
                }
                return;
            }else {
                return;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
