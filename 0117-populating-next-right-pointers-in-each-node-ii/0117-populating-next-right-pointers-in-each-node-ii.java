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
    
    private Node getNextNode(Node head, Node prev) {
        if(head == null) return null;
        
        Node temp = head;
        while(temp != null) {
            if(temp.left != null && temp.left != prev) {
                return temp.left;
            }
            if(temp.right != null && temp.right != prev) {
                return temp.right;
            }
            temp = temp.next;
        }
        return null;
    }
    
    public Node connect(Node root) {
        if(root == null) return root;
        
        // PreOrder traversal :: root --> left subtree --> right subtree
        
        // root
        Node temp = root;
        while(temp != null) {
            if(temp.left != null) {
                temp.left.next = getNextNode(temp, temp.left);
            }
            if(temp.right != null) {
                temp.right.next = getNextNode(temp.next, temp.right);
            }
            temp = temp.next;
        }
        
        // left subtree
        root.left = connect(root.left);
        // right subtree
        root.right = connect(root.right);
        
        return root;
    }
}