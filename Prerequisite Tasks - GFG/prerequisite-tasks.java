//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
		while(t>0)
		{
		    int N = sc.nextInt();
		    int P = sc.nextInt();
		    int prerequisites[][] = new int[P][2];
		    for(int i=0;i<P;i++)
		    {
		        for(int j=0;j<2;j++)
		        {
		            prerequisites[i][j] = sc.nextInt();
		        }
		    }
			Solution ob = new Solution();
			if(ob.isPossible(N,prerequisites))
			{
			    System.out.println("Yes");
			}
			else{
			    System.out.println("No");
			}
			t--;
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public static void buildAdjacencyList(int N, int[][] prerequisites, HashMap<Integer, ArrayList<Integer>> adj) {
        for(int i=0; i<N; i++) adj.put(i, new ArrayList<Integer>());
        
        for(int i=0; i<prerequisites.length; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            
            adj.get(v).add(u);
        }
    }
    
    public static void buildInDegree(int N, HashMap<Integer, ArrayList<Integer>> adj, int[] inDegree) {
        for(int i=0; i<N; i++) {
            ArrayList<Integer> adjNodes = adj.get(i);
            for(int adjNode : adjNodes) {
                inDegree[adjNode]++;
            }
        }
    }
    
    public static void getTopoSort(int N, int[] inDegree, HashMap<Integer, ArrayList<Integer>> adj, ArrayList<Integer> topo) {
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<N; i++) {
            if(inDegree[i] == 0) q.add(i);
        }
        
        while(!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);
            
            ArrayList<Integer> adjNodes = adj.get(node);
            for(int adjNode : adjNodes)  {
                inDegree[adjNode]--;
                if(inDegree[adjNode] == 0) q.add(adjNode);
            }
        }
    }
    
    public boolean isPossible(int N, int[][] prerequisites) {
        // Your Code goes here
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        buildAdjacencyList(N, prerequisites, adj);
        
        int[] inDegree = new int[N];
        buildInDegree(N, adj, inDegree);
        
        ArrayList<Integer> topo = new ArrayList<>();
        getTopoSort(N, inDegree, adj, topo);
        
        return (topo.size() == N) ? true : false;
    }
    
}