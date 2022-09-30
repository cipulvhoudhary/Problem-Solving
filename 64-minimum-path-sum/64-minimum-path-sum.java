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
    
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dp = new int[m][n];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        return minPathSumUtil(m-1, n-1, grid, dp);
    }
}