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
        ListNode prev = null, curr = head;
        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        // Edge - case
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        ListNode revL1 = reverse(l1);
        ListNode revL2 = reverse(l2);
        
        ListNode t1 = revL1, t2 = revL2;
                
        ListNode res = new ListNode(0);
        ListNode t3 = res;
        
        int carry = 0;
        while(t1 != null || t2 != null) {
            int sum = carry;
            if(t1 != null && t2 != null) {
                sum += (t1.val + t2.val);
                t1 = t1.next;
                t2 = t2.next;
            }
            else if(t1 != null) {
                sum += t1.val;
                t1 = t1.next;
            }
            else {
                sum += t2.val;
                t2 = t2.next;
            }
            
            ListNode newNode = new ListNode(sum % 10);
            t3.next = newNode;
            t3 = t3.next;
            carry = sum / 10;
        }
        if(carry != 0) {
            ListNode newNode = new ListNode(carry);
            t3.next = newNode;
        }
        res = res.next; // removing dummy node
        
        return reverse(res);
    }
}