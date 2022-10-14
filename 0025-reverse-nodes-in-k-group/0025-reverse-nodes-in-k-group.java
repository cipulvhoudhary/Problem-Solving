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
    
    private ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        
        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;
        if(k == 1) return head;
        
        ListNode curr = head;
        ListNode prev = null;
        
        int count = k;
        while(count > 0 && curr != null) {
            count--;
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        if(count != 0) {
            return reverse(prev);
        }
        
        head.next = reverseKGroup(curr, k);
        return prev;
    }
    
}