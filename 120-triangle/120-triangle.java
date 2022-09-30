class Solution {
    
    // Memoization(Top down) :: TC--> O(M*N) || SC --> O(M*N)
    private int minimumTotalUtil(int row, int col, int numRows, List<List<Integer>> triangle, int[][] dp) {
        //Boundary - case
        if(row >= numRows) return Integer.MAX_VALUE;
        // Base - case
        if(row == numRows-1) return triangle.get(row).get(col);
        
        // Main - logic
        if(dp[row][col] == -1) {
            int bottom = minimumTotalUtil(row+1, col, numRows, triangle, dp);
            int bRight = minimumTotalUtil(row+1, col+1, numRows, triangle, dp);

            dp[row][col] = triangle.get(row).get(col) + Math.min(bottom, bRight);
        }
        return dp[row][col];
    }
    
    // Tabulation(Bottoms up) :: TC--> O(M*N) || SC --> O(M*N)
    private int minimumTotalTabluationUtil(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m-1).size();
        int[][] dp = new int[m][n];
        
        // Base - case
        dp[0][0] = triangle.get(0).get(0);
        // setting inf at voids
        int start = 1;
        for(int row=0; row<m; row++) {
            for(int col=start; col<n; col++) {
                dp[row][col] = Integer.MAX_VALUE;
            }
            start++;
        }
        
        //setting first col
        for(int row=1; row<m; row++) {
            dp[row][0] = triangle.get(row).get(0) + dp[row-1][0];
        }
        
        int minSum = dp[m-1][0];
        for(int row=1; row<m; row++) {
            for(int col=1; col<n; col++) {
                if(dp[row][col] == Integer.MAX_VALUE) continue;
                int top = dp[row-1][col];
                int tLeft = dp[row-1][col-1];
                
                dp[row][col] = triangle.get(row).get(col) + Math.min(top, tLeft);
                
                if(row == m-1) {
                    minSum = Math.min(minSum, dp[row][col]);
                }
            }
        }
        return minSum;
    }
    
    // Space - optimized :: TC--> O(M*N) || SC --> O(rows) or O(M)
    private int minimumTotalSpaceOptimizedUtil(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m-1).size();
        
        int[] dp = new int[m];
        
        //setting up first col, i.e dp[]
        dp[0] = triangle.get(0).get(0);
        for(int row=1; row<m; row++) {
            dp[row] = triangle.get(row).get(0) + dp[row-1];
        }
        
        int start = 1;
        int minSum = dp[m-1];
        for(int col=1; col<n; col++) {
            
            int[] temp = new int[m];
            for(int i=0; i<start; i++) {
                temp[i] = Integer.MAX_VALUE;
            }
            
            for(int row=start; row<m; row++) {
                temp[row] = triangle.get(row).get(col) + Math.min(temp[row-1], dp[row-1]);
            }
            
            minSum = Math.min(minSum, temp[m-1]);
            
            start++;
            dp = temp;
        }
        
        return minSum;
    }
    
    public int minimumTotal(List<List<Integer>> triangle) {
//         int numRows = triangle.size();
        
//         int[][] dp = new int[numRows][triangle.get(numRows-1).size()];
//         for(int[] row : dp) {
//             Arrays.fill(row, -1);
//         }
        
//         return minimumTotalUtil(0, 0, numRows, triangle, dp);
        
        // return minimumTotalTabluationUtil(triangle);
        
        return minimumTotalSpaceOptimizedUtil(triangle);
    }
}