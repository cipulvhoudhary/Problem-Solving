class Solution {
    
    private int uniquePathsUtil(int i, int j, int m, int n, int[][] dp) {
        // Base - case 
        if((i < 0 || i >= m) || (j < 0 || j  >= n)) return 0;
        if(i == 0 && j == 0) return 1;
        
        // Main - logic 
        if(dp[i][j] == -1) {
            int top = uniquePathsUtil(i-1, j, m, n, dp);
            int left = uniquePathsUtil(i, j-1, m, n, dp); 

            dp[i][j] = top + left;
        }
        return dp[i][j];
    }
    
    public int uniquePaths(int m, int n) {
        
        int[][] dp = new int[m][n];
        for(int[] row : dp) Arrays.fill(row, -1);
        
        return uniquePathsUtil(m-1, n-1, m, n, dp);
    }
}