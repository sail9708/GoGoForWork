//给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。 
//
// 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。 
//
// 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 
//和 "192.168@1.1" 是 无效 IP 地址。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "25525511135"
//输出：["255.255.11.135","255.255.111.35"]
// 
//
// 示例 2： 
//
// 
//输入：s = "0000"
//输出：["0.0.0.0"]
// 
//
// 示例 3： 
//
// 
//输入：s = "1111"
//输出：["1.1.1.1"]
// 
//
// 示例 4： 
//
// 
//输入：s = "010010"
//输出：["0.10.0.10","0.100.1.0"]
// 
//
// 示例 5： 
//
// 
//输入：s = "101023"
//输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3000 
// s 仅由数字组成 
// 
// Related Topics 字符串 回溯算法 
// 👍 584 👎 0

  
package leetcode.problems.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class No_93_RestoreIpAddresses{
    public static void main(String[] args) {
       Solution solution = new No_93_RestoreIpAddresses().new Solution();
       solution.restoreIpAddresses("1111");
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    List<String> res = new ArrayList<>();
    String IP = null;

    public List<String> restoreIpAddresses(String s) {
        if (s.length()>12 || s.length()<4){
            return res;
        }

        backtrack(0,s,0);
        return res;


    }

    public void backtrack(int startIndex, String s, int pointNum){
        if (pointNum == 3){
            if (isValid(s.substring(startIndex))){
                res.add(s);
            }
            return;
        }
        for (int i = 0; i<3; i++) {
            if (isValid(s.substring(startIndex,startIndex+i+1))){
                if (startIndex+i+1 == s.length()){
                    break;
                }
                s = s.substring(0,startIndex+i+1)+'.'+s.substring(startIndex+i+1);
                pointNum++;
                backtrack(startIndex+i+2,s,pointNum);
                pointNum--;
                s = s.substring(0,startIndex+i+1)+s.substring(startIndex+i+2);
            }
            else{
                break;
            }
        }
    }

    public boolean isValid(String temp){

        //段位开头为0不合法
        if (temp.length()>1 && temp.charAt(0) == '0'){
            return false;
        }
        //出现非整数字符不合法
        for (int i = 0; i < temp.length(); i++){
            if (temp.charAt(i) < '0' || temp.charAt(i) > '9'){
                return false;
            }
        }
        //超出255不合法
        if (Integer.parseInt(temp)>255){
            return false;
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
