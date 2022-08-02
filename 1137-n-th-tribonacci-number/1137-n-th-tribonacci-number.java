class Solution {
    
    private int tribonacciMemoizationUtil(int n, int[] dp) {
        // Base - case 
        if(n <= 1) return n;
        if(n == 2) return 1;
        
        if(dp[n] == -1) {
            dp[n] = tribonacciMemoizationUtil(n-1, dp) + tribonacciMemoizationUtil(n-2, dp) + tribonacciMemoizationUtil(n-3, dp);
        }
        return dp[n];
    }
    
    // DP with Memoization :: TC --> O(N) || SC --> O(N)
    private int tribonacciMemoization(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return tribonacciMemoizationUtil(n, dp);
    }
    
    // DP with Tabulation :: TC --> O(N) || SC --> O(N)
    private int tribonacciTabulation(int n) {
        if(n <= 1) return n;
        if(n == 2) return 1;
        
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        
        for(int i=3; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        return dp[n];
    }
    
    // DP with Tabulation || Space Optimized  :: TC --> O(N) || SC --> O(1)
    private int tribonacciTabulationSpaceOptimized(int n) {
        if(n <= 1) return n;
        if(n == 2) return 1;
        
        int a = 0, b = 1, c = 1, d = 0;
        for(int i=3; i<=n; i++) {
            d = a + b + c;
            a = b;
            b = c;
            c = d;
        }
        return d;
    }
    
    public int tribonacci(int n) {
        // return tribonacciMemoization(n);
        // return tribonacciTabulation(n);
        return tribonacciTabulationSpaceOptimized(n);
    }
}