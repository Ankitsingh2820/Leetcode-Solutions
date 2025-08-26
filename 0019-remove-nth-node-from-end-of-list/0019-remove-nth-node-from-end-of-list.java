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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode low=head;
        ListNode high=head;
        for(int i=0;i<n;i++)
        {
            high=high.next;

        }
         if (high == null) {
            return head.next;
        }
        while(high.next !=null)
        {
            low=low.next;
            high=high.next;

        }
        low.next=low.next.next;
        return head;
        
    }
}