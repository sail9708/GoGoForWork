//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
// Related Topics 链表 分治 堆（优先队列） 归并排序 
// 👍 1386 👎 0

  
package leetcode.problems.leetcode.editor.cn;

import leetcode.datastructure.ListNode;

import java.util.List;
import java.util.PriorityQueue;

public class No_23_MergeKSortedLists{
    public static void main(String[] args) {
       Solution solution = new No_23_MergeKSortedLists().new Solution();
       solution.mergeKLists(new ListNode[]{new ListNode(1,new ListNode(4,new ListNode(5))),new ListNode(1,new ListNode(3,new ListNode(4)))
       , new ListNode(2,new ListNode(6))});
    }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    //初见思路：使用优先队列
    //解答成功:
    //			执行耗时:5 ms,击败了63.96% 的Java用户
    //			内存消耗:39.5 MB,击败了96.05% 的Java用户
    public ListNode mergeKLists(ListNode[] lists) {
        //声明一个最小优先队列
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //将链表中的值存入优先队列
        for (ListNode ln : lists){
            ListNode temp = ln;
            while (temp!=null){
                pq.add(temp.val);
                temp = temp.next;
            }
        }
        ListNode res = null;
        if (!pq.isEmpty()) {
            res = new ListNode((pq.poll()));
        }
        ListNode temp = res;
        while (!pq.isEmpty()){
            temp.next = new ListNode(pq.poll());
            temp = temp.next;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
