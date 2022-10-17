//{ Driver Code Starts
//Initial Template for JAVA

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

public class Tree {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	    	
                Solution ob = new Solution();

                ArrayList<Integer> vec = ob.topView(root);
                for(int x : vec)
                    System.out.print(x + " ");
                System.out.println();
        	
                t--;   
        }
    }
}
// } Driver Code Ends


//User function Template for Java

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Pair {
    Node node;
    int dist;
    public Pair(Node node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}

class Solution {
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root) {
        ArrayList <Integer> res = new ArrayList <Integer>();
        if(root == null) return res;
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        
        int maxD = Integer.MIN_VALUE;
        int minD = Integer.MAX_VALUE;
        
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        
        while(!q.isEmpty()) {
            Pair temp = q.poll();
            Node node = temp.node;
            int dist = temp.dist;
            
            maxD = Math.max(maxD, dist);
            minD = Math.min(minD, dist);
            
            if(!map.containsKey(dist)) {
                map.put(dist, new ArrayList<>());
            }
            map.get(dist).add(node.data);
            
            if(node.left != null) {
                q.add(new Pair(node.left, dist-1));
            }
            if(node.right != null) {
                q.add(new Pair(node.right, dist+1));
            }
        }
        
        for(int i=minD; i<=maxD; i++) {
            ArrayList<Integer> list = map.get(i);
            res.add(list.get(0));
        }
        return res;
    }
}