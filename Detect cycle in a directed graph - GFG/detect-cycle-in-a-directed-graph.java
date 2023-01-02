//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        // Approach --> Apply Kahn's algo to get topo sort
        // if in topo[], size is less than V --> there is a cycle
        
        int[] inDegree = new int[V];
        for(int i=0; i<V; i++) {
            ArrayList<Integer> adjNodes = adj.get(i);
            for(int adjNode : adjNodes) {
                if(i != adjNode) { // no self nodes
                    inDegree[adjNode]++;
                }
                else 
                    return true;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<inDegree.length; i++) {
            if(inDegree[i] == 0) q.add(i);
        }
        
        // ArrayList<Integer> topo = new ArrayList<Integer>();
        int count = 0;
        while(!q.isEmpty()) {
            int node = q.poll();
            // topo.add(node);
            count++;
            
            ArrayList<Integer> adjNodes = adj.get(node);
            for(int adjNode : adjNodes) {
                inDegree[adjNode]--;
                if(inDegree[adjNode] == 0) q.add(adjNode);
            }
        }
        
        return (count == V) ? false : true;
    } 
}