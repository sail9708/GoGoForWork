//给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。 
//
// 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "hello"
//输出："holle"
// 
//
// 示例 2： 
//
// 
//输入：s = "leetcode"
//输出："leotcede" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 105 
// s 由 可打印的 ASCII 字符组成 
// 
// Related Topics 双指针 字符串 
// 👍 203 👎 0


package leetcode.problems.leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;

public class No_345_ReverseVowelsOfAString {
    public static void main(String[] args) {
        Solution solution = new No_345_ReverseVowelsOfAString().new Solution();
        solution.reverseVowels("hello");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String reverseVowels(String s) {
            HashSet<Character> set = new HashSet<>();
            set.add('a');
            set.add('e');
            set.add('i');
            set.add('o');
            set.add('u');
            set.add('A');
            set.add('E');
            set.add('I');
            set.add('O');
            set.add('U');
            char[] c = s.toCharArray();
            int left = 0;
            int right = s.length() - 1;
            while (left < right) {
                while (!set.contains(c[left])) {
                    left++;
                    if (left >= right) {
                        break;
                    }
                }
                while (!set.contains(c[right])) {
                    right--;
                    if (left >= right) {
                        break;
                    }
                }
                if (left >= right) {
                    break;
                }
                char temp = c[left];
                c[left] = c[right];
                c[right] = temp;
                left++;
                right--;
            }
            return String.valueOf(c);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
