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
    
    public ListNode reverseKchunks(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        
        int count = k;
        ListNode prev = null, curr = head;
        while(count > 0 && curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            count--;
        }
        head.next = curr;
        return prev;
    }
    
    public ListNode swapPairs(ListNode head) {
        // Edge - case
        if(head == null || head.next == null) return head;
        
        ListNode prev = reverseKchunks(head, 2);
        head.next = swapPairs(head.next);
        return prev;
    }
}