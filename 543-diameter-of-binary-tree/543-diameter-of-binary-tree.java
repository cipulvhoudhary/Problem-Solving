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

class NodeInfo {
    int ht;
    int dia;
    public NodeInfo(int ht, int dia) {
        this.ht = ht;
        this.dia = dia;
    }
}

class Solution {
    
    private NodeInfo diameterOfBinaryTreeUtil(TreeNode root) {
        // Base - case 
        if(root == null) {
            return new NodeInfo(-1, 0);
        }
        
        NodeInfo lInfo = diameterOfBinaryTreeUtil(root.left);
        NodeInfo rInfo = diameterOfBinaryTreeUtil(root.right);
        
        int height = 1 + Math.max(lInfo.ht, rInfo.ht);
        int currDia = 2 + lInfo.ht + rInfo.ht;
        
        int diameter = Math.max(currDia, Math.max(lInfo.dia, rInfo.dia));
        
        return new NodeInfo(height, diameter);
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        return diameterOfBinaryTreeUtil(root).dia;
    }
}