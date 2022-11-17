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
    
    private ListNode getFirstMid(ListNode head) {
        ListNode slow = head, fast = head;
        
        while(fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
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
    
    public void reorderList(ListNode head) {
        ListNode mid = getFirstMid(head);
        mid.next = reverse(mid.next);
        ListNode head2 = mid.next;
        mid.next = null;
        
        ListNode t1 = head;
        ListNode t2 = head2;
        
        // Dummy node
        ListNode res = new ListNode(0);
        ListNode t3 = res;
        
        int num = 0;
        while(t1 != null || t2 != null) {
            if(num % 2 == 0) {
                t3.next = t1;
                t1 = t1.next;
            }
            else {
                t3.next = t2;
                t2 = t2.next;
            }
            num++;
            t3 = t3.next;
        }
        res = res.next;
        head = res;
    }
}



// Working code :: Not optimal, takes O(N) space

// class Solution {
//     private ListNode reverse(ListNode head) {
//         ListNode prev = null, curr = head;
//         while(curr != null) {
//             ListNode temp = curr.next;
//             curr.next = prev;
//             prev = curr;
//             curr = temp;
//         }
//         return prev;
//     }
    
//     private ListNode clone(ListNode head, int[] len) {
//         ListNode t1 = head;
//         ListNode newHead = new ListNode(0);
//         ListNode t2 = newHead;
        
//         while(t1 != null) {
//             len[0]++;
//             ListNode node = new ListNode(t1.val);
//             t2.next = node;
//             t2 = t2.next;
//             t1 = t1.next;
//         }
//         newHead = newHead.next;
//         return newHead;
//     }
    
//     public void reorderList(ListNode head) {
//         int[] len = new int[1];
        
//         ListNode head2 = clone(head, len);
//         // System.out.print(len[0]);
//         head2 = reverse(head2);
        
//         ListNode t1 = head;
//         ListNode t2 = head2;
        
//         // Dummy node
//         ListNode res = new ListNode(0);
//         ListNode temp = res;
        
//         int count = 0;
        
//         while(count < len[0]) {
            
//             if(count % 2 == 0) {
//                 temp.next = t1;
//                 t1 = t1.next;
//             }
//             else  {
//                 temp.next = t2;
//                 t2 = t2.next;
//             }
//             temp = temp.next;
//             count++;
//         }
//         temp.next = null;
        
//         res = res.next;
//         head = res;
//     }
// }