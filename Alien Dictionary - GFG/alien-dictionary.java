//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public static void buildAdjacencyList(String[] dict, int N, int K, HashMap<Integer, ArrayList<Integer>> adj) {
        for(int i=0; i<K; i++) adj.put(i, new ArrayList<Integer>());
        
        for(int i=1; i<N; i++) {
            
            String s1 = dict[i-1];
            String s2 = dict[i];
            
            int len = Math.min(s1.length(), s2.length());
            for(int j=0; j<len; j++) {
                if(s1.charAt(j) != s2.charAt(j)) {
                    adj.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');
                    break;
                }
            }
        }    
    }
    
    public static void buildInDegree(HashMap<Integer, ArrayList<Integer>> adj, int[] inDegree, int K) {
        for(int node=0; node<K; node++) {
            ArrayList<Integer> adjNodes = adj.get(node);
            for(int adjNode : adjNodes) {
                inDegree[adjNode]++;
            }
        }
    }
    
    public String findOrder(String [] dict, int N, int K) {
        // Write your code here
        HashMap<Integer, ArrayList<Integer>> adj = new HashMap<>();
        buildAdjacencyList(dict, N, K, adj);
        
        int[] inDegree = new int[K];
        buildInDegree(adj, inDegree, K);
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i<K; i++) {
            if(inDegree[i] == 0) q.add(i);
        }
        
         ArrayList<Integer> topo = new ArrayList<>();
         
        while(!q.isEmpty()) {
            int node = q.poll();
            
            ArrayList<Integer> adjNodes = adj.get(node);
            for(int adjNode : adjNodes) {
                inDegree[adjNode]--;
                if(inDegree[adjNode] == 0) q.add(adjNode);
            }
            
            topo.add(node);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int e : topo) {
            sb.append((char)(e + 'a'));
        }
        return sb.toString();
    }
}