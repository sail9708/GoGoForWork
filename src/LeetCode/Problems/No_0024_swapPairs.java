package LeetCode.Problems;

import LeetCode.DataStructure.ListNode;

import java.util.List;

public class No_0024_swapPairs {

    /*****test case********/
    private static ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
    /**********************/

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

    public static void main(String[] args) {
        ListNode result = new No_0024_swapPairs().swapPairs(head);
        while (result!=null){
            System.out.print(result.val+" ");
            result=result.next;
        }
    }

}
