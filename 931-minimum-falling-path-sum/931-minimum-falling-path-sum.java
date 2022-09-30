class Solution {
    
    private int minFallingPathSumUtil(int x, int y, int[][] matrix, int[][] dp) {
        // Boundary case
        if(x < 0 || y < 0 || y >= matrix.length) return Integer.MAX_VALUE;
        
        // Base - case
        if(x == 0) return matrix[x][y];
        
        // Main - logic :: move --> topLeft, top, topRight
        if(dp[x][y] == -1) {
            int topLeft = minFallingPathSumUtil(x-1, y-1, matrix, dp);
            int top = minFallingPathSumUtil(x-1, y, matrix, dp);
            int topRight = minFallingPathSumUtil(x-1, y+1, matrix, dp);

            dp[x][y] = matrix[x][y] + Math.min(top, Math.min(topLeft, topRight));
        }
        return dp[x][y];
        
    }
    
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        
        
        int minSum = Integer.MAX_VALUE;
        for(int col=0; col<n; col++) {
            
            int[][] dp = new int[n][n];
            for(int[] row : dp) {
                Arrays.fill(row, -1);
            }
            
            minSum = Math.min(minSum, minFallingPathSumUtil(n-1, col, matrix, dp));
        }
        return minSum;
    }
    
}