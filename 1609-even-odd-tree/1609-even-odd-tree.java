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
    public boolean isEvenOddTree(TreeNode root) {
        if(root.val % 2 == 0) return false;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean level = true; // true : even || false : odd
        
        while(!q.isEmpty()) {
            int size = q.size();
            int prev = 0;
            prev = (level) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            
            for(int i=0; i<size; i++) {
                TreeNode temp = q.poll();
                
                if(level && (temp.val <= prev || temp.val%2 == 0)) return false;
                if(!level && (temp.val >=prev || temp.val%2 != 0)) return false;
                prev = temp.val;
                
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
            }
            level = !level; // switch the label
        }
        return true;
    }
}