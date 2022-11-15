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
}