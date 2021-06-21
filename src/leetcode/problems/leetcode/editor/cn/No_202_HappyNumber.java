//编写一个算法来判断一个数 n 是不是快乐数。 
//
// 「快乐数」定义为： 
//
// 
// 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。 
// 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。 
// 如果 可以变为 1，那么这个数就是快乐数。 
// 
//
// 如果 n 是快乐数就返回 true ；不是，则返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：19
//输出：true
//解释：
//12 + 92 = 82
//82 + 22 = 68
//62 + 82 = 100
//12 + 02 + 02 = 1
// 
//
// 示例 2： 
//
// 
//输入：n = 2
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 231 - 1 
// 
// Related Topics 哈希表 数学 
// 👍 623 👎 0

  
package leetcode.problems.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;

public class No_202_HappyNumber{
    public static void main(String[] args) {
       Solution solution = new No_202_HappyNumber().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 初见思路， 因为可能无限循环下去也不能到达1。所以，只要当计算过程中出现重复的sum，说明就不可能到1，所以用hash方法
     * 			解答成功:
     * 			执行耗时:1 ms,击败了99.72% 的Java用户
     * 			内存消耗:35.6 MB,击败了34.07% 的Java用户
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        HashSet hashSum = new HashSet<Integer>();
        int sum = countSumOfSquares(n);
        while (sum != 1){
            if (hashSum.contains(sum)){
                return false;
            }
            hashSum.add(sum);
            sum = countSumOfSquares(sum);
        }
        return true;

    }
    public int countSumOfSquares(int n){
        int sum = 0;
        while (n != 0){
            sum+= (n % 10)*(n % 10);
            n = n/10;
        }
        return sum;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
