//给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。 
//
// 注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "barfoothefoobarman", words = ["foo","bar"]
//输出：[0,9]
//解释：
//从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
//输出的顺序不重要, [9,0] 也是有效答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
//输出：[6,9,12]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 由小写英文字母组成 
// 1 <= words.length <= 5000 
// 1 <= words[i].length <= 30 
// words[i] 由小写英文字母组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 534 👎 0


package leetcode.problems.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class No_30_SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        Solution solution = new No_30_SubstringWithConcatenationOfAllWords().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> res = new ArrayList<>();
            if (s == null || s.length() == 0 || words == null || words.length == 0) return res;
            HashMap<String, Integer> map = new HashMap<>();
            int one_word = words[0].length();
            int word_num = words.length;
            int all_len = one_word * word_num;
            for (String word : words) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
            for (int i = 0; i < s.length() - all_len + 1; i++) {
                String tmp = s.substring(i, i + all_len);
                HashMap<String, Integer> tmp_map = new HashMap<>();
                for (int j = 0; j < all_len; j += one_word) {
                    String w = tmp.substring(j, j + one_word);
                    tmp_map.put(w, tmp_map.getOrDefault(w, 0) + 1);
                }
                if (map.equals(tmp_map)) res.add(i);
            }
            return res;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

}
