class Solution {
    /* Approach 
    - To reach nth step, 
    - we can directly jump from (n-1)th base or (n-2)nd base in 1 jump
    */
    
    // DP with memoization :: TC --> O(N) || SC --> O(N)
    private int climbStairsMemoizationUtil(int n, int[] dp) {
        if(n < 0) return 0;
        if(n <= 1) return 1;
        
        if(dp[n] == -1) {
            dp[n] = climbStairsMemoizationUtil(n-1, dp) + climbStairsMemoizationUtil(n-2, dp);
        }
        return dp[n];
    }
    
    // DP with Tabulation :: TC --> O(N) || SC --> O(N)
    private int climbStairsMemoization(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return climbStairsMemoizationUtil(n, dp);
    }
    
    private int climbStairsTabulation(int n) {
        if(n == 1) return n;
        
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i=2; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    
    // DP with Tabulation || Space Optimized :: TC --> O(N) || SC --> O(1)
    private int climbStairsTabulationSpaceOptimized(int n) {
        if(n == 1) return n;
        
        int a = 1, b = 1, c = 0;
        for(int i=2; i<=n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
    public int climbStairs(int n) {
        // return climbStairsMemoization(n);
        // return climbStairsTabulation(n);
        return climbStairsTabulationSpaceOptimized(n);
    }
}