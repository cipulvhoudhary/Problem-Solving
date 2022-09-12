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
    
    private void recoverTreeUtil(TreeNode root) {
        if(root == null) return;
        
        recoverTreeUtil(root.left);
        
        if(prev != null) {
            if(root.val < prev.val) {
                if(n1 == null) {
                    n1 = prev;
                }
                n2 = root;
            }
        }
        prev = root;
        
        recoverTreeUtil(root.right);
    }
    
    TreeNode prev = null;
    TreeNode n1 = null;
    TreeNode n2 = null;
    
    public void recoverTree(TreeNode root) {
        recoverTreeUtil(root);
        System.out.print(prev.val + " " + n1.val + " " + n2.val);
        n1.val = n1.val ^ n2.val;
        n2.val = n1.val ^ n2.val;
        n1.val = n1.val ^ n2.val;
    }
    
}