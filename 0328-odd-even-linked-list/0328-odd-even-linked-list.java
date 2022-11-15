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
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return head;
        
        // Dummy nodes to avoid unnecessary if-else construct
        ListNode l1 = new ListNode(0, null);
        ListNode l2 = new ListNode(0, null);
        
        ListNode t1 = l1;
        ListNode t2 = l2;
        ListNode t = head;
        int c = 0;
        
        while(t != null) {
            c++;
            if(c%2 != 0) {
                t1.next = t;
                t1 = t1.next;
            }
            else {
                t2.next = t;
                t2 = t2.next;
            }
            t = t.next;
        }
        
        // To remove dummy nodes 
        l1 = l1.next;
        l2 = l2.next;
        
        // To avoid unnecessary cycle forming
        t1.next = null;
        t2.next = null;
        
        if(l1 == null) return l2;
        
        t1.next = l2;
        return l1;
    }
}