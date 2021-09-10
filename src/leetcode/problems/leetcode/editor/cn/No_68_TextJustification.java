//给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。 
//
// 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。 
//
// 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。 
//
// 文本的最后一行应为左对齐，且单词之间不插入额外的空格。 
//
// 说明: 
//
// 
// 单词是指由非空格字符组成的字符序列。 
// 每个单词的长度大于 0，小于等于 maxWidth。 
// 输入单词数组 words 至少包含一个单词。 
// 
//
// 示例: 
//
// 输入:
//words = ["This", "is", "an", "example", "of", "text", "justification."]
//maxWidth = 16
//输出:
//[
//   "This    is    an",
//   "example  of text",
//   "justification.  "
//]
// 
//
// 示例 2: 
//
// 输入:
//words = ["What","must","be","acknowledgment","shall","be"]
//maxWidth = 16
//输出:
//[
//  "What   must   be",
//  "acknowledgment  ",
//  "shall be        "
//]
//解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
//     因为最后一行应为左对齐，而不是左右两端对齐。       
//     第二行同样为左对齐，这是因为这行只包含一个单词。
// 
//
// 示例 3: 
//
// 输入:
//words = ["Science","is","what","we","understand","well","enough","to",
//"explain",
//         "to","a","computer.","Art","is","everything","else","we","do"]
//maxWidth = 20
//输出:
//[
//  "Science  is  what we",
//  "understand      well",
//  "enough to explain to",
//  "a  computer.  Art is",
//  "everything  else  we",
//  "do                  "
//]
// 
// Related Topics 字符串 模拟 👍 194 👎 0


package leetcode.problems.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class No_68_TextJustification {
    public static void main(String[] args) {
        Solution solution = new No_68_TextJustification().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> fullJustify(String[] words, int maxWidth) {
            List<String> ans = new ArrayList<>();
            int n = words.length;
            List<String> list = new ArrayList<>();
            for (int i = 0; i < n; ) {
                // list 装载当前行的所有 word
                list.clear();
                list.add(words[i]);
                int cur = words[i++].length();
                while (i < n && cur + 1 + words[i].length() <= maxWidth) {
                    cur += 1 + words[i].length();
                    list.add(words[i++]);
                }

                // 当前行为最后一行，特殊处理为左对齐
                if (i == n) {
                    StringBuilder sb = new StringBuilder(list.get(0));
                    for (int k = 1; k < list.size(); k++) {
                        sb.append(" ").append(list.get(k));
                    }
                    while (sb.length() < maxWidth) {
                        sb.append(" ");
                    }
                    ans.add(sb.toString());
                    break;
                }

                // 如果当前行只有一个 word，特殊处理为左对齐
                int cnt = list.size();
                if (cnt == 1) {
                    String str = list.get(0);
                    while (str.length() != maxWidth) {
                        str += " ";
                    }
                    ans.add(str);
                    continue;
                }

                /**
                 * 其余为一般情况
                 * wordWidth : 当前行单词总长度;
                 * spaceWidth : 当前行空格总长度;
                 * spaceItem : 往下取整后的单位空格长度
                 */
                int wordWidth = cur - (cnt - 1);
                int spaceWidth = maxWidth - wordWidth;
                int spaceItemWidth = spaceWidth / (cnt - 1);
                String spaceItem = "";
                for (int k = 0; k < spaceItemWidth; k++) {
                    spaceItem += " ";
                }
                StringBuilder sb = new StringBuilder();
                for (int k = 0, sum = 0; k < cnt; k++) {
                    String item = list.get(k);
                    sb.append(item);
                    if (k == cnt - 1) {
                        break;
                    }
                    sb.append(spaceItem);
                    sum += spaceItemWidth;
                    // 剩余的间隙数量（可填入空格的次数）
                    int remain = cnt - k - 1 - 1;
                    // 剩余间隙数量 * 最小单位空格长度 + 当前空格长度 < 单词总长度，则在当前间隙多补充一个空格
                    if (remain * spaceItemWidth + sum < spaceWidth) {
                        sb.append(" ");
                        sum++;
                    }
                }
                ans.add(sb.toString());
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
