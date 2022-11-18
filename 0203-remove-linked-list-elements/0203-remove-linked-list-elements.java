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
    public ListNode removeElements(ListNode head, int val) {
        while(head != null && head.val == val) head = head.next;
        if(head == null) return head;
        
        ListNode temp = head;
        
        while(temp != null) {
            ListNode temp2 = temp.next;
            while(temp2 != null && temp2.val == val) {
                temp2 = temp2.next;        
            }
            temp.next = temp2;
            temp = temp.next;
        }
        return head;
    }
}