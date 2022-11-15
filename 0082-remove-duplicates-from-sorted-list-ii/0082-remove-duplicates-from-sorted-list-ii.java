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
    public ListNode deleteDuplicates(ListNode head) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        ListNode temp = head;
        while(temp != null) {
            map.put(temp.val, map.getOrDefault(temp.val, 0)+1);
            temp = temp.next;
        }
        
        temp = head;
        ListNode res = new ListNode(0);
        ListNode temp2 = res;
        while(temp != null) {
            int key = temp.val;
            int value = map.get(key);
            
            if(value == 1) {
                temp2.next = new ListNode(key);
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        res = res.next;
        return res;
    }
}