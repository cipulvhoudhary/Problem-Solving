//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Pair {
    int node;
    int dist;
    public Pair(int node, int dist) {
        this.node = node;
        this.dist = dist;
    }
}

class Solution {
    
    public static void buildAdjacencyList(int[][] edges, int n, int m, HashMap<Integer, ArrayList<Integer>> adj) {
        for(int i=0; i<n; i++) adj.put(i, new ArrayList<>());
        
        for(int i=0; i<m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
    }
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        
        // build adjacency list
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        buildAdjacencyList(edges, n, m, adj);
        
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src, 0));
        
        while(!q.isEmpty()) {
            Pair pair = q.poll();
            int node = pair.node;
            int dist = pair.dist;
            
            ArrayList<Integer> adjNodes = adj.get(node);
            for(int adjNode : adjNodes) {
                if(dist + 1 < distance[adjNode]) {
                    distance[adjNode] = dist + 1;
                    q.add(new Pair(adjNode, dist + 1));
                }
            }
        }
        
        for(int i=0; i<n; i++) {
            if(distance[i] == Integer.MAX_VALUE) {
                distance[i] = -1;
            }
        }
        
        return distance;
    }
}