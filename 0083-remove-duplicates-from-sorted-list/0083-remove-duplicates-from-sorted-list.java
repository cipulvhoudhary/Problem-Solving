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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode t1 = head;
        while(t1 != null) {
            ListNode t2 = t1.next;
            ListNode prev = t1;
            while(t2 != null && t1.val == t2.val) {
                t2 = t2.next;
                prev = prev.next; 
            }
            t1.next = t2;
            if(t1 != prev) {
                prev.next = null;
            }
            t1 = t2;
        }
        return head;
    }
}