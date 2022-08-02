class Solution {
    
    private int fibUtilMemoizationUtil(int n, int[] dp) {
        //Base - case
        if(n <= 1) return n;
        
        // Main - logic
        if(dp[n] == -1) {
            dp[n] = fibUtilMemoizationUtil(n-1, dp) + fibUtilMemoizationUtil(n-2, dp);
        }
        return dp[n];
    }
    
    private int fibUtilMemoization(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return fibUtilMemoizationUtil(n, dp);
    }
    
    private int fibUtilTabulation(int n) {
        int[] dp = new int[n+1];
        //Base - case
        if(n <= 1) return n;
        
        dp[0] = 0;
        dp[1] = 1;
        
        for(int i=2; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    
    private int fibUtilTabulationSpaceOptimization(int n) {
        if(n <= 1) return n;
        int a = 0, b = 1, c = a+b;
        for(int i=2; i<=n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
    
    public int fib(int n) {
        // return fibUtilMemoization(n);
        // return fibUtilTabulation(n);
        return fibUtilTabulationSpaceOptimization(n);
    }
}