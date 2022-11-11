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
    
    // TC --> O(M+N) || SC --> O(M+N)
    // M : length of list1 
    // N :: length of list2
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        // Edge - case :: if any list is null, return the other list
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        ListNode t1 = l1, t2 = l2;
        
        // dummy node
        // Taking dummy node to avoid multiple if-else
        ListNode res = new ListNode(0); 
        ListNode t3 = res;
        
        int carry = 0;
        
        // Approach -->
        // till any one of the list has some nodes, it will be considered in the sum
        // Think of it like a basic addition we do perform of decimal number system
        // sum = a+b
        // if a+b >= 10 , we take mod of (a+b) with 10 (because dealing with decimal number system)
        // and place mod value below a and b
        // and take carry as sum / 10
        
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
        
        //If carry is left
        //            1 1 1 1(carry which got left) 
        // l1 --> 9 9 9 9 
        // l2 --> 9 9
        //        8 9 0 0 1
            
        if(carry != 0) {
            ListNode node = new ListNode(carry);
            t3.next = node;
        }
        
        res = res.next; // remove dummy node
        return res;
    }
    
}