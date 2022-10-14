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
        int len = 0;
        
        while(temp != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }
    
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
    
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        
        int N = getLength(head);
        k = k % N;
        
        if(k == 0) return head;
        
        // step 1 :: reverse whole list
        head = reverse(head);
        
        // Reverse first k elements
        int count = k;
        ListNode curr = head;
        ListNode prev = null;
        while(count > 0) {
            count--;
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        // Reverse left out list whose head = curr
        // And join it in curr list's head
        head.next = reverse(curr);
        return prev;
    }
}