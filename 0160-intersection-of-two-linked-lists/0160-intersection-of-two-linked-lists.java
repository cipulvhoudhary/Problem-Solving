/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    
    private int getLength(ListNode head) {
        ListNode temp = head;
        int len = 0;
        while(temp != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }
    
    private ListNode shiftHead(ListNode temp, int diff) {
        while(diff != 0 && temp != null) {
            diff--;
            temp = temp.next;
        }
        return temp;
    }
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        if(headA == headB) return headA;
        
        int len1 = getLength(headA);
        int len2 = getLength(headB);
        
        int diff = len1 - len2;
        
        System.out.print(diff);
        
        ListNode t1 = headA;
        ListNode t2 = headB;
        
        if(diff > 0) {
            t1 = shiftHead(t1, diff);
        }
        else {
            t2 = shiftHead(t2, -diff);
        }
        
        while(t1!= null && t2 != null && t1 != t2) {
            t1 = t1.next;
            t2 = t2.next;
        }
        
        if(t1 == null || t2 == null) return null;
        
        return t1;
    }
}