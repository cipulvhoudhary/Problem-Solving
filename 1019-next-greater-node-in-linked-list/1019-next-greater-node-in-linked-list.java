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
    
    private ArrayList<Integer> getNextGreater(ListNode head, ArrayList<Integer> list) {
        // for firts element --> since there is no element greater before, we add 0 to list
        list.add(0);
        
        // from first node
        ListNode temp = head.next;
        
        Stack<Integer> st = new Stack<>();
        st.push(head.val);
        
        while(temp != null) {
            while(!st.isEmpty() && st.peek() <= temp.val) {
                st.pop();
            }
            
            if(st.isEmpty()) {
                list.add(0);
            }
            else {
                list.add(st.peek());
            }
            
            st.push(temp.val);
            temp = temp.next;
        }
        
        return list;
    }
    
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        
        head = reverse(head);
        
        list = getNextGreater(head, list);
        
        int[] res = new int[list.size()];
        
        int ind = 0;
        for(int i=list.size()-1; i>=0; i--) {
            res[ind++] = list.get(i);
        }
        return res;
    }
}