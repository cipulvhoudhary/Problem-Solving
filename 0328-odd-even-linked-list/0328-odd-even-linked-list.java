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
    public ListNode oddEvenList(ListNode head) {
        // Edge case
        if(head == null || head.next == null) return head;
        
        ListNode head2 = head.next;
        ListNode t1 = head;
        ListNode t2 = head2;
        
        while(t1 != null && t2 != null) {
            t1.next = t2.next;
            if(t1.next != null) {
                t1 = t1.next;
            }
            else {
                break;
            }
            if(t1 != null) {
                t2.next = t1.next;
                t2 = t2.next;
            }
        }
        t1.next = head2;
        return head;
    }
}