//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int n = Integer.parseInt(st[0]);
            int m = Integer.parseInt(st[1]);

            for (int i = 0; i < n; i++)
                list.add(i, new ArrayList<Integer>());

            ArrayList<ArrayList<Integer>> prerequisites = new ArrayList<>();
            for (int i = 1; i <= m; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(v).add(u);
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(u);
                pair.add(v);
                prerequisites.add(pair);
            }

            int[] res = new Solution().findOrder(n, m, prerequisites);
            
            if(res.length==0)
                System.out.println("No Ordering Possible");
            else
            {
                if (check(list, n, res) == true)
                    System.out.println("1");
                else
                    System.out.println("0");
            }
        }
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public static void buildAdjacencyList(int N, ArrayList<ArrayList<Integer>> prerequisites, HashMap<Integer, ArrayList<Integer>> adj) {
        for(int i=0; i<N; i++) adj.put(i, new ArrayList<Integer>());
        
        for(int i=0; i<prerequisites.size(); i++) {
            int u = prerequisites.get(i).get(0);
            int v = prerequisites.get(i).get(1);
            
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
    
    static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> prerequisites)  {
        // add your code here
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        buildAdjacencyList(n, prerequisites, adj);
        
        int[] inDegree = new int[n];
        buildInDegree(n, adj, inDegree);
        
        ArrayList<Integer> topo = new ArrayList<>();
        getTopoSort(n, inDegree, adj, topo);
        
        
        if (topo.size() == n) {
            int[] topoArray = new int[n];
            for(int i=0; i<topo.size(); i++) {
                topoArray[i] = topo.get(i);
            }
            return topoArray;
        }
        return new int[0];
    }
}