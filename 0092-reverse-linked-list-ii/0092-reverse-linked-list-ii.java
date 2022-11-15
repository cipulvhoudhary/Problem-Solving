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
    
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int k = right - left + 1;
        if((k == 1) || (head == null || head.next == null)) return head;
        
        
        // place a temp node just before left 
        // reverse k chunks of list
        // return the list
        
        if(left == 1) return reverseKchunks(head, k);
        
        int count = 1;
        ListNode temp = head;
        while(count < left-1) {
            count++;
            temp = temp.next;
        }
        
        temp.next = reverseKchunks(temp.next, k);
        return head;
    }
}