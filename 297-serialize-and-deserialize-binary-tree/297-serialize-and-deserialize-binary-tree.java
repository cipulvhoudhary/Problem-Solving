/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    
    // Trim unnecessary null from the end
    private String[] trimNull(String[] allNodes) {
        int N = allNodes.length;
        int end = N-1;
        while(end>=0) {
            if(allNodes[end].equals("null")) {
                end--;
            }
            else {
                break;
            }
        }
        
        String[] nodes = new String[end+1];
        for(int i=0; i<=end; i++) {
            nodes[i] = allNodes[i];
        }
        return nodes;
    }
    
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        
        // Base - case
        if(root == null) {
            return sb.toString();
        }
        
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                TreeNode temp = q.poll();
                
                if(temp == null) {
                    sb.append("null");
                }
                else {
                    sb.append(String.valueOf(temp.val));
                    q.add(temp.left);
                    q.add(temp.right);
                }
                sb.append(" ");
            }
         }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        
        String[] allNodes = data.split(" ");
        String[] nodes = trimNull(allNodes);
        int N = nodes.length;
        
        Queue<TreeNode> q = new LinkedList();
        TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));
        q.add(root);
        
        
        for(String node : nodes) {
            System.out.print(node+"  ");
        }
        
        int i = 1;
        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            if(i<N && !nodes[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.valueOf(nodes[i]));
                curr.left = left;
                q.add(left);
            }
            if(i+1<N && !nodes[i+1].equals("null")) {
                TreeNode right = new TreeNode(Integer.valueOf(nodes[i+1]));
                curr.right = right;
                q.add(right);
            }
            i += 2;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));