package LeetCode.Problems;

public class No_0019_removeNthFromEnd {

    /*****test case********/
    private static LeetCode.DataStructure.ListNode head = new LeetCode.DataStructure.ListNode(1, new LeetCode.DataStructure.ListNode(2, new LeetCode.DataStructure.ListNode(3, new LeetCode.DataStructure.ListNode(4, new LeetCode.DataStructure.ListNode(5)))));
    private static int n = 2;
    /**********************/

    public LeetCode.DataStructure.ListNode removeNthFromEnd(LeetCode.DataStructure.ListNode head, int n) {
        LeetCode.DataStructure.ListNode beforehead = new LeetCode.DataStructure.ListNode(-1, head);
        //定义两个指针
        LeetCode.DataStructure.ListNode fast = beforehead;
        LeetCode.DataStructure.ListNode slow = beforehead;
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
        LeetCode.DataStructure.ListNode result = new No_0019_removeNthFromEnd().removeNthFromEnd(head, n);
        while (result!=null){
            System.out.print(result.val+" ");
            result=result.next;
        }
    }

}
