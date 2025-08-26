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
    public ListNode deleteMiddle(ListNode head) {
       
        if (head == null || head.next == null) return null;

        ListNode low = head;
        ListNode high = head;
        high=high.next.next;

      
        while (high != null && high.next != null) {
            low = low.next;
            high = high.next.next;
        }

       
        low.next = low.next.next;  

        return head;
    }
}
