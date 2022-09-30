class Solution {
    
    private int minPathSumUtil(int x, int y, int[][] grid, int[][] dp) {
        // Boundary - condition
        if(x < 0 || y < 0) return Integer.MAX_VALUE;
        // Base- case
        if(x == 0 && y == 0) return grid[x][y];
        
        if(dp[x][y] == -1) {
            int top = minPathSumUtil(x-1, y, grid, dp);
            int left = minPathSumUtil(x, y-1, grid, dp);

            dp[x][y] = grid[x][y] + Math.min(top, left);
        }
        return dp[x][y];
    }
    
    private int minPathSumTabulationUtil(int m, int n, int[][] grid) {
        // Take dp of same size
        int[][] dp = new int[m][n];
        // Since, tabulation is bottoms-up methodology, 
        // We need to fill the base case first
        dp[0][0] = grid[0][0];
        // Filling the top row
        for(int col=1; col<n; col++) {
            dp[0][col] = grid[0][col] + dp[0][col-1];
        }
        //filling the first column
        for(int row=1; row<m; row++) {
            dp[row][0] = grid[row][0] + dp[row-1][0];
        }
        
        for(int row=1; row<m; row++) {
            for(int col=1; col<n; col++) {
                int top = dp[row-1][col];
                int left = dp[row][col-1];

                dp[row][col] = grid[row][col] + Math.min(top, left);
            }
        }
        return dp[m-1][n-1];
    }
    
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
//         int[][] dp = new int[m][n];
//         for(int[] row : dp) {
//             Arrays.fill(row, -1);
//         }
        
//         return minPathSumUtil(m-1, n-1, grid, dp);
        
        return minPathSumTabulationUtil(m, n, grid);
    }
}