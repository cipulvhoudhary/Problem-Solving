//{ Driver Code Starts
// Initial Template for Java

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
            if (i >= ip.length) break;

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
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Solution g = new Solution();
            System.out.println(g.diameter(root));
            t--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java

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

class NodeInfo {
    int dia;
    int ht;
    public NodeInfo(int dia, int ht) {
        this.dia = dia;
        this.ht = ht;
    }
}

class Solution {
    
    public static NodeInfo diameterUtil(Node root) {
        // Base - case 
        if(root == null) {
            return (new NodeInfo(0, 0));
        }
        
        // Main - logic
        NodeInfo lInfo = diameterUtil(root.left);
        NodeInfo rInfo = diameterUtil(root.right);
        
        int currD = 2 + (lInfo.ht + rInfo.ht);
        int currH = 1 + Math.max(lInfo.ht, rInfo.ht);
        int finalD = Math.max(currD, Math.max(lInfo.dia, rInfo.dia));
        return ( new NodeInfo(finalD, currH) );
    }
    // Function to return the diameter of a Binary Tree.
    int diameter(Node root) {
        return diameterUtil(root).dia-1;
    }
}
