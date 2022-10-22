//{ Driver Code Starts
//Initial Template for Java


import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class GfG {

	static Node buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
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
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			Node currNode = queue.peek();
			queue.remove();

			// Get the current node's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current node
				currNode.left = new Node(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current node
				currNode.right = new Node(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}

	static void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String s = br.readLine();
			int target = Integer.parseInt(br.readLine());
			Node root = buildTree(s);

			Solution g = new Solution();
			System.out.println(g.minTime(root, target));
			t--;

		}
	}
}



// } Driver Code Ends

    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    
//User function Template for Java

class Solution {
    
    public static boolean getPath(Node root, int target, List<Node> path) {
        if(root == null) return false;
        
        if(root.data == target) {
            path.add(root);
            return true;
        }
        
        boolean left = getPath(root.left, target, path);
        boolean right = getPath(root.right, target, path);
        
        if(left || right) path.add(root);
        
        return (left || right);
    }
    
    public static int countBelow(Node root, int k) {
        if(root == null || k < 0) return 0;
        if(k==0) return 1;
        
        k--;
        int left = countBelow(root.left, k);
        int right = countBelow(root.right, k);
        
        return left + right;
    }
    
    public static int countNodesKdistance(Node root, int target, int k, List<Node> path) {
        if(root == null) return 0;
        if(k == 0) return 1;
        
        
        
        int totalNodesAtKdistance = 0;
        
        for(int i=0; i<path.size(); i++) {
            Node curr = path.get(i);
            
            if(k == 0) {
                totalNodesAtKdistance += 1;
                break;
            }
            
            if(i == 0) {
                totalNodesAtKdistance += countBelow(curr, k);
            }
            else {
                Node prev = path.get(i-1);
                
                if(curr.left == prev) {
                    totalNodesAtKdistance += countBelow(curr.right, k-1);
                }
                else if(curr.right == prev) {
                    totalNodesAtKdistance += countBelow(curr.left, k-1);
                }
            }
            k--;
        }
        return totalNodesAtKdistance;
    }
    
    public static int minTime(Node root, int target) {
        
        List<Node> path = new ArrayList<>();
        boolean isPath = getPath(root, target, path);
        
        if(!isPath) return 0;
        
        int time = 0;
        int k=0;
        while(true) {
            int totalNodesAtKdistance = countNodesKdistance(root, target, k, path);
            k++;
            
            if(totalNodesAtKdistance != 0) time++; // Node are still burning
            else break; // No nodes are left to burn
        }
        return time-1;
    }
}