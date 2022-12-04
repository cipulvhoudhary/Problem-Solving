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
    
    private int minFallingPathSumTabulation(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        
        // Base - case
        for(int j=0; j<n; j++) {
            dp[n-1][j] = matrix[n-1][j];
        }
        
        // Main - logic
        for(int i=n-2; i>=0; i--) {
            for(int j=0; j<n; j++) {
                int bottom = dp[i+1][j];
                int bottomLeft = Integer.MAX_VALUE;
                int bottomRight = Integer.MAX_VALUE;
                if(j-1 >= 0 && j-1 < n) {
                    bottomLeft = dp[i+1][j-1];
                }
                if(j+1 >= 0 && j+1 < n) {
                    bottomRight = dp[i+1][j+1];
                }
                
                dp[i][j] = matrix[i][j] + Math.min(bottom, Math.min(bottomLeft, bottomRight));
            }
        }
        
        // Compute min falling sum. 
        int minFallingSum = Integer.MAX_VALUE;
        for(int j=0; j<n; j++) {
            minFallingSum = Math.min(minFallingSum, dp[0][j]);
        }
        
        return minFallingSum;
    }
    
    
    private int minFallingPathSumSpaceOptimized(int[][] matrix) {
        int n = matrix.length;
        int[] dp = new int[n];
        
        // Base - case
        for(int j=0; j<n; j++) {
            dp[j] = matrix[n-1][j];
        }
        
        // Main - logic
        for(int i=n-2; i>=0; i--) {
            int[] temp = new int[n];
            for(int j=0; j<n; j++) {
                int bottom = dp[j];
                int bottomLeft = Integer.MAX_VALUE;
                int bottomRight = Integer.MAX_VALUE;
                if(j-1 >= 0 && j-1 < n) {
                    bottomLeft = dp[j-1];
                }
                if(j+1 >= 0 && j+1 < n) {
                    bottomRight = dp[j+1];
                }
                
                temp[j] = matrix[i][j] + Math.min(bottom, Math.min(bottomLeft, bottomRight));
            }
            dp = temp;
        }
        
        // Compute min falling sum. 
        int minFallingSum = Integer.MAX_VALUE;
        for(int j=0; j<n; j++) {
            minFallingSum = Math.min(minFallingSum, dp[j]);
        }
        
        return minFallingSum;
    }
    
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        
        // Approach 1 :: Memoization
        // int minFallingSum = Integer.MAX_VALUE;
        // for(int j=0; j<n; j++) {
        //     int[][] dp = new int[n][n];
        //     for(int[] row : dp) Arrays.fill(row, -1);
        //     int fallingSum = minFallingPathSumUtil(0, j,  matrix, n, dp);
        //     minFallingSum = Math.min(minFallingSum, fallingSum);
        // }
        // return minFallingSum;
        
        // Approach 2 :: Tabulation
        // return minFallingPathSumTabulation(matrix);
        
        // Approach 2 :: SpaceOptimized
        return minFallingPathSumSpaceOptimized(matrix);
    }
}