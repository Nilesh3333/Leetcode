/*
Time Complexity: O(n)
The while loop iterates through the entire linked list once, where n is the number of nodes in the list.
In each iteration, constant time operations (assignment, pointer manipulation) are performed.

Space Complexity: O(1)
The function uses a constant amount of extra space for three pointers (`prev`, `curr`, and `next`).
This space complexity does not depend on the size of the input linked list.
 */

public class reverseList206 {
    public static class ListNode{
        ListNode next;
        int data;
        ListNode(){}
        ListNode(int data) { this.data = data; }
        ListNode(int data,ListNode next){
            this.data = data;
            this.next = next;
        }
    }
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        // Iterate through the linked list while the current node is not null
        while (curr != null) {
            // Store the next node in a temporary variable (next)
            ListNode next = curr.next;

            // Reverse the link. Point the current node's next to the previous node.
            curr.next = prev;

            // Update pointers: move prev one step forward and curr to the next node (previously stored in next)
            prev = curr;
            curr = next;
        }

        // After the loop, prev will be pointing to the new head of the reversed list
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode ans = reverseList(head);
        while(ans!=null){
            System.out.println(ans.data);
            ans =ans.next;
        }
    }

}
