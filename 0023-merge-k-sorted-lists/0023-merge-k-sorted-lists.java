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
        // TC --> O(M+N) || SC --> O(1)
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
    
    private ListNode mergeSort(ListNode[] lists, int s, int e) {
        // Base - case
        int size = e-s+1;
        if(size == 0) return null;
        if(size == 1) return lists[s];
        
        // Main - logic
        int mid = (s+e) / 2;
        ListNode list1 = mergeSort(lists, s, mid);
        ListNode list2 = mergeSort(lists, mid+1, e);
        return mergeTwoLists(list1, list2);
        
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if(n == 0) return null;
        if(n == 1) return lists[0];
        
        int s = 0, e = lists.length-1;
        return mergeSort(lists, s, e);
        
    }
}