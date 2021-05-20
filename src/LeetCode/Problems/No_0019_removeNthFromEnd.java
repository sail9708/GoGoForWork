package LeetCode.Problems;
import LeetCode.DataStructure.ListNode;

public class No_0019_removeNthFromEnd {

    /*****test case********/
    private static ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
    private static int n = 2;
    /**********************/

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode beforehead = new ListNode(-1, head);
        //定义两个指针
        ListNode fast = beforehead;
        ListNode slow = beforehead;
        //先让fast指针移动n+1步
        for(int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next=slow.next.next;
        return beforehead.next;
    }

    public static void main(String[] args) {
        ListNode result = new No_0019_removeNthFromEnd().removeNthFromEnd(head, n);
        while (result!=null){
            System.out.print(result.val+" ");
            result=result.next;
        }
    }

}
