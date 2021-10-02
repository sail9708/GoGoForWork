//给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。 
//
// 如果小数部分为循环小数，则将循环的部分括在括号内。 
//
// 如果存在多个答案，只需返回 任意一个 。 
//
// 对于所有给定的输入，保证 答案字符串的长度小于 10⁴ 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numerator = 1, denominator = 2
//输出："0.5"
// 
//
// 示例 2： 
//
// 
//输入：numerator = 2, denominator = 1
//输出："2"
// 
//
// 示例 3： 
//
// 
//输入：numerator = 2, denominator = 3
//输出："0.(6)"
// 
//
// 示例 4： 
//
// 
//输入：numerator = 4, denominator = 333
//输出："0.(012)"
// 
//
// 示例 5： 
//
// 
//输入：numerator = 1, denominator = 5
//输出："0.2"
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= numerator, denominator <= 2³¹ - 1 
// denominator != 0 
// 
// Related Topics 哈希表 数学 字符串 👍 262 👎 0

  
package leetcode.problems.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;

public class No_166_FractionToRecurringDecimal{
    public static void main(String[] args) {
       Solution solution = new No_166_FractionToRecurringDecimal().new Solution();
       solution.fractionToDecimal(-2147483648,1);
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 解答成功:
     * 		执行耗时:5 ms,击败了17.07% 的Java用户
     * 		内存消耗:35.8 MB,击败了54.13% 的Java用户
     * @param numerator
     * @param denominator
     * @return
     */
    public String fractionToDecimal(long numerator, long denominator) {
        if (numerator%denominator == 0){
            return String.valueOf(numerator/denominator);
        }
        StringBuilder sb = new StringBuilder();
        if (numerator<0 ^ denominator<0){
            sb.append("-");
        }
        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);
        //整数部分
        sb.append(numerator/denominator+".");
        numerator%=denominator;
        //小数部分
        int count = sb.length();
        numerator*=10;
        HashMap<Long,Integer> map = new HashMap<>();
        map.put(numerator,count++);
        while (numerator%denominator!=0){
            long a = numerator/denominator;
            numerator %=denominator;
            sb.append(a);

            numerator*=10;
            if (map.containsKey(numerator)){
                int idx = map.get(numerator);
                sb.insert(idx,"(");
                sb.append(")");
                break;
            }else {
                map.put(numerator, count++);
            }
        }
        if (numerator%denominator == 0){
            sb.append(numerator/denominator);
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
