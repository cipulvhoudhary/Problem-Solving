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
    
    private Node getNextRight(Node root, Node base) {
        if(root == null) return root;
        
        if(root.left != base) {
            return root.left;
        }
        return root.right;
    }
    
    public Node connect(Node root) {
        if(root == null) return root;
        
        Node temp = root;
        while(temp != null) {
            if(temp.left != null) {
                temp.left.next = getNextRight(temp, temp.left);
            }
            if(temp.right != null) {
                temp.right.next = getNextRight(temp.next, temp.right);
            }
            temp = temp.next;
        }
        root.left = connect(root.left);
        root.right = connect(root.right);
        return root;
    }
    
}