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
    
    // This function will create a list whose list(i) = node.val
    // TC --> O(N) || SC -> O(N)
    private void convertListToArrayList(ListNode head, ArrayList<Integer> list) {
        ListNode temp = head;
        while(temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }
    }
    
    
    // This function for every element in the list, will find the next greater element to it's right
    // and add it in nextGreater[] and return the final array
    // TC --> O(N) || SC --> O(N)
    private int[] getNextGreater(ArrayList<Integer> list) {
        // for last element --> since there is no element greater after that, we add 0 to list+
        int[] nextGreater = new int[list.size()];
        nextGreater[list.size()-1] = 0;
        
        Stack<Integer> st = new Stack<>(); //monotonous decreasing stack
        st.push(list.get(list.size()-1));
        
        for(int i=list.size()-2; i>=0; i--) {
            while(!st.isEmpty() && st.peek() <= list.get(i)) {
                st.pop();
            }
            
            if(!st.isEmpty()) {
                nextGreater[i] = st.peek();
            } // else nextGreater[i] = 0, which is already a default value of int[]-
            
            st.push(list.get(i));
        }
        
        return nextGreater;
    }
    
    // TC --> O(N) || SC --> O(N)
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        convertListToArrayList(head, list);
        
        int[] nextGreater = getNextGreater(list);
        
        return nextGreater;
    }
}