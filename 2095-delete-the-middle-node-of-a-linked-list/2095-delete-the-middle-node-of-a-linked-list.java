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
        // edge - case
        if(head == null || head.next == null) return null;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = dummy;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null) {
            temp = temp.next;
            slow = slow.next;
            fast = fast.next.next;
        }
        temp.next = slow.next;
        slow.next = null;
        dummy = dummy.next;
        return head;
    }
}