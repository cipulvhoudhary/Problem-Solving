/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        //base - case
        if(head == null) return null;
        
        HashMap<Node, Node> map = new HashMap<>();
        map.put(null, null);
        Node temp = head;
        Node copy = new Node(0);
        Node t = copy;
        
        while(temp != null) {
            Node newNode = new Node(temp.val);
            
            map.put(temp, newNode);
            
            t.next = newNode;
            t = t.next;
            temp = temp.next;
        }
        
        copy = copy.next; //remove dummy node
        Node p1 = head;
        Node p2 = copy;
        while(p2 != null) {
            p2.random = map.get(p1.random);
            p1 = p1.next;
            p2 = p2.next;
        }
        return copy;
    }
}