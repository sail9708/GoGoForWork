//实现 strStr() 函数。 
//
// 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如
//果不存在，则返回 -1 。 
//
// 
//
// 说明： 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与 C 语言的 strstr() 以及 Java 的 indexOf() 定义相符。 
//
// 
//
// 示例 1： 
//
// 
//输入：haystack = "hello", needle = "ll"
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：haystack = "aaaaa", needle = "bba"
//输出：-1
// 
//
// 示例 3： 
//
// 
//输入：haystack = "", needle = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= haystack.length, needle.length <= 5 * 104 
// haystack 和 needle 仅由小写英文字符组成 
// 
// Related Topics 双指针 字符串 
// 👍 906 👎 0

  
package leetcode.problems.leetcode.editor.cn;
public class No_28_ImplementStrstr{
    public static void main(String[] args) {
       Solution solution = new No_28_ImplementStrstr().new Solution();
       String haystack = "hello";
       String needle = "ll";
       System.out.println(solution.strStr(haystack,needle));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strStr(String haystack, String needle) {
/*******************调库版本*****************************/
//        return haystack.indexOf(needle);
/******************************************************/

/*******************KMP（学习中）（待补全）****************/

/******************************************************/


/*******************普通双指针版本************************/
        if (needle.length()>haystack.length()){
            return -1;
        }
        if (needle.isEmpty()){
            return 0;
        }
        int hpointer = 0;
        int npointer = 0;
        int hlength = haystack.length();
        int nlength = needle.length();
        int flag = 0;

        for (;hlength-flag>=nlength;){
            if (haystack.charAt(hpointer) == needle.charAt(npointer)){
                hpointer++;
                npointer++;
            }
            else{
                npointer = 0;
                flag++;
                hpointer = flag;
                continue;
            }
            if (npointer == nlength){
                return flag;
            }
        }
        return -1;
/***********************************************************/




    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
