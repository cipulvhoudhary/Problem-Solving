/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        /* 
        Algo ::
        - Find the cycle point
        - Take slow and fast at head, move slow by one node and fast by two node
        - If they never met, fat will become null, return null :: No cycle 
        - Cycle point :: where slow and fast pointer met first
        - Now start slow at head and fast at cycle point, move them one node at a time till they met
        - When they met, return slow(or fast)
        */
        
        ListNode slow = head, fast = head;
        ListNode cyclePoint = null;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast) {
                cyclePoint = slow;
                break;
            }
        }
        
        // if no cycle :: cycle point will be at null only
        if(cyclePoint == null) return null;
        
        slow = head;
        fast = cyclePoint;
        
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}