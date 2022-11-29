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
    int diameter;
    int height;
    
    public NodeInfo(int diameter, int height) {
        this.diameter = diameter;
        this.height = height;
    }
}

class Solution {
    
    private NodeInfo diameterOfBinaryTreeUtil(TreeNode root) {
        // Base - case
        if(root == null) return (new NodeInfo(0, -1));
        
        // Main- logic
        NodeInfo leftInfo = diameterOfBinaryTreeUtil(root.left);
        NodeInfo rightInfo = diameterOfBinaryTreeUtil(root.right);
        
        int diameterThroughRoot = 2 + (leftInfo.height + rightInfo.height);
        int heightAtRoot = 1 + Math.max(leftInfo.height, rightInfo.height);
        
        int finalDiameter = Math.max(diameterThroughRoot, Math.max(leftInfo.diameter, rightInfo.diameter));
        
        return (new NodeInfo(finalDiameter, heightAtRoot));
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        return diameterOfBinaryTreeUtil(root).diameter;
    }
}