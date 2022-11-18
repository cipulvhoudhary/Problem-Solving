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
        HashMap<Node, Node> map = new HashMap<>();
        map.put(null, null);
        
        Node head2 = new Node(0);
        Node t1 = head;
        Node t2 = head2;
        
        // Cpy the list with only next pointer
        while(t1 != null) {
            Node copyNode = new Node(t1.val);
            t2.next = copyNode;
            t2 = t2.next;
            
            // Put this in map :: key --> main list node, value --> copy list node
            map.put(t1, t2);
            
            t1 = t1.next;
        }
        
        // Remove dummy node
        head2 = head2.next;
        
        // Again traverse list1 and list2 at head and head2 respectively
        t1 = head;
        t2 = head2;
        
        // mapping random pointer of node of copy list
        while(t1 != null) {
            t2.random = map.get(t1.random);
            t1 = t1.next;
            t2 = t2.next;
        }
        return head2;
    }
}