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
    /* Approach : 
    - TC --> O(N) || SC --> O(N); [Skewed Tree]
    - DFS traversal and add the last element of every level */
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> rightView = new ArrayList<>();
        
        if(root == null) return rightView;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            // List<Integer> level = new ArrayList<>();
            
            for(int i=0; i<size; i++) {
                TreeNode temp = q.poll();
                // level.add(temp.val);
                
                if(i == size-1) {
                    rightView.add(temp.val);
                }
                
                if(temp.left != null) {
                    q.add(temp.left);
                }
                if(temp.right != null) {
                    q.add(temp.right);
                }
                
            }
            // rightView.add(level.get(level.size()-1));
        }
        return rightView;
    }
}