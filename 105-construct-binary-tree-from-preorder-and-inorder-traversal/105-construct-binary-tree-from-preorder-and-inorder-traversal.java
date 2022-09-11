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
    private TreeNode buildTreeUtil(int sP, int eP, int sI, int eI, int[] preOrder, int[] inOrder, HashMap<Integer, Integer> map) {
        if(eP - sP < 0) return null;
        
        int ind = map.get(preOrder[sP]);
        int count = ind - sI;
        
        TreeNode root = new TreeNode(preOrder[sP]);
        
        root.left = buildTreeUtil(sP+1, sP+count, sI, ind-1, preOrder, inOrder, map);
        root.right = buildTreeUtil(sP+count+1, eP, ind+1, eI, preOrder, inOrder, map);
        
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //Build a map for inOrder : Key --> inOrder[i], Value --> i
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<inorder.length; i++) {
            map.put(inorder[i], i); // preorder and inorder consist of unique values
        }
        
        return buildTreeUtil(0, preorder.length-1, 0, inorder.length-1, preorder, inorder, map);
    }
}