class Solution {
    
    // Memoization :: TC --> O(N*N) || SC --> O(N*N)
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
    
    // Tabulation :: TC --> O(N*N) || SC --> O(N*N)
    private int minFallingPathSumTabulationUtil(int [][] matrix) {
        int n = matrix.length;
        
        int[][] dp = new int[n][n];
        
        if(n == 1) return matrix[0][0]; // Edge - case
    
        for(int col=0; col<n; col++) {
            dp[0][col] = matrix[0][col];
        }
        
        int minSum = Integer.MAX_VALUE;
        
        for(int row=1; row < n; row++) {
            for(int col=0; col<n; col++) {
                int top = dp[row-1][col];
                int topLeft = Integer.MAX_VALUE;
                int topRight = Integer.MAX_VALUE;
                if(col-1 >= 0) topLeft = dp[row-1][col-1];
                if(col+1 < n) topRight = dp[row-1][col+1];
                
                int sum = matrix[row][col] + Math.min(top, Math.min(topLeft, topRight));
                dp[row][col] = sum;
                
                if(row == n-1) {
                    minSum = Math.min(minSum, sum);
                }
            }
        }
        return minSum;
    }
    
    // Space optimized :: TC --> O(N*N) || SC --> O(N)
    private int minFallingPathSumSpaceOptimizedUtil(int [][] matrix) {
        int n = matrix.length;
        
        int[] dp = new int[n];
        
        if(n == 1) return matrix[0][0]; // Edge - case
    
        for(int col=0; col<n; col++) {
            dp[col] = matrix[0][col];
        }
        
        int minSum = Integer.MAX_VALUE;
        
        for(int row=1; row < n; row++) {
            int[] temp = new int[n];
            for(int col=0; col<n; col++) {
                int top = dp[col];
                int topLeft = Integer.MAX_VALUE;
                int topRight = Integer.MAX_VALUE;
                if(col-1 >= 0) topLeft = dp[col-1];
                if(col+1 < n) topRight = dp[col+1];
                int sum = matrix[row][col] + Math.min(top, Math.min(topLeft, topRight));
                temp[col] = sum;
                
                if(row == n-1) {
                    minSum = Math.min(minSum, sum);
                }
            }
            dp = temp;
        }
        return minSum;
    }
    
    public int minFallingPathSum(int[][] matrix) {
//         int n = matrix.length;
        
        
//         int minSum = Integer.MAX_VALUE;
//         for(int col=0; col<n; col++) {
            
//             int[][] dp = new int[n][n];
//             for(int[] row : dp) {
//                 Arrays.fill(row, -1);
//             }
            
//             minSum = Math.min(minSum, minFallingPathSumUtil(n-1, col, matrix, dp));
//         }
//         return minSum;
        
        // Tabulation
        // return minFallingPathSumTabulationUtil(matrix);
        
        // Space Optimized
        return minFallingPathSumSpaceOptimizedUtil(matrix);
    }
    
}