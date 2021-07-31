//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 5837 👎 0

  
package leetcode.problems.leetcode.editor.cn;

import java.util.*;

public class No_3_LongestSubstringWithoutRepeatingCharacters{
    public static void main(String[] args) {
       Solution solution = new No_3_LongestSubstringWithoutRepeatingCharacters().new Solution();
       solution.lengthOfLongestSubstring("abcabcbb");
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int right = 0;
        int res = 0;
        char[] c = s.toCharArray();
        while (left <= right && right < c.length){
            if (!set.contains(c[right])){
                set.add(c[right]);
                right++;
                res = Math.max(res, set.size());
            }else {
                while (set.contains(c[right])){
                    set.remove(c[left++]);
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
