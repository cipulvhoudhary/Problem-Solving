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
    
    private void pathSumUtil(TreeNode root, int sum, int targetSum, List<Integer> path, List<List<Integer>> paths) {
        if(root == null) return;
        
        sum += root.val;
        path.add(root.val);
        if(root.left == null && root.right == null && sum == targetSum) {
            //clone the list and add it to paths
            paths.add(new ArrayList<Integer>(path));
            //remove last added element from path
            path.remove(path.size()-1);
            return;
        }
        pathSumUtil(root.left, sum, targetSum, path, paths);
        pathSumUtil(root.right, sum, targetSum, path, paths);
        path.remove(path.size()-1);
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        pathSumUtil(root, 0, targetSum, path, paths);
        return paths;
    }
}