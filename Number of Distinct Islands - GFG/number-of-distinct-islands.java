//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    private String toString(int row, int col) {
        return Integer.toString(row) + " " + Integer.toString(col) + " , ";
    }
    
    private void dfs(int row, int col, int row0, int col0, boolean[][] isVis, int[][] grid, ArrayList<String> islandStructure, int[] delR, int[] delC, int n, int m) {
        // mark coordinate as visited
        isVis[row][col] = true;
        islandStructure.add(toString(row - row0, col - col0));
        
        for(int k=0; k<4; k++) {
            int _row = row + delR[k];
            int _col = col + delC[k];
            
            // check if coordinate adjacent to (row, col) is valid land cell ?
            if( (_row >= 0 && _row < n) && (_col >= 0 && _col < m) && (grid[_row][_col] == 1) ) {
                // check if land is not yet visited ? 
                if(!isVis[_row][_col]) {
                    dfs(_row, _col, row0, col0, isVis, grid, islandStructure, delR, delC, n, m);
                }
            }
        }
    }
    
    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n = grid.length, m = grid[0].length;
        
        boolean[][] isVis = new boolean[n][m];
        
        HashSet<ArrayList<String>> set = new HashSet<>();
        
        int[] delR = {-1, 1, 0, 0};
        int[] delC = {0, 0, -1, 1};
        
        for(int row=0; row <n; row++) {
            for(int col=0; col<m; col++) {
                if(grid[row][col] == 1 && !isVis[row][col]) {
                    ArrayList<String> islandStructure = new ArrayList<>();
                    dfs(row, col, row, col, isVis, grid, islandStructure, delR, delC, n, m);
                    set.add(islandStructure);
                }
            }
        }
        return set.size();
    }
}
