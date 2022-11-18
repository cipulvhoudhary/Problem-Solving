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
    
    public ListNode reverseListIterative(ListNode head) {
        ListNode prev = null, curr = head;
        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    
    public ListNode reverseListRecursive(ListNode head, ListNode prev) {
        // Base - c
        if(head == null) return prev;
        
        // Main - logic
        ListNode temp = head.next;
        head.next = prev;
        
        return reverseListRecursive(temp, head);
    }
    
    public ListNode reverseList(ListNode head) {
        
        // Iterative :: TC --> O(N) || SC --> O(1)
        // return reverseListIterative(head);
        
        // Recursive :: TC --> O(N) || SC --> O(N) [Stack space]
        return reverseListRecursive(head, null);
    }
}