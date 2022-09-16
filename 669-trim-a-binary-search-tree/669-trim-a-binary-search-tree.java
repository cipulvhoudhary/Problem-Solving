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
    - TC --> O(N) || SC --> O(1) 
    - Three cases -->            [low]---------------[high]
    -                --------------|--------------------|------------------  
    Region ::               1                 2                   3  
    
    // Case 1 : if root lies in region 2. Need to trim both sides of the tree, 
    //          since, other nodes value might lies outside boundaries
    
    // Case 2 : If root lies in region 1. All the elements in LST are also 
    //          out of range[node's.val < low], so we need to trim RST here.
    
    // Case 2 : If root lies in region 3. All the elements in RST are also 
    //          out of range[node's.val > high], so we need to trim LST here.
    */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        // Base - case
        if(root == null) return null;
        
        if(root.val < low) {
            // Need to trim right subtree, as all the elements in the
            //  left subtree is already less than root's val
            return trimBST(root.right, low, high);
        }
        else if(root.val > high) {
            // Need to trim left subtree, as all the elements in the
            // right subtree is already greater than root's val
            return trimBST(root.left, low, high);
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}