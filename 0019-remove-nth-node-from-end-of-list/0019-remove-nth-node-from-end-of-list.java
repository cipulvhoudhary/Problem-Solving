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
    
    private int getLength(ListNode head) {
        ListNode temp = head;
        int len = 0;
        while(temp != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }
    
    private void removeNthNode(ListNode head, int N) {
        // N--> 1 based indexing
        // To remove Nth node, we need to reach at N-1th index
        
        int ind = 1;
        ListNode temp = head;
        while(temp != null && ind < N-1) {
            ind++;
            temp = temp.next;
        }
        ListNode temp2 = temp.next;
        temp.next = temp.next.next;
        temp2.next = null;
    }
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /* 
        Approach
        To delete (n)th node from last is same as deleting (len-n+1) node from start
        [1-based indexing]
        - Get length of the list
        - Delete (len-n+1) node
        */
        int len = getLength(head);
        int indextToDelete = len-n+1;
        
        if(indextToDelete == 1) {
            head = head.next;
            return head;
        }
        removeNthNode(head, indextToDelete);
        return head;
    }
}