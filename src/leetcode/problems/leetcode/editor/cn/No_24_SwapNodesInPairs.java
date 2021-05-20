//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你能在不修改链表节点值的情况下解决这个问题吗?（也就是说，仅修改节点本身。） 
// Related Topics 递归 链表 
// 👍 919 👎 0

  
package leetcode.problems.leetcode.editor.cn;

import leetcode.datastructure.ListNode;

public class No_24_SwapNodesInPairs{
    public static void main(String[] args) {
       Solution solution = new No_24_SwapNodesInPairs().new Solution();
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
    public ListNode swapPairs(ListNode head) {
        ListNode vh = new ListNode(-1, head);   //新建一个总虚拟头节点
        ListNode temp = new ListNode();             //建立一个缓存节点
        ListNode pre = vh;                          //每一步操作的头节点

        //每三个节点作为一轮，0、1、2、3，改为 0、2、1、3
        while (pre.next != null && pre.next.next != null){
            temp = pre.next;                  //缓存1
            pre.next = pre.next.next;         //0、2、3
            temp.next = pre.next.next ;       //1、2——>1、3
            pre.next.next = temp;             //0、2、3——>0、2、1
            pre = pre.next.next;               //将pre指向最新的1位置
        }

        return vh.next;

        /******递归法********/
//        // base case 退出提交
//        if(head == null || head.next == null) return head;
//        // 获取当前节点的下一个节点
//        ListNode next = head.next;
//        // 进行递归
//        ListNode newNode = swapPairs(next.next);
//        // 这里进行交换
//        next.next = head;
//        head.next = newNode;
//
//        return next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
