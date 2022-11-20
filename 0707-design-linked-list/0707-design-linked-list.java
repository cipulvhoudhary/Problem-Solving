class Node {
    int val;
    Node next;
    public Node(int val) {
        this.val = val;
    }
}

class MyLinkedList {
    
    Node head;
    
    public MyLinkedList() {
        Node head = null;
        this.head = head;
    }
    
    public int get(int index) {
        int k = index;
        Node temp = head;
        while(k > 0 && temp != null) {
            temp = temp.next;
            k--;
        }
        if(temp != null) return temp.val;
        return -1;
    }
    
    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
    }
    
    public void addAtTail(int val) {
        Node node = new Node(val);
        
        if(head == null) {
            head = node;
            return;
        }
        
        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }
    
    public void addAtIndex(int index, int val) {
        Node node = new Node(val);
        
        if(index == 0) {
            node.next = head;
            head = node;
            return;
        }
        
        int k = index - 1;
        Node temp = head;
        while(k > 0 && temp != null) {
            temp = temp.next;
            k--;
        }
        
        if(temp != null) {
            node.next = temp.next;
            temp.next = node;
        }
    }
    
    public void deleteAtIndex(int index) {        
        if(index == 0) {
            head = head.next;
            return;
        }
        
        int k = index - 1;
        Node temp = head;
        
        while(k > 0 && temp != null) {
            k--;
            temp = temp.next;
        }
        
        if(temp != null && temp.next != null) {
            Node temp2 = temp.next;
            temp.next = temp.next.next;
            temp2.next = null;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */