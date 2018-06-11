/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) return null;
        
        //Use two pointers with one n nodes ahead
        ListNode fwd = head;
        ListNode ptr = head;
        for (int i = 0; i<n; i++)
            fwd = fwd.next;
        
        if (fwd == null) return head.next;
        
        while(fwd.next != null){
            fwd = fwd.next;
            ptr = ptr.next;
        }
        ptr.next = ptr.next.next;
        
        return head;
    }
}