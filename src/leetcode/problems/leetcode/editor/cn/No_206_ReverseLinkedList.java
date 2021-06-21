//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？ 
// 
// 
// Related Topics 链表 
// 👍 1801 👎 0

  
package leetcode.problems.leetcode.editor.cn;

import leetcode.datastructure.ListNode;

import java.util.List;

public class No_206_ReverseLinkedList{
    public static void main(String[] args) {
       Solution solution = new No_206_ReverseLinkedList().new Solution();
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
     * 初见思路：反转单链表，使用双指针法
     *    迭代法
     *    			解答成功:
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:38.2 MB,击败了68.84% 的Java用户
     * @param head
     * @return
     */
    public ListNode reverseList_1(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode temp = null;

        while (cur != null){
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }

        return prev;
    }

    /**
     *  递归法
     *			解答成功:
     * 			执行耗时:0 ms,击败了100.00% 的Java用户
     * 			内存消耗:38.1 MB,击败了75.77% 的Java用户
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null){
            return null;
        }
        return reverseHelper(null, head);
    }

    public ListNode reverseHelper(ListNode prev, ListNode cur){
        ListNode temp = cur.next;
        cur.next = prev;
        prev = cur;
        cur = temp;
        if (cur == null){
            return prev;
        }else {
            return reverseHelper(prev, cur);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}
