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
    
    private boolean isLeaf(TreeNode root) {
        return (root.left == null && root.right == null);    
    }
    
    private TreeNode flattenUtil(TreeNode root) {
        // Base - case
        if(root == null || isLeaf(root)) return root;
        
        // Main - logic
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        root.right = flattenUtil(left);
        
        TreeNode temp = root;
        while(temp.right != null) {
            temp = temp.right;
        }
        temp.right = flattenUtil(right);
        root.left = null;
        return root;
    }
    
    public void flatten(TreeNode root) {
        root = flattenUtil(root);
    }
}