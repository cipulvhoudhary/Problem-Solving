class Solution {
    
    
    private int uniquePathsWithObstaclesMemoizationUtil(int x, int y, int[][] obstacleGrid, int[][] dp) {
        // Boundary - case
        if(x < 0 || y < 0) return 0;
        // Obstacle check
        if(obstacleGrid[x][y] == 1) return 0;
        // Base - case 
        if(x == 0 && y == 0) return 1; // Destination(0, 0)
        
        
        if(dp[x][y] == -1) {
            // Main logic : we can either move up or left
            int top = uniquePathsWithObstaclesMemoizationUtil(x-1, y, obstacleGrid, dp);
            int left = uniquePathsWithObstaclesMemoizationUtil(x, y-1, obstacleGrid, dp);
            dp[x][y] = top + left;
        }
        
        return dp[x][y];
    }
    
    private int uniquePathsWithObstaclesTabulationUtil(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        int[][] dp = new int[m][n];
        
        // Base - case 
        boolean rowObstacle = false;
        for(int row=0; row<m; row++) {
            if(obstacleGrid[row][0] == 1) {
                rowObstacle = true;
            }
            if(!rowObstacle) {
                dp[row][0] = 1;
            }
        }
        
        boolean colObstacle = false;
        for(int col=0; col<n; col++) {
            if(obstacleGrid[0][col] == 1) {
                colObstacle = true;
            }
            if(!colObstacle) {
                dp[0][col] = 1;
            }
        }
        
        // Main - logic
        for(int row=1; row<m; row++) {
            for(int col=1; col<n; col++) {
                if(obstacleGrid[row][col] == 1) {
                    dp[row][col] = 0;
                }
                else {
                    dp[row][col] = dp[row-1][col] + dp[row][col-1]; // left + top
                }
            }
        }
        
        return dp[m-1][n-1];
    }
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//         int m = obstacleGrid.length;
//         int n = obstacleGrid[0].length;
        
//         int[][] dp = new int[m][n];
//         for(int[] row : dp) {
//             Arrays.fill(row, -1);
//         }
        
//         return uniquePathsWithObstaclesMemoizationUtil(m-1, n-1, obstacleGrid, dp);
        
        return uniquePathsWithObstaclesTabulationUtil(obstacleGrid);
        
    }
}