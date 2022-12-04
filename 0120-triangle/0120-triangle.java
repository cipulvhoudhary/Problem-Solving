class Solution {
    
    // Approach - 1 :: Memoization
    // TC --> O(N*M) || SC --> O(N*M)
    private int minimumTotalMemoization(int i, int j, int n, int m, List<List<Integer>> triangle,int[][] dp) {
        // Base - case 
        if(i == n || j == m) return 0;
        
        // Main - logic
        if(dp[i][j] == -1) {
            int bottom = triangle.get(i).get(j) + minimumTotalMemoization(i+1, j, n, m, triangle, dp);
            int bottomRight = triangle.get(i).get(j) + minimumTotalMemoization(i+1, j+1, n, m, triangle, dp);

            dp[i][j] = Math.min(bottom, bottomRight);
        }
        return dp[i][j];
    }
    
    // Approach - 2 :: Tabulation
    // TC --> O(N*M) || SC --> O(N*M)
    private int minimumTotalTabulation(int n, int m, List<List<Integer>> triangle) {
        int[][] dp = new int[n][m];
        
        for(int j=0; j<m; j++) dp[n-1][j] = triangle.get(n-1).get(j);
        
        for(int i=n-2; i>=0; i--) {
            for(int j=0; j<triangle.get(i).size(); j++) {
                int bottom = triangle.get(i).get(j) + dp[i+1][j];
                int bottomRight = triangle.get(i).get(j) + dp[i+1][j+1];

                dp[i][j] = Math.min(bottom, bottomRight);
            }
        }
        return dp[0][0];
    }
    
    // Approach - 3 :: SpaceOptimized
    // TC --> O(N*M) || SC --> O(M) [Single array space optimized dp]
    private int minimumTotalSpaceOptimized(int n, int m, List<List<Integer>> triangle) {
        int[] dp = new int[m];
        
        for(int j=0; j<m; j++) dp[j] = triangle.get(n-1).get(j);
        
        for(int i=n-2; i>=0; i--) {
            for(int j=0; j<triangle.get(i).size(); j++) {
                int bottom = triangle.get(i).get(j) + dp[j];
                int bottomRight = triangle.get(i).get(j) + dp[j+1];

                dp[j] = Math.min(bottom, bottomRight);
            }
        }
        return dp[0];
    }
    
    
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(n-1).size();
        
        // Approach - 1 :: Memoization
        // int[][] dp = new int[n][m];
        // for(int[] row : dp) Arrays.fill(row, -1);
        // return minimumTotalMemoization(0, 0, n, m, triangle, dp);
        
        // Approach - 2 :: Tabulation
        return minimumTotalTabulation(n, m, triangle);
        
        // Approach - 3 :: SpaceOptimized
        // return minimumTotalSpaceOptimized(n, m, triangle);
    }
    
}