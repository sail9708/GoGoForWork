//给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。 
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。 
//
// 示例: 
//
// 给定的有序链表： [-10, -3, 0, 5, 9],
//
//一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
// 
// Related Topics 深度优先搜索 链表 
// 👍 534 👎 0

  
package leetcode.problems.leetcode.editor.cn;

import leetcode.datastructure.ListNode;
import leetcode.datastructure.TreeNode;

public class No_109_ConvertSortedListToBinarySearchTree{
    public static void main(String[] args) {
       Solution solution = new No_109_ConvertSortedListToBinarySearchTree().new Solution();
       solution.sortedListToBST(new ListNode(-10, new ListNode(-3, new ListNode(0, new ListNode(5, new ListNode(9))))));
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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    //中序遍历+分治法  ⭐⭐⭐⭐
    ListNode globalHead = new ListNode();
    public TreeNode sortedListToBST(ListNode head) {
        //先获取链表的长度
        int length = getLength(head);
        globalHead = head;
        return buildTree(0, length-1);

    }

    //获取链表的长度
    public int getLength(ListNode head){
        int length = 0;
        while (head != null){
            length++;
            head = head.next;
        }
        return length;
    }
    //递归构造平衡二叉树  双闭  (先DST构造二叉平衡树，在用中序遍历填充）
    public TreeNode buildTree(int left, int right){
        if (left > right){
            return null;
        }
        int mid = (left+right)/2;
        TreeNode root = new TreeNode();
        root.left = buildTree(left,mid-1);
        root.val = globalHead.val;
        globalHead = globalHead.next;
        root.right = buildTree(mid+1, right);

        return root;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
