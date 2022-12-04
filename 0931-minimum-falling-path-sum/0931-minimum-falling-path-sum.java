class Solution {
    
    private int minFallingPathSumUtil(int i, int j, int[][] matrix, int n, int[][] dp) {
        // Boundary - condition
        if(i < 0 || i >= n) return Integer.MAX_VALUE;
        if(j < 0 || j >= n) return Integer.MAX_VALUE;
        
        // Base - case
        if(i == n-1 && (j >= 0 && j < n)) return matrix[i][j];
              
        // Main - logic
        if(dp[i][j] == -1) {
            int bottomLeft = minFallingPathSumUtil(i+1, j-1, matrix, n, dp);
            int bottom = minFallingPathSumUtil(i+1, j, matrix, n, dp);
            int bottomright = minFallingPathSumUtil(i+1, j+1, matrix, n, dp);

            dp[i][j] = matrix[i][j] + Math.min(bottom, Math.min(bottomLeft, bottomright));
        } 
        return dp[i][j];
    }
    
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        
        int minFallingSum = Integer.MAX_VALUE;
        for(int j=0; j<n; j++) {
            
            int[][] dp = new int[n][n];
            for(int[] row : dp) Arrays.fill(row, -1);
            
            int fallingSum = minFallingPathSumUtil(0, j,  matrix, n, dp);
            minFallingSum = Math.min(minFallingSum, fallingSum);
        }
        return minFallingSum;
    }
}