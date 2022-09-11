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
    
    private boolean hasPathSumUtil(TreeNode root, int sum, int targetSum) {
        if(root == null) return false;
        
        sum += root.val;
        if(root.left == null && root.right == null && sum == targetSum) return true;
        
        return hasPathSumUtil(root.left, sum, targetSum) || hasPathSumUtil(root.right, sum, targetSum);
    }
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        return hasPathSumUtil(root, 0, targetSum);
    }
}