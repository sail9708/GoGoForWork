//给定一个字符串 s 和一个整数 k，从字符串开头算起，每 2k 个字符反转前 k 个字符。 
//
// 
// 如果剩余字符少于 k 个，则将剩余字符全部反转。 
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abcdefg", k = 2
//输出："bacdfeg"
// 
//
// 示例 2： 
//
// 
//输入：s = "abcd", k = 2
//输出："bacd"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由小写英文组成 
// 1 <= k <= 104 
// 
// Related Topics 双指针 字符串 
// 👍 177 👎 0


package leetcode.problems.leetcode.editor.cn;

public class No_541_ReverseStringIi {
    public static void main(String[] args) {
        Solution solution = new No_541_ReverseStringIi().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 解答成功:
         * 			执行耗时:0 ms,击败了100.00% 的Java用户
         * 			内存消耗:38.6 MB,击败了30.23% 的Java用户
         * @param s
         * @param k
         * @return
         */
        public String reverseStr(String s, int k) {
            char[] c = s.toCharArray();
            int idx = k + k - 1;
            while (idx < c.length) {
                reverse(c, idx - k - k + 1, idx - k);
                idx += k + k;
            }
            if (c.length - (idx - k - k + 1) < k) {
                reverse(c, idx - k - k + 1, c.length - 1);
            } else {
                reverse(c, idx - k - k + 1, idx - k);
            }
            return String.valueOf(c);
        }

        public void reverse(char[] c, int start, int end) {
            while (start < end) {
                char temp = c[start];
                c[start] = c[end];
                c[end] = temp;
                start++;
                end--;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
