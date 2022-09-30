class Solution {
    
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
    
    public int minimumTotal(List<List<Integer>> triangle) {
        int numRows = triangle.size();
        
        int[][] dp = new int[numRows][triangle.get(numRows-1).size()];
        for(int[] row : dp) {
            Arrays.fill(row, -1);
        }
        
        return minimumTotalUtil(0, 0, numRows, triangle, dp);
    }
}