class Solution {
    
    private int uniquePathsWithObstaclesUtil(int x, int y, int[][] obstacleGrid, int[][] dp) {
        // Boundary - case
        if(x < 0 || y < 0) return 0;
        // Obstacle check
        if(obstacleGrid[x][y] == 1) return 0;
        // Base - case 
        if(x == 0 && y == 0) return 1; // Destination(0, 0)
        
        
        if(dp[x][y] == -1) {
            // Main logic : we can either move up or left
            int top = uniquePathsWithObstaclesUtil(x-1, y, obstacleGrid, dp);
            int left = uniquePathsWithObstaclesUtil(x, y-1, obstacleGrid, dp);
            dp[x][y] = top + left;
        }
        
        return dp[x][y];
    }
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        int[][] dp = new int[m][n];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        return uniquePathsWithObstaclesUtil(m-1, n-1, obstacleGrid, dp);
    }
}