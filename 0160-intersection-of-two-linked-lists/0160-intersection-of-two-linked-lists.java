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
    
    // Helper 1 
    // This function will return the length of list at head
    // TC --> Max(O(M), O(N))
    private int getLength(ListNode head) {
        ListNode temp = head;
        int len = 0;
        while(temp != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }
    
    // Helper2
    // This function will shift head by delta
    // TC --> Max(O(M), O(N))
    private ListNode shiftHead(ListNode head, int delta) {
        ListNode newHead = head;
        while(delta > 0 && newHead != null) {
            newHead = newHead.next;
            delta--;
        }
        return newHead;
    }
    
    // TC --> O(M+N) || SC --> O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLength(headA); // O(M) : Helper 1 
        int lenB = getLength(headB); // O(N) : Helper 1 
        
        ListNode newHeadA = headA, newHeadB = headB;
        int delta = lenA - lenB;
        if(delta > 0) { //length of list A > list B
            newHeadA = shiftHead(headA, delta); // O(M) : Helper2
        }
        else if(delta < 0) { //length of list A < list B
            // delta is negative, so sending positive value
            newHeadB = shiftHead(headB, -delta); // O(N) : Helper2
        }
        
        while(newHeadA != newHeadB) { // TC --> O(Max(O(M), O(N)))
            newHeadA = newHeadA.next;
            newHeadB = newHeadB.next;
        }
        return newHeadA;
    }
}