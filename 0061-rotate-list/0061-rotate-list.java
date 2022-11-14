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
    
    private int getLength(ListNode head) {
        ListNode temp = head;
                              
        // 1 -> 2 -> 3 -> X
        int len = 0;
        while(temp != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }
    
    private ListNode reverse(ListNode head, int k) {
        if(head == null) return head;
        
        ListNode prev = null, curr = head;
        while(curr != null && k > 0) {
            k--;
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        head.next = curr;
        return prev;
    }
    
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        
        int len = getLength(head);
        k = k%len;
        
        if(k == 0) return head;
        
        // reverse complete list
        ListNode head2 = reverse(head, len);
        
        //reverse head2 for k nodes
        ListNode head3 = reverse(head2, k);
        
        // reverse head.next by (len-k) nodes
        head2.next = reverse(head2.next, len-k);
        
        return head3;
    }
}