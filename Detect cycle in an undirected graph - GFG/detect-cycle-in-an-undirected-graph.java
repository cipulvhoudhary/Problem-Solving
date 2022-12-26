//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Pair {
    int node;
    int parent;
    public Pair(int node, int parent) {
        this.node = node;
        this.parent = parent;
    }
}

class Solution {
    // Function to detect cycle in an undirected graph.
    
    public boolean isCycleUtil(int start, ArrayList<ArrayList<Integer>> adj, boolean[] isVis) {
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(start, -1));
        isVis[start] = true;
        
        while(!q.isEmpty()) {
            Pair temp = q.poll();
            int node = temp.node;
            int parent = temp.parent;
            
            ArrayList<Integer> relNodes = adj.get(node);
            for(int i=0; i<relNodes.size(); i++) {
                int relNode = relNodes.get(i);
                
                if(!isVis[relNode]) { // not yet visited
                    isVis[relNode] = true;
                    q.add(new Pair(relNode, node));
                }
                else { // already visited. Check if parent is not same -> cycle
                    if(relNode != parent) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] isVis = new boolean[V];
        
        for(int i=0; i<V; i++) {
            if(!isVis[i]) {
                if(isCycleUtil(i, adj, isVis)) return true;
            }
        }
        return false;
    }
}