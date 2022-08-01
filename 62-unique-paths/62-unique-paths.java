class Solution {
    
    //Memoization [Top-Down]
    private int uniquePathsMemoizationUtil(int i, int j, int m, int n, int[][] dp) {
        // Base - case
        if(i == m-1 && j == n-1) {
            return 1;
        }
        if(i >= m || j >= n) {
            return 0;
        }
        //Main - logic
        if(dp[i][j] == -1) {
            dp[i][j] = uniquePathsMemoizationUtil(i+1, j, m, n, dp) + uniquePathsMemoizationUtil(i, j+1, m, n, dp);
        }
        return dp[i][j];
    }
    private int uniquePathsMemoization(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return uniquePathsMemoizationUtil(0, 0, m, n, dp);
    }
    
    // Tabulation [Bottoms-up]
    private int uniquePathsTabulation(int m, int n) {
        int[][] dp = new int[m][n];
        
        //fill first row as 1, only 1 possible path to reach anywhere in 0th row/ oth col
        for(int i=0; i<m; i++) dp[i][0] = 1;
        for(int j=0; j<n; j++) dp[0][j] = 1;
        
        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    } 
    
    private int uniquePathsTabulationSpaceOptimized(int m, int n) { 
        //using a single array
        int[] top = new int[n];
        Arrays.fill(top, 1);
        
        for(int i=1; i<m; i++) {
            int left = 1;
            for(int j=1; j<n; j++) {
                top[j] = top[j] + left;
                left = top[j];
            }
        }
        return top[n-1];
    }
    
    public int uniquePaths(int m, int n) {
        return uniquePathsMemoization(m, n);
        // return uniquePathsTabulation(m, n);
        // return uniquePathsTabulationSpaceOptimized(m, n);
    }
}