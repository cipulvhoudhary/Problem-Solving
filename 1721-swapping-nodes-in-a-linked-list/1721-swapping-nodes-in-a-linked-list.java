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
    
    // Helper function 2
    // This function will  swap two node's value
    // TC --> O(1) || SC --> O(1)
    private void swap(ListNode head1, ListNode head2) {
        if(head1 == head2) return;
        head1.val = head1.val ^ head2.val;
        head2.val = head1.val ^ head2.val;
        head1.val = head1.val ^ head2.val;
    }
    
    // Helper function 1
    // This function will return the length of the list at head
    // TC --> O(N) || SC --> O(1)
    private int getLength(ListNode head) {
        int len = 0;
        ListNode temp = head;
        
        while(temp != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }
    
    // Main function
    // Two pass
    // TC --> O(N) || SC --> O(1)
    public ListNode swapNodes(ListNode head, int k) {
        if(head.next == null) return head;
        
        // Approach 1 : Single pass
        ListNode t1 = null, t2 = null, temp = head;
        while(temp != null) {
            --k;
            if(t2 != null) t2 = t2.next;
            if(k == 0) {
                t1 = temp; // first node found at kth index from start
                t2 = head;
            }
            temp = temp.next;
        }
        
        swap(t1, t2); // Helper function 2
        return head;
        
        // Approach 2 :: double pass
        // int len = getLength(head); // Helper function 1
        // ListNode t1 = head, t2 = head;
        // int c1 = k-1, c2 = (len-k);
        // while(c1 > 0 || c2 > 0) {
        //     if(c1 > 0) {
        //         t1 = t1.next;
        //         c1--;
        //     }
        //     if(c2 > 0) {
        //         t2 = t2.next;
        //         c2--;
        //     }
        // }
        // swap(t1, t2); // Helper function 2
        // return head;
    }
}