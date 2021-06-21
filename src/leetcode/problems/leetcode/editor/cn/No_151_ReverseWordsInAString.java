//给你一个字符串 s ，逐个翻转字符串中的所有 单词 。 
//
// 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。 
//
// 请你返回一个翻转 s 中单词顺序并用单个空格相连的字符串。 
//
// 说明： 
//
// 
// 输入字符串 s 可以在前面、后面或者单词间包含多余的空格。 
// 翻转后单词间应当仅用一个空格分隔。 
// 翻转后的字符串中不应包含额外的空格。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "the sky is blue"
//输出："blue is sky the"
// 
//
// 示例 2： 
//
// 
//输入：s = "  hello world  "
//输出："world hello"
//解释：输入字符串可以在前面或者后面包含多余的空格，但是翻转后的字符不能包括。
// 
//
// 示例 3： 
//
// 
//输入：s = "a good   example"
//输出："example good a"
//解释：如果两个单词间有多余的空格，将翻转后单词间的空格减少到只含一个。
// 
//
// 示例 4： 
//
// 
//输入：s = "  Bob    Loves  Alice   "
//输出："Alice Loves Bob"
// 
//
// 示例 5： 
//
// 
//输入：s = "Alice does not even like bob"
//输出："bob like even not does Alice"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 包含英文大小写字母、数字和空格 ' ' 
// s 中 至少存在一个 单词 
// 
//
// 
// 
//
// 
//
// 进阶： 
//
// 
// 请尝试使用 O(1) 额外空间复杂度的原地解法。 
// 
// Related Topics 字符串 
// 👍 330 👎 0

  
package leetcode.problems.leetcode.editor.cn;

import java.util.Deque;
import java.util.LinkedList;

public class No_151_ReverseWordsInAString{
    public static void main(String[] args) {
       Solution solution = new No_151_ReverseWordsInAString().new Solution();
       solution.reverseWords("a good   example");
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
    三步骤：1.去除多余的空格
           2.反转或逆序整个大字符串
           3.反转每个小字符串，最后一个小字符串单独拿出来反转
    */
    public String reverseWords(String s) {
        if(s == null){
            return "";
        }
        char[] chars = s.toCharArray();
        int len = 0;    //记录有效长度
        int cur = 0;    //去除空格后，正确存放字符的地方
        boolean space = true;   //i前一个位置是否是空格
        for(int i = 0; i < chars.length; i++){
            //如果不等于空格，直接移动
            if(chars[i] != ' '){
                chars[cur++] = chars[i];
                space = false;  //更新space
            }else if(space == false){
                //代码执行到这里，说明i遇到了空格，我们只要第一个空格，其他都不要
                //false相当于i前一个位置是字母，不是空格
                chars[cur++] = ' ';
                space = true;   //更新space
            }
        }
        //这里是为了去除最末尾的空格，space为true，说明i前一个位置有空格
        //此时的i == chars.length，所以-1可以去除末尾的空格
        len = space ? (cur - 1) : cur;
        //反转整个字符串
        reverse(chars,0,len);
        //记录前一个空格的位置，这里-1是哨兵作用，就是-1位置这里肯定是空格
        int preSpaceIdx = -1;
        for(int i = 0; i < len; i++){
            if(chars[i] != ' '){
                continue;
            }
            //遇到是空格，说明前面就是一个完整的小字符串
            reverse(chars,preSpaceIdx + 1,i);
            preSpaceIdx = i;    //因为此时i是空格，更新
        }
        //最后一个小字符串单独反转
        reverse(chars,preSpaceIdx + 1,len);
        //在chars，0到len范围的字符串
        return new String(chars,0,len);
    }

    //反转整个字符串，实际上是不断交换li和ri的位置
    //范围是[li,ri)
    private void reverse(char[] chars,int li,int ri){
        ri--;
        while(li < ri){
            char temp = chars[li];
            chars[li] = chars[ri];
            chars[ri] = temp;
            li++;
            ri--;
        }
    }

    /**
     *  优化代码
     *		执行耗时:15 ms,击败了10.00% 的Java用户
     * 		内存消耗:38.9 MB,击败了13.46% 的Java用户
     */
    public String reverseWords_2(String s) {
        //去除首尾空格
        int left = 0;
        int right = s.length()-1;
        while (s.charAt(left) == ' '){
            left++;
        }
        while (s.charAt(right) == ' '){
            right--;
        }
        s = s.substring(left, right+1);
        //去除中间冗余空格
        for (left = 0, right=1; right<s.length(); ){
            if (s.charAt(left) == ' '){
                if (s.charAt(right) == ' '){
                    right++;
                    continue;
                }
                else {
                    if (right-left==1){
                        left = right++;
                    }else {
                        s = s.substring(0, left)+s.substring(right-1,s.length());
                        right = left+1;
                    }
                    continue;
                }
            }
            left++;
            right++;
        }
        Deque<String> stack = new LinkedList<>();
        for (int start = 0, end = 0; end <= s.length(); end++){
            if (end == s.length()){
                stack.push(s.substring(start,end));
            }else if (s.charAt(end) == ' '){
                stack.push(s.substring(start,end));
                stack.push(" ");
                start=end+1;
            }
        }
        String res = "";
        while (!stack.isEmpty()){
            res+=stack.pop();
        }
        return res;
    }

    /**
     *  初见代码
     *  		解答成功:
     * 		执行耗时:14 ms,击败了13.00% 的Java用户
     * 		内存消耗:38.9 MB,击败了12.78% 的Java用户
     */
    public String reverseWords_firstSee(String s) {
        Deque<String> stack = new LinkedList<>();
        int start = 0, end = 0;
        for (; end <= s.length(); end++){
            //先找到第一个不为空格的字符位置
            if ( s.charAt(end) == ' '){
                continue;
            }
            start = end;
            break;
        }
        for (end = end+1; end < s.length(); end++){
            //当遇到第一个空格字符时，说明一个单词已经遍历完，把它入栈，并入栈一个空格。(连续的空格会被跳过)
            if (s.charAt(end) == ' ' && s.charAt(end - 1)!=' '){
                stack.push(s.substring(start,end));
                stack.push(" ");
            }
            //当再碰到第一不为空格的字符时，说明已经到了下一个字符串的位置，修改start的位置
            else if (s.charAt(end)!=' ' && s.charAt(end-1) == ' '){
                start = end;
                //如果已经是最后一个字符了，则说明这个字符就是一个单独的字符串，把它入栈
                if (end == s.length()-1){
                    stack.push(s.substring(start,end+1));
                }
            }
            //如果已经是最后一个字符了,且其不是空格，则把该字符串入栈。（防止结尾有多个空格的情况）
            else if (end == s.length()-1 && s.charAt(end)!=' '){
                stack.push(s.substring(start,end+1));
            }
        }
        String res = "";
        boolean flag = false;
        while (!stack.isEmpty()){
            while (!flag){
                if (stack.peek().equals(" ")){
                    stack.pop();
                }
                else {
                    flag = true;
                }
            }
            res += stack.pop();
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
