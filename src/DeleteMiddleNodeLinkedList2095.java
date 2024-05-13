/*
The objective is to achieve this removal efficiently, without traversing the list more than once.
A popular and effective strategy to accomplish this is the two-pointer technique, also known as the "fast and slow pointer" method.
In this approach, two pointers are initialized at the beginning of the list, but they move at different speeds.
The "fast" pointer advances two nodes for every one node that the "slow" pointer advances.
By the time the fast pointer reaches the end of the list,the slow pointer will be positioned just before the middle node,
enabling its easy removal. This method ensures that the algorithm only needs to pass through the list once,
thus optimizing both time and computational resources.
Complexity
Time complexity: O(n)
Space complexity: O(1)
*/
public class DeleteMiddleNodeLinkedList2095 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(6);
        ListNode ans = deleteMiddle(head);
        while(ans!=null){
            System.out.println(ans.val);
            ans= ans.next;
        }
    }

    public static ListNode deleteMiddle(ListNode head) {
       ListNode prev = new ListNode(0);
       prev.next = head;
       ListNode slow = prev;
       ListNode fast = head;
       while(fast!=null && fast.next != null){
           slow = slow.next;
           fast = fast.next.next;
       }
       slow.next = slow.next.next;
       return prev.next;
    }
}
