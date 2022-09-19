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
    
    private int leftDepthDFS(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        
        int leftDepth = leftDepthDFS(root.left);
        int rightDepth = leftDepthDFS(root.right);
        
        if(leftDepth == 0 || rightDepth == 0) {
            return 1 + leftDepth + rightDepth;
        }
        return 1 + Math.min(leftDepth, rightDepth);
    }
    
    private int leftDepthBFS(TreeNode root) {
        if(root == null) return 0;
        
        if(root.left == null && root.right == null) return 1;
        
        int level = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            level++;
            for(int i=0; i<size; i++) {
                TreeNode temp = q.poll();
                if(temp.left == null && temp.right == null) return level;
                
                if(temp.left != null) {
                    q.add(temp.left);
                }
                if(temp.right != null) {
                    q.add(temp.right);
                }
            }
        }
        return -1;
    }
    
    public int minDepth(TreeNode root) {
        // return leftDepthDFS(root);
        return leftDepthBFS(root);
    }
}