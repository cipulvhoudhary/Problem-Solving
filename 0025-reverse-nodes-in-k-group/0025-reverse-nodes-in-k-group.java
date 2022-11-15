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
        while(count > 0) {
            if(curr == null) {
                int _k = k-count;
                head = null;
                return reverseKchunks(prev, _k);
            }
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            count--;
        }
        head.next = curr;
        return prev;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        // Edge - case
        if(head == null || head.next == null) return head;
        
        ListNode prev = reverseKchunks(head, k);
        if(head != null) {
            head.next = reverseKGroup(head.next, k);
        }
        return prev;
    }
}