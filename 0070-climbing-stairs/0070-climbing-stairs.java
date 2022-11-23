class Solution {
    
    private int climbStairsMemoization(int n, int[] dp) {
        // Base - case
        if(n == 1 || n == 2) return n;
        
        // Main - logic
        if(dp[n] == -1) {
            dp[n] = climbStairsMemoization(n-1, dp) + climbStairsMemoization(n-2, dp);
        }
        return dp[n];
    }
    
    private int climbStairsTabulation(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        if(n > 1) dp[2] = 2;
        
        for(int i=3; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    
    private int climbStairsSpaceOptimized(int n) {
        if(n <= 2) return n;
        int prev2 = 1, prev = 2;
        for(int i=3; i<=n; i++) {
            int curr = prev2 + prev;
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
    
    public int climbStairs(int n) {
        
        // Memoization
        // int[] dp = new int[n+1];
        // Arrays.fill(dp, -1);
        // return climbStairsMemoization(n, dp);
        
        // Tabulation
        // return climbStairsTabulation(n);
        
        // Space - optimized
        return climbStairsSpaceOptimized(n);
    }
    
}