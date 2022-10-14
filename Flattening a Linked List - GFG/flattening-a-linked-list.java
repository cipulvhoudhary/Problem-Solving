//{ Driver Code Starts
import java.util.Scanner;
import java.util.*;
import java.io.*;

class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}


class Flatttening_A_LinkedList
{	
    Node head;
	
	void printList(Node node)
    {
        //Node temp = head;
        while (node != null)
        {
            System.out.print(node.data + " ");
            node =node.bottom;
        }
        System.out.println();
    }
	public  static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		Flatttening_A_LinkedList list = new Flatttening_A_LinkedList();
		while(t>0)
		{
			int N = sc.nextInt();
			int arr[] = new int[N];
			for(int i=0;i<N;i++)
				arr[i] = sc.nextInt();
			
			Node temp = null;
			Node tempB = null;
			Node pre = null;
			Node preB = null;	
			int flag=1;
			int flag1=1;
			for(int i=0; i<N;i++)
			{
				int m = arr[i];
				m--;
				int a1 = sc.nextInt();
				temp = new Node(a1);
				if(flag == 1)
				{
					list.head = temp;
					pre = temp;
					flag = 0;
					flag1 = 1;
				}
				else
				{
					pre.next = temp;
					pre = temp;
					flag1 = 1;
				}
				
				for(int j=0;j<m;j++)
				{
					int a = sc.nextInt();
					tempB = new Node(a);
					if(flag1 == 1)
					{
						temp.bottom = tempB;
						preB = tempB;
						flag1 = 0;
					}
					else
					{
						preB.bottom = tempB;
						preB = tempB;
					}
				}
				
			}
			//list.printList();
			GfG g = new GfG();
			Node root = g.flatten(list.head);
			list.printList(root);
		
		t--;
		}
	}	
}
// } Driver Code Ends


/*Node class  used in the program
class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}
*/
/*  Function which returns the  root of 
    the flattened linked list. */
class GfG {
    
    static Node get1stMid(Node root) {
        if(root == null) return null;
        
        Node slow = root;
        Node fast = root;
        
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    static Node merge(Node head1, Node head2) {
        // Using bottom pointer;
        
        Node t1 = head1, t2 = head2;
        Node res = null, t3 = null;
        
        // Setting up the initial root of res
        if(t1.data <= t2.data) {
            res = t1;
            t3 = res;
            t1 = t1.bottom;
        }
        else {
            res = t2;
            t3 = res;
            t2 = t2.bottom;
        }
        
        
        while(t1 != null && t2 != null) {
            if(t1.data <= t2.data) {
                t3.bottom = t1;
                t3 = t3.bottom;
                t1 = t1.bottom;
            }
            else {
                t3.bottom = t2;
                t3 = t3.bottom;
                t2 = t2.bottom;
            }
        }
        if(t1 == null) {
            t3.bottom = t2;
        }
        if(t2 == null) {
            t3.bottom = t1;
        }
        
        return res;
    }
    Node flatten(Node root) {
	    // Base - case :: when single list is left
	    if(root == null || root.next == null) return root;
	    
	    // Main - logic
	    
	    // Using next pointer
	    Node mid = get1stMid(root);
	    
	    Node mid2 = mid.next;
	    
	    mid.next = null; // Divide
	    
	    // Now we have two list :: root and mid2
	    
	    Node l1 = flatten(root);
	    Node l2 = flatten(mid2);
	    
	    //Using bottom
	    return merge(l1, l2);
    }
}