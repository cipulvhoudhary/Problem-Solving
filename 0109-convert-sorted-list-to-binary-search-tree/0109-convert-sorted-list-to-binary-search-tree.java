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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
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
    
    public TreeNode sortedListToBST(ListNode head) {
        // Base - case
        if(head == null) return null;
        if(head.next == null) {
            TreeNode root = new TreeNode(head.val);
            return root;
        } 
        
        // Main - logic
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prev = getFirstMid(dummy);
        dummy = dummy.next;
        
        ListNode mid = prev.next;
        TreeNode root = new TreeNode(mid.val);
        
        prev.next = null;
        
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        return root;
    }
}