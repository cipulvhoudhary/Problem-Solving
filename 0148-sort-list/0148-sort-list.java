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
    
    // Helper 1 
    // This function will return the first mid of list
    // TC --> O(N) || SC --> O(1)
    private ListNode getFirstMid(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    // Helper 2 
    // This function will merge two list 
    // TC --> O(M+M) || SC --> O(1) 
    // M : length of list1 ||  N : length of list2
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        // Edge case
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        
        if(list1.val > list2.val) return mergeTwoLists(list2, list1);
        
        ListNode t1 = list1, t2 = list2;
        ListNode res = new ListNode(0);
        ListNode t3 = res;
        
        while(t1 != null && t2 != null) {
            if(t1.val <= t2.val) {
                t3.next = t1;
                t1 = t1.next;
            }
            else {
                t3.next = t2;
                t2 = t2.next;
            }
            t3 = t3.next;
        }
        if(t1 == null) {
            t3.next = t2;
        }
        if(t2 == null) {
            t3.next = t1;
        }
        
        res = res.next;
        return res;
    }
    
    
    // Main function 
    // TC --> O(N * logN) || SC --> O(N)
    public ListNode sortList(ListNode head) {
        // base - case
        if(head == null || head.next == null) return head;
        
        ListNode mid = getFirstMid(head); // Helper 1
        ListNode head2 = mid.next;
        mid.next = null;
        
        head = sortList(head);
        head2 = sortList(head2);
        
        return mergeTwoLists(head, head2); // Helper 2
    }
}