class Solution {
    
    private int uniquePathsWithObstaclesUtil(int i, int j, int m, int n, int[][] obstacleGrid, int[][] dp) {
        // Base - case
        if((i < 0 || i >= m) || (j < 0 || j>= n)) return 0;
        if(obstacleGrid[i][j] == 1) return 0;
        if(i == 0 && j == 0) return 1;
        
        // Main - logic 
        if(dp[i][j] == -1) {
            int top = uniquePathsWithObstaclesUtil(i-1, j, m, n, obstacleGrid, dp);
            int left = uniquePathsWithObstaclesUtil(i, j-1, m, n, obstacleGrid, dp);

            dp[i][j] = top + left;
        }
        return dp[i][j];
    }
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        int[][] dp = new int[m][n];
        for(int[] row : dp) Arrays.fill(row, -1);
        
        return uniquePathsWithObstaclesUtil(m-1, n-1, m, n, obstacleGrid, dp);
    }
}