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
    
    private int getHeight(TreeNode root) {
        if(root == null) return -1;
        
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
    
    private void getElementsAtLvl(TreeNode root, int lvl, List<Integer> level) {
        if(root == null) return;
        
        if(lvl == 1) {
            level.add(root.val);
            return;
        }
        
        getElementsAtLvl(root.left, lvl-1, level);
        getElementsAtLvl(root.right, lvl-1, level);
    }
    
    // Recursive
    // TC --> O(N) || SC --> O(N)
    private List<List<Integer>> levelOrderRecursive(TreeNode root) {
        int height = getHeight(root);
        
        List<List<Integer>> levels = new ArrayList<>();
        
        for(int lvl=1; lvl<=height+1; lvl++) {
            List<Integer> level = new ArrayList<>();
            getElementsAtLvl(root, lvl, level);
            levels.add(level);
        }
        return levels;
    }
    
    // Iterative 
    // TC --> O(N) || SC --> O(N) 
    private List<List<Integer>> levelOrderIterative(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();
        
        if(root == null) return levels;
        
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            
            for(int i=0; i<size; i++) {
                TreeNode temp = q.poll();
                level.add(temp.val);
                
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right); 
            }
            levels.add(level);
        }
        return levels;
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        // iterative 
        return levelOrderIterative(root);
        
        // Recursive
        // return levelOrderRecursive(root);
    }
}