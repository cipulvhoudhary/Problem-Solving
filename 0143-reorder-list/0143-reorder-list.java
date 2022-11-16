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
    
    private ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    
    private ListNode clone(ListNode head, int[] len) {
        ListNode t1 = head;
        ListNode newHead = new ListNode(0);
        ListNode t2 = newHead;
        
        while(t1 != null) {
            len[0]++;
            ListNode node = new ListNode(t1.val);
            t2.next = node;
            t2 = t2.next;
            t1 = t1.next;
        }
        newHead = newHead.next;
        return newHead;
    }
    
    public void reorderList(ListNode head) {
        int[] len = new int[1];
        
        ListNode head2 = clone(head, len);
        // System.out.print(len[0]);
        head2 = reverse(head2);
        
        ListNode t1 = head;
        ListNode t2 = head2;
        
        // Dummy node
        ListNode res = new ListNode(0);
        ListNode temp = res;
        
        int count = 0;
        
        while(count < len[0]) {
            
            if(count % 2 == 0) {
                temp.next = t1;
                t1 = t1.next;
            }
            else  {
                temp.next = t2;
                t2 = t2.next;
            }
            temp = temp.next;
            count++;
        }
        temp.next = null;
        
        res = res.next;
        head = res;
    }
}