/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    
    private Node getNextRight(Node root) {
        if(root == null) return null;
        while(root != null) {
            if(root.left != null) return root.left;
            if(root.right != null) return root.right;
            root = root.next;
        }
        return null;
    }
    
    public Node connect(Node root) {
        // Base - case
        if(root == null) return null;
        
        if(root.left != null) {
            if(root.right != null) {
                root.left.next = root.right;
            }
        }
        if(root.right != null) {
            root.right.next = getNextRight(root.next);
        }
        root.left = connect(root.left);
        root.right = connect(root.right);
        return root;
    }
}