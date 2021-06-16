//老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。 
//
// 你需要按照以下要求，帮助老师给这些孩子分发糖果： 
//
// 
// 每个孩子至少分配到 1 个糖果。 
// 评分更高的孩子必须比他两侧的邻位孩子获得更多的糖果。 
// 
//
// 那么这样下来，老师至少需要准备多少颗糖果呢？ 
//
// 
//
// 示例 1： 
//
// 
//输入：[1,0,2]
//输出：5
//解释：你可以分别给这三个孩子分发 2、1、2 颗糖果。
// 
//
// 示例 2： 
//
// 
//输入：[1,2,2]
//输出：4
//解释：你可以分别给这三个孩子分发 1、2、1 颗糖果。
//     第三个孩子只得到 1 颗糖果，这已满足上述两个条件。 
// Related Topics 贪心算法 
// 👍 570 👎 0

  
package leetcode.problems.leetcode.editor.cn;

import java.util.Arrays;

public class No_135_Candy{
    public static void main(String[] args) {
       Solution solution = new No_135_Candy().new Solution();
       solution.candy(new int[]{1,3,2,2,1});
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int candy(int[] ratings) {
        int len = ratings.length;;
        int[] candyRes = new int[len];
        int count = 0;

        for (int i = 0; i < len; i++){
            //如果下一位比自己的评分低，则记住，一直到评分比自己高或者和自己一样高的时候，自己的糖果数则为1，并反向发糖果
            if (i+1<len && ratings[i]>ratings[i+1]){
                count++;
                continue;
            }else {
                for (int j = 0; j <= count; j++){
                    candyRes[i-j] = j+1;
                    if (j == count && i-j>0 && ratings[i-j]>ratings[i-j-1] && candyRes[i-j]<=candyRes[i-j-1]){
                        candyRes[i-j] = candyRes[i-j-1]+1;
                    }
                }
                count = 0;
            }
        }
        //返回最后的糖果数
        int sum = 0;
        for (int i = 0; i < len; i++){
            sum+=candyRes[i];
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
