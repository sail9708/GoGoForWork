//给定一个字符串 s，你可以通过在字符串前面添加字符将其转换为回文串。找到并返回可以用这种方式转换的最短回文串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aacecaaa"
//输出："aaacecaaa"
// 
//
// 示例 2： 
//
// 
//输入：s = "abcd"
//输出："dcbabcd"
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 仅由小写英文字母组成 
// 
// Related Topics 字符串 字符串匹配 哈希函数 滚动哈希 
// 👍 356 👎 0

  
package leetcode.problems.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Locale;

public class No_214_ShortestPalindrome{
    public static void main(String[] args) {
       Solution solution = new No_214_ShortestPalindrome().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * 官方方法：KMP算法处理
     *解答成功:
     * 		执行耗时:2 ms,击败了99.08% 的Java用户
     * 		内存消耗:38.5 MB,击败了72.62% 的Java用户
     * @param s
     * @return
     */
    public String shortestPalindrome(String s) {
        int n = s.length();
        int[] fail = new int[n];
        Arrays.fill(fail, -1);
        for (int i = 1; i < n; ++i) {
            int j = fail[i - 1];
            while (j != -1 && s.charAt(j + 1) != s.charAt(i)) {
                j = fail[j];
            }
            if (s.charAt(j + 1) == s.charAt(i)) {
                fail[i] = j + 1;
            }
        }
        int best = -1;
        for (int i = n - 1; i >= 0; --i) {
            while (best != -1 && s.charAt(best + 1) != s.charAt(i)) {
                best = fail[best];
            }
            if (s.charAt(best + 1) == s.charAt(i)) {
                ++best;
            }
        }
        String add = (best == n - 1 ? "" : s.substring(best + 1));
        StringBuffer ans = new StringBuffer(add).reverse();
        ans.append(s);
        return ans.toString();
    }


    /**
     * 初见思路：暴力,找到包含第一个字符的最长回文子串
     * 解答成功:
     * 		执行耗时:542 ms,击败了5.08% 的Java用户
     * 		内存消耗:38.5 MB,击败了76.00% 的Java用户
     * @param s
     * @return
     */
    public String shortestPalindrome1(String s) {
        char[] str = s.toCharArray();
        int len = s.length();
        int idx = 0;
        for (int i = 1; i < len; i++){
            //说明是偶数长度回文子串
            if (i%2 == 1){
                for (int j = 0; j < (i+1)/2; j++){
                    if (str[j] == str[i-j]){
                        if (j == (i+1)/2-1){
                            idx = i;
                        }
                        continue;
                    }else {
                        break;
                    }
                }
            }else {
                for (int j = 0; j < i/2; j++){
                    if (str[j] == str[i-j]){
                        if (j == i/2-1){
                            idx = i;
                        }
                        continue;
                    }else {
                        break;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int x = len-1;
        while (x>idx){
            sb.append(str[x]);
            x--;
        }
        sb.append(s);
        return sb.toString();

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
