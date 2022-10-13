//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(first, second);
            printList(res);
        }
    }
}

// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    
    public static Node reverse(Node head) {
        Node curr = head;
        Node prev = null;
        
        while(curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    
    public static Node addTwoListsUtil(Node first, Node second) {
        
        Node t1 = first;
        Node t2 = second;
        
        int sum = t1.data + t2.data;
        int carry = sum / 10;
        Node res = new Node(sum % 10);
        Node t3 = res;
        
        t1 = t1.next;
        t2 = t2.next;
        
        while(t1 != null && t2 != null) {
            sum = t1.data + t2.data + carry;
            Node node = new Node(sum % 10);
            carry = sum / 10;
            t3.next = node;
            t3 = t3.next;
            t1 = t1.next;
            t2 = t2.next;
        }
        if(t2 == null) {
            while(t1 != null) {
                sum = t1.data + carry;
                carry = sum / 10;
                Node node = new Node(sum % 10);
                t3.next = node;
                t3 = t3.next;
                t1 = t1.next;
            }
        }
        if(t1 == null) {
            while(t2 != null) {
                sum = t2.data + carry;
                carry = sum / 10;
                Node node = new Node(sum % 10);
                t3.next = node;
                t3 = t3.next;
                t2 = t2.next;
            }
        }
        if(carry != 0) {
            t3.next = new Node(carry);
        }
        return res;
    }
    
    //Function to add two numbers represented by linked list.
    static Node addTwoLists(Node first, Node second){
        // Edge case
        if(first == null) return second;
        if(second == null) return first;
        
        first = reverse(first);
        second = reverse(second);
        
        Node sum = addTwoListsUtil(first, second);
        
        return reverse(sum);
    }
}