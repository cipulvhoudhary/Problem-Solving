class Solution {
    
    private int changeUtil(int ind, int target, int[] coins, int[][] dp) {
        // Base - case
        if(ind == 0) {
            return (target%coins[0] == 0) ? 1 : 0; 
        }
        
        // Main - logic
        if(dp[ind][target] == -1) {
            int notTake = changeUtil(ind-1, target, coins, dp);
            int take = 0;
            if(target >= coins[ind]) {
                take = changeUtil(ind, target-coins[ind], coins, dp);
            }

            dp[ind][target] = (notTake + take);
        }
        return dp[ind][target];
    }
    
    private int changeTabulationUtil(int N, int target, int[] coins) {
        int[][] dp = new int[N][target+1];
        
        // Base - case
        for(int ind=0; ind<N; ind++) dp[ind][0] = 1; // There is only one way
        
        for(int t=1; t<=target; t++) {
            if(t%coins[0] == 0) dp[0][t] = 1;
        }
        
        // Main - logic
        for(int ind=1; ind<N; ind++) {
            for(int t=1; t<=target; t++) {
                int notTake = dp[ind-1][t];
                int take = 0;
                if(t >= coins[ind]) {
                    take = dp[ind][t-coins[ind]];
                }

                dp[ind][t] = (notTake + take);
            }
        }
        return dp[N-1][target];
    }
    
    public int change(int amount, int[] coins) {
        int N = coins.length;
        if(amount == 0) return 1;
        
//         int[][] dp = new int[N][amount+1];
//         for(int[] row : dp) Arrays.fill(row, -1);
        
//         return changeUtil(N-1, amount, coins, dp);
        
        return changeTabulationUtil(N, amount, coins);
    }
    
}