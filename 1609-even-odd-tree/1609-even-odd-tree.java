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
    
    private boolean isSatisfying(ArrayList<Integer> level, boolean isEven) {
        if(isEven) { // level --> even
            //check if all the values are strictly incresing and odd
            int prev = Integer.MIN_VALUE;
            for(int e : level) {
                if(e > prev && e%2 != 0) {
                    prev = e;
                }
                else {
                    return false;
                }
            }
        }
        if(!isEven) { // level --> odd
            //check if all the values are strictly decreasing and even
            int prev = Integer.MAX_VALUE;
            for(int e : level) {
                if(e < prev && e%2 == 0) {
                    prev = e;
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isEvenOddTree(TreeNode root) {
        if(root.val%2 == 0) return false; // violating second instruction
        
        // The idea is to do a level order traversal and for every level, check if the level is following all the condition
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean isEven = true;
        
        while(!q.isEmpty()) {
            //change the isEven switch
            if(isEven) {
                isEven = false;
            }
            else {
                isEven = true;
            }
            
            ArrayList<Integer> level = new ArrayList<>();
            int size = q.size();
            for(int i=0; i<size; i++) {
                TreeNode temp = q.poll();
                
                if(temp.left != null) {
                    level.add(temp.left.val);
                    q.add(temp.left);
                }
                
                if(temp.right != null) {
                    level.add(temp.right.val);
                    q.add(temp.right);
                }
            }
            if(!isSatisfying(level, isEven)) return false;
        }
        return true;
    }
}