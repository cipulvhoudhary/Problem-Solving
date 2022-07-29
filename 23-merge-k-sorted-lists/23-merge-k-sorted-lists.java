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
    
    private ListNode merge(ListNode l1, ListNode l2) { //TC --> O(Max(A,B)) || A, B are lengthof list1 and list2
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        ListNode res = null;
        if(l1.val <= l2.val) {
            res = l1;
            l1 = l1.next;
        }
        else {
            res = l2;
            l2 = l2.next;
        }
    
        ListNode temp = res;
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                temp.next = l1;
                l1 = l1.next;
            }
            else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if(l1 == null) {
            temp.next = l2;
        }
        if(l2 == null) {
            temp.next = l1;
        }
        return res;
    }
    
    private ListNode mergeSort(ListNode[] lists, int i, int j) {
        if(j < i) return null;
        if(i == j) return lists[i]; 
        
        int mid = (i + j) / 2;
        ListNode l1 = mergeSort(lists, i, mid);
        ListNode l2 = mergeSort(lists, mid+1, j);
        return merge(l1, l2);
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        /* Approach 
        - T(N) = 2*T(N/2) + O(max(A,B))
        - TC --> O(N*logN*Max(A, B))[N->length of lists | A,B length of individual sorted list] || SC --> O(N)[stack space in recursion calls]
        - MergeSort will help in dividing the list equally every time,
        - When merge Sort divides the list in a single list 
        - We will have to perform merge on both the single list as both list are sorted beforehand
        */
        int N = lists.length;
        int p1 = 0, p2 = N-1;
        return mergeSort(lists, p1, p2);
    }
}