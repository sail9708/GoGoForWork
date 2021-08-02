//给你 n 个项目，编号从 0 到 n - 1 。同时给你一个整数数组 milestones ，其中每个 milestones[i] 表示第 i 个项目中的阶
//段任务数量。 
//
// 你可以按下面两个规则参与项目中的工作： 
//
// 
// 每周，你将会完成 某一个 项目中的 恰好一个 阶段任务。你每周都 必须 工作。 
// 在 连续的 两周中，你 不能 参与并完成同一个项目中的两个阶段任务。 
// 
//
// 一旦所有项目中的全部阶段任务都完成，或者仅剩余一个阶段任务都会导致你违反上面的规则，那么你将 停止工作 。注意，由于这些条件的限制，你可能无法完成所有阶段
//任务。 
//
// 返回在不违反上面规则的情况下你 最多 能工作多少周。 
//
// 
//
// 示例 1： 
//
// 
//输入：milestones = [1,2,3]
//输出：6
//解释：一种可能的情形是：
//​​​​- 第 1 周，你参与并完成项目 0 中的一个阶段任务。
//- 第 2 周，你参与并完成项目 2 中的一个阶段任务。
//- 第 3 周，你参与并完成项目 1 中的一个阶段任务。
//- 第 4 周，你参与并完成项目 2 中的一个阶段任务。
//- 第 5 周，你参与并完成项目 1 中的一个阶段任务。
//- 第 6 周，你参与并完成项目 2 中的一个阶段任务。
//总周数是 6 。
// 
//
// 示例 2： 
//
// 
//输入：milestones = [5,2,1]
//输出：7
//解释：一种可能的情形是：
//- 第 1 周，你参与并完成项目 0 中的一个阶段任务。
//- 第 2 周，你参与并完成项目 1 中的一个阶段任务。
//- 第 3 周，你参与并完成项目 0 中的一个阶段任务。
//- 第 4 周，你参与并完成项目 1 中的一个阶段任务。
//- 第 5 周，你参与并完成项目 0 中的一个阶段任务。
//- 第 6 周，你参与并完成项目 2 中的一个阶段任务。
//- 第 7 周，你参与并完成项目 0 中的一个阶段任务。
//总周数是 7 。
//注意，你不能在第 8 周参与完成项目 0 中的最后一个阶段任务，因为这会违反规则。
//因此，项目 0 中会有一个阶段任务维持未完成状态。 
//
// 
//
// 提示： 
//
// 
// n == milestones.length 
// 1 <= n <= 105 
// 1 <= milestones[i] <= 109 
// 
// 👍 15 👎 0

  
package leetcode.problems.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class No_1953_MaximumNumberOfWeeksForWhichYouCanWork{
    public static void main(String[] args) {
       Solution solution = new No_1953_MaximumNumberOfWeeksForWhichYouCanWork().new Solution();
       solution.numberOfWeeks(new int[]{1,2,3});
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * 我们首先计算出耗时最长的工作所需周数longest 与剩余工作所需周数 rest，并比较两者大小。根据比较的结果不同会有两种情况：
     *
     * longest≤rest+1，此时根据 提示 11，所有工作都可以完成，我们返回所有工作的总耗时 \longest+rest 作为答案。
     *
     * longest>rest+1，此时我们无法完成耗时最长的工作。根据 提示 1的证明过程，耗时最长的工作最多可以完成 rest+1 周，因此最大的工作周数即为 2×rest+1，我们返回该数作为答案。
     *
     *
     *
     * 首先，题目要求满足不重复项目的最大的工作周数，我们可以这样理解，将所有项目的任务排成一个任务序列，找到一个前缀最长的相邻元素不重复的序列即可。因此，我们可以首先将任务数最多的项目先排开，然后将其它任务插入到它的间隙中。
     * 例如，[1,2,3,5]，最大的项目任务数为5，因此我们先得到项目4的5个任务的序列5 5 5 5 5，我们依次将其它任务插入以保证相邻不重复，依次得到 5 3 5 3 5 3 5 5,不够，再将2插入，得到5 3 5 3 5 3 5 2 5,此时我们已经能保证5的任务不相邻了。而且我们发现，随着插入的任务数越多，可供后面任务插入的空位越多(大于最大项目的任务数)，因此后面的任务只要插入前面序列两个不相邻的任务中间，就不会重复。综上，我们只需要保证任务数最多的项目不重复即可保证所有项目的任务不重复。
     *
     * 作者：yorwood
     * 链接：https://leetcode-cn.com/problems/maximum-number-of-weeks-for-which-you-can-work/solution/ti-yi-zhuan-hua-cha-kong-fa-by-yorwood-bvdv/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param milestones
     * @return
     */
    public long numberOfWeeks(int[] milestones) {
        long max = 0;
        long sum = 0;
        for (int i = 0; i < milestones.length; i++) {
            max = Math.max(max, milestones[i]);
            sum += milestones[i];
        }
        return max > sum - max ? (sum - max) * 2 + 1 : sum;
    }


    /**
     * 初见思路：尽量先做当前阶段数多的任务
     *
     * 运行失败:
     * 			Time Limit Exceeded
     *
     * @param milestones
     * @return
     */
    public long numberOfWeeks1(int[] milestones) {
        int res = 0;
        //建立一个大端堆
        //int[]:int[0]为阶段数
        //      int[1]为上周是否做过
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1]!=o2[1]){
                    return o2[1]-o1[1];
                }else {
                    return o2[0]-o1[0];
                }
            }
        });
        for (int i = 0; i < milestones.length; i++){
            int[] temp = new int[2];
            temp[0] = milestones[i];
            temp[1] = 0;
            pq.offer(temp);
        }
        while (pq.size() >= 1){
            if (pq.peek()[1] == 1){
                if (pq.size() == 1){
                    return res;
                }
                int[] temp1 = pq.poll();
                temp1[1] = 0;
                int[] temp2 = pq.poll();
                temp2[0]--;
                temp2[1] = 1;
                pq.offer(temp1);
                if (temp2[0]!=0) {
                    pq.offer(temp2);
                }
            }else {
                int[] temp = pq.poll();
                temp[0]--;
                temp[1] = 1;
                if (temp[0]!=0) {
                    pq.offer(temp);
                }
            }
            res++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
