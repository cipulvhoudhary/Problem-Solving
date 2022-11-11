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
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        // Edge - case
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        ListNode t1 = l1, t2 = l2;
        ListNode res = new ListNode(0); // dummy node
        ListNode t3 = res;
        
        int carry = 0;
        
        while(t1 != null || t2 != null) {
            int sum = carry;
            if(t1 != null && t2 != null) {
                sum += t1.val + t2.val;
                t1 = t1.next;
                t2 = t2.next;
            }
            else if(t1 == null) {
                sum += t2.val;
                t2 = t2.next;
            }
            else {
                sum += t1.val;
                t1 = t1.next;
            }
            
            ListNode node = new ListNode(sum % 10);
            t3.next = node;
            t3 = t3.next;
            
            carry = sum / 10;
        }
        if(carry != 0) {
            ListNode node = new ListNode(carry);
            t3.next = node;
        }
        
        res = res.next; // remove dummy node
        return res;
    }
    
}