//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[4,5,1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：head = [0,1,2], k = 4
//输出：[2,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 500] 内 
// -100 <= Node.val <= 100 
// 0 <= k <= 2 * 10⁹ 
// 
// Related Topics 链表 双指针 👍 633 👎 0

  
package leetcode.problems.leetcode.editor.cn;

import leetcode.datastructure.ListNode;

public class No_61_RotateList{
    public static void main(String[] args) {
       Solution solution = new No_61_RotateList().new Solution();
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
     * 初见思路：将链表首尾相连
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null){
            return head;
        }
        ListNode temp = head;
        int len = 1;  //记录链表的长度
        while (temp.next != null){
            temp = temp.next;
            len++;
        }
        k = k%len;
        int t = len-k-1;
        temp.next = head;

        ListNode temp2 = head;
        while (t>0){
            temp2 = temp2.next;
            t--;
        }

        ListNode newHead = temp2.next;
        temp2.next = null;
        return newHead;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
