//{ Driver Code Starts
import java.io.*;
import java.util.*;
class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}
class GfG
{
    public static void printList(Node node) 
    { 
        while (node != null)
        { 
            System.out.print(node.data);
            node = node.next; 
        }  
        System.out.println();
    } 
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Node head = new Node( s.charAt(0) - '0' );
                    Node tail = head;
                    for(int i=1; i<s.length(); i++)
                    {
                        tail.next = new Node( s.charAt(i) - '0' );
                        tail = tail.next;
                    }
                    Solution obj = new Solution();
                    head = obj.addOne(head);
                    printList(head); 
                }
        }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
} 
*/

class Solution {
    
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
    
    // public static Node addOneUtil(Node head) {
    //     int carry = 1;
        
    //     Node temp = head;
        
    //     while(temp != null) {
    //         int sum = temp.data + carry;
    //         carry = carry / 10;
    //         sum = sum % 10;
    //         temp.data = sum;
            
    //         if(temp.next == null) {
    //             if(carry != 0) {
    //                 Node node = new Node(carry);
    //                 temp.next = node;
    //                 break;
    //             }
    //         }
    //     }
    //     return head;
    // }
    
    public static Node addOne(Node head) { 
        //code here.
        head = reverse(head);
        
        int carry = 1;
        Node curr = head, prev = head;
        int sum = head.data + carry;
        
        curr.data = sum % 10;
        carry = sum / 10;
        
        curr = curr.next;
        
        while(curr != null) {
            sum = curr.data + carry;
            curr.data = sum % 10;
            carry = sum / 10;
            curr = curr.next;
            prev = prev.next;
        }
        
        if(carry != 0) {
            Node c = new Node(carry);
            prev.next = c;
        }
        
        return reverse(head);
    }
}