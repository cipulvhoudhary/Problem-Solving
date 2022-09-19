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
    
    private void store(TreeNode root, ArrayList<Integer> inOrder) {
        if(root == null) {
            return;
        }
        store(root.left, inOrder);
        inOrder.add(root.val);
        store(root.right, inOrder);
    }
    
    private void kthSmallestUtil(TreeNode root, int k) {
        if(root == null) return;
        
        kthSmallestUtil(root.left, k);
        count++;
        if(count == k) kthSmallestElement = root.val;
        kthSmallestUtil(root.right, k);
    }
    
    int kthSmallestElement = -1, count = 0;
    public int kthSmallest(TreeNode root, int k) {
        // ArrayList<Integer> inOrder = new ArrayList<>();
        // store(root, inOrder);
        // return inOrder.get(k-1);
        kthSmallestUtil(root, k); // TC --> O(N) || SC == O(N)
        return kthSmallestElement;
    }
}