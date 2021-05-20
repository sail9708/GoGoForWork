//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 深度优先搜索 递归 字符串 回溯算法 
// 👍 1317 👎 0

  
package leetcode.problems.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class No_17_LetterCombinationsOfAPhoneNumber{
    public static void main(String[] args) {
       Solution solution = new No_17_LetterCombinationsOfAPhoneNumber().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //final result
    List<String> result = new ArrayList<>();
    //建立数字字母映射表
    String[] numString = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    //建立临时
    StringBuilder temp = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        //考虑特殊情况，直接返回空
        if((digits == null) || (digits.equals("1")) || (digits.length() == 0)){
            return result;
        }

        huishu(digits,0);

        return result;

    }

    //回溯函数
    public void huishu(String digits, int time ){
        //如果time和数字的长度相等，则将字符串添加进结果列表
        if(time == digits.length()){
            result.add(temp.toString());
            return;
        }
        //获取当前轮次对应数字所对应的字符串
        String str = numString[digits.charAt(time)-'0'];
        //遍历添加
        for( int i = 0; i < str.length(); i++){
            temp.append(str.charAt(i));
            huishu(digits,time+1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
