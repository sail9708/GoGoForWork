//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 594 👎 0

  
package leetcode.problems.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class No_77_Combinations{
    public static void main(String[] args) {
       Solution solution = new No_77_Combinations().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    List<List<Integer>> res = new ArrayList<>();
    Deque<Integer> temp = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {

        if (k>n){
            return res;
        }
        backtrack(n,k,1);
        return res;

    }

    public void backtrack(int n, int k, int startIndex){
        int size = temp.size();
        for (int i = startIndex; i <= n-k+1+size; i++ ){
            temp.push(i);
            if (temp.size()<k){
                backtrack(n,k,i+1);
                temp.pop();
            }
            else {
                res.add(new ArrayList<>(temp));
                temp.pop();
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
