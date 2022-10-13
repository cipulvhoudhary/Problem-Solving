//{ Driver Code Starts
// driver code

import java.util.*;
import java.io.*;
import java.lang.*;

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

class GFG
{
    public static void makeLoop(Node head, Node tail, int x){
        if (x == 0) return;
        
        Node curr = head;
        for(int i=1; i<x; i++)
            curr = curr.next;
        
        tail.next = curr;
    }
    
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t--> 0)
        {
            int n = sc.nextInt();
            
            int num = sc.nextInt();
            Node head = new Node(num);
            Node tail = head;
            
            for(int i=0; i<n-1; i++)
            {
                num = sc.nextInt();
                tail.next = new Node(num);
                tail = tail.next;
            }
            
            int pos = sc.nextInt();
            makeLoop(head, tail, pos);
            
            Solution x = new Solution();
            System.out.println( x.countNodesinLoop(head) );
        }
    }
}

// } Driver Code Ends


/*

class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}

*/

//Function should return the length of the loop in LL.

class Solution {
    
    // Fucntion will return the the starting point of the cycle, if present
    // else it will return null
    public static Node detectCycle(Node head) {
        if(head == null) return null;
        
        Node slow = head;
        Node fast = head;
        Node cyclePoint = null;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast) {
                cyclePoint = slow;
                break;
            }
        }
        if(cyclePoint == null) return null;
        
        slow = head;
        fast = cyclePoint;
        
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    
    //Function to find the length of a loop in the linked list.
    static int countNodesinLoop(Node head)
    {
        //Add your code here.
        Node cp = detectCycle(head);
        
        // If no cycle is present 
        if(cp == null) return 0;
        if(cp.next == cp) return 1;
    
        Node temp = cp.next;
        int cycleLen = 2;
        
        while(temp.next != cp) {
            cycleLen++;
            temp = temp.next;
        }
        
        return cycleLen;
    }
}