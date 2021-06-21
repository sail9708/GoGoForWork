//给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,6,3,4,5,6], val = 6
//输出：[1,2,3,4,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [], val = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [7,7,7,7], val = 7
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 列表中的节点数目在范围 [0, 104] 内 
// 1 <= Node.val <= 50 
// 0 <= val <= 50 
// 
// Related Topics 链表 
// 👍 649 👎 0

  
package leetcode.problems.leetcode.editor.cn;

import leetcode.datastructure.ListNode;

import java.util.List;

public class No_203_RemoveLinkedListElements{
    public static void main(String[] args) {
       Solution solution = new No_203_RemoveLinkedListElements().new Solution();
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
     * 初见思路：双指针法，向后遍历，依次删除  （链表是否存在环？）
     * 			解答成功:
     * 			执行耗时:1 ms,击败了99.70% 的Java用户
     * 			内存消耗:39.1 MB,击败了78.36% 的Java用户
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode beforeHead = new ListNode(-1, head);
        ListNode l = beforeHead;
        ListNode r = head;
        while (r != null){
            if (r.val == val){
                r = r.next;
                l.next = r;
            }else {
                r = r.next;
                l = l.next;
            }
        }
        return beforeHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
