//给你一个头结点为 head 的单链表和一个整数 k ，请你设计一个算法将链表分隔为 k 个连续的部分。 
//
// 每部分的长度应该尽可能的相等：任意两部分的长度差距不能超过 1 。这可能会导致有些部分为 null 。 
//
// 这 k 个部分应该按照在链表中出现的顺序排列，并且排在前面的部分的长度应该大于或等于排在后面的长度。 
//
// 返回一个由上述 k 部分组成的数组。 
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3], k = 5
//输出：[[1],[2],[3],[],[]]
//解释：
//第一个元素 output[0] 为 output[0].val = 1 ，output[0].next = null 。
//最后一个元素 output[4] 为 null ，但它作为 ListNode 的字符串表示是 [] 。
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2,3,4,5,6,7,8,9,10], k = 3
//输出：[[1,2,3,4],[5,6,7],[8,9,10]]
//解释：
//输入被分成了几个连续的部分，并且每部分的长度相差不超过 1 。前面部分的长度大于等于后面部分的长度。
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 1000] 
// 0 <= Node.val <= 1000 
// 1 <= k <= 50 
// 
// Related Topics 链表 👍 214 👎 0

  
package leetcode.problems.leetcode.editor.cn;

import leetcode.datastructure.ListNode;

import java.util.List;

public class No_725_SplitLinkedListInParts{
    public static void main(String[] args) {
       Solution solution = new No_725_SplitLinkedListInParts().new Solution();
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
    /**
     * 题解思路：两次扫描，一次记录长度，一次进行分段
     * 时间复杂度为O(n)
     * 解答成功:
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:38.5 MB,击败了57.21% 的Java用户
     */
    public ListNode[] splitListToParts(ListNode head, int k) {
        // 扫描链表，得到总长度 cnt
        int cnt = 0;
        ListNode tmp = head;
        while (tmp != null && ++cnt > 0) {
            tmp = tmp.next;
        }
        // 理论最小分割长度
        int per = cnt / k;
        // 将链表分割为 k 份（sum 代表已经被处理的链表长度为多少）
        ListNode[] ans = new ListNode[k];
        for (int i = 0, sum = 1; i < k; i++, sum++) {
            ans[i] = head;
            tmp = ans[i];
            // 每次首先分配 per 的长度
            int u = per;
            while (u-- > 1 && ++sum > 0) {
                tmp = tmp.next;
            }
            // 当「已处理的链表长度 + 剩余待分配份数 * per < cnt」，再分配一个单位长度
            int remain = k - i - 1;
            if (per != 0 && sum + per * remain < cnt && ++sum > 0) {
                tmp = tmp.next;
            }
            head = tmp != null ? tmp.next : null;
            if (tmp != null) {
                tmp.next = null;
            }
        }
        return ans;
    }

    /**
     * 初见思路：快慢指针（想复杂了）
     * 解答成功:
     * 			执行耗时:1 ms,击败了6.53% 的Java用户
     * 			内存消耗:38.6 MB,击败了43.03% 的Java用户
     * @param head
     * @param k
     * @return
     */
    public ListNode[] splitListToParts1(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        int idx = 0;
        ListNode prev = new ListNode(-1, head);
        while (prev!=null && prev.next != null){
            ListNode slow = prev;
            ListNode fast = prev;
            while (fast != null && fast.next != null){
                slow = slow.next;
                for (int i = 0; i < k; i++){
                    if (fast.next != null){
                        fast = fast.next;
                    }
                }
            }
            ListNode temp = slow.next;
            slow.next = null;
            ans[idx] = prev.next;
            idx++;
            k--;
            prev.next = temp;

        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
