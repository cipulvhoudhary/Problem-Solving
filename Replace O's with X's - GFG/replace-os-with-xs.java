//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    
    static void dfs(int row, int col, boolean[][] isVis, char[][] a, int[] r, int[] c) {
        // Mark it as visited a[row][col]
        isVis[row][col] = true;
        
        if(a[row][col] == 'O') {
            for(int k=0; k<4; k++) {
                int _row = row + r[k];
                int _col = col + c[k];
                // check for valid coordinate first
                if((_row >= 0 && _row < a.length) && (_col >= 0 && _col <a[0].length)) {
                    // is coordinate is not yet visited
                    if(a[_row][_col] == 'O' && !isVis[_row][_col]) {
                        dfs(_row, _col, isVis, a, r, c);
                    }
                }
            }
        }
    }
    
    static char[][] fill(int n, int m, char a[][]) {
        // code here
        boolean[][] isVis = new boolean[n][m];
        
        int[] row = {-1, 1, 0, 0};
        int[] col = {0, 0, -1, 1};
        
        // first row
        for(int c=0; c<m; c++) {
            if(a[0][c] == 'O' && !isVis[0][c]) {
                dfs(0, c, isVis, a, row, col);
            }
        }
        
        // last col
        for(int r=1; r<n; r++) {
            if(a[r][m-1] == 'O' && !isVis[r][m-1]) {
                dfs(r, m-1, isVis, a, row, col);
            }
        }
        
        // last row
        for(int c=m-2; c>=0; c--) {
            if(a[n-1][c] == 'O' && !isVis[n-1][c]) {
                dfs(n-1, c, isVis, a, row, col);
            }
        }
        
        // first col
        for(int r=n-2; r>=1; r--) {
            if(a[r][0] == 'O' && !isVis[r][0]) {
                dfs(r, 0, isVis, a, row, col);
            }
        }
        
        for(int r=0; r<n; r++) {
            for(int c=0; c<m; c++) {
                if(a[r][c] == 'O' && !isVis[r][c]) a[r][c] = 'X';
            }
        }
        return a;
    }
}