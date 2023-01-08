//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends

class Pair {
    int v;
    int w;
    public Pair(int v, int w) {
        this.v = v;
        this.w = w;
    }
}

//User function Template for Java
class Solution {
    
    public static void buildAdjacencyList(int N, int M, int[][] edges, HashMap<Integer, ArrayList<Pair>> adj) {
        for(int i=0; i<N; i++) adj.put(i, new ArrayList<Pair>());
        
        for(int i=0; i<M; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            
            adj.get(u).add(new Pair(v, w));
        }
    }
    
    public static void dfs(int node, boolean[] isVis, Stack<Integer> st, HashMap<Integer, ArrayList<Pair>> adj) {
        isVis[node] = true;
        
        ArrayList<Pair> adjNodes = adj.get(node);
        for(Pair adjpairNodes : adjNodes) {
            int adjNode = adjpairNodes.v;
            if(!isVis[adjNode]) {
                dfs(adjNode, isVis, st, adj);
            }
        }
        
        st.add(node);
    }
    
	public int[] shortestPath(int N, int M, int[][] edges) {
		//Code here
		// Get the topo in stack
		// for each ele of stack update the min distance
		
		int src = 0;
		
		HashMap<Integer, ArrayList<Pair>> adj = new HashMap<>();
		buildAdjacencyList(N, M, edges, adj);
		
		Stack<Integer> st = new Stack<>();
		boolean[] isVis = new boolean[N];
		for(int i=0; i<N; i++) {
		    if(!isVis[i]) {
		        dfs(i, isVis, st, adj);
		    }
		}
		
		int[] dist = new int[N];
		Arrays.fill(dist, (int)1e9);
		
		dist[src] = 0;
		
		while(!st.isEmpty()) {
		    int node = st.pop();
		    
		    ArrayList<Pair> adjNodes = adj.get(node);
            for(Pair adjpairNodes : adjNodes) {
                int v = adjpairNodes.v;
                int w = adjpairNodes.w;
                
                if(dist[node] + w < dist[v]) {
                    dist[v] = dist[node] + w;
                }
            }
		}
		for(int i=0; i<N; i++) {
		    if(dist[i] == (int)1e9) {
		        dist[i] = -1;
		    }
		}
		return dist;
	}
}