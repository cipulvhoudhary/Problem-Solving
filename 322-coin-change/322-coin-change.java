class Solution {
    
    private int coinChangeMemoizationUtil(int ind, int[] coins, int amount, int[][] dp) {
        //  base - case
        if(ind == 0) {
            if(amount%coins[ind] == 0) return amount/coins[ind];
            else return 1000000000;
        }
        
        // Main - logic
        if(dp[ind][amount] == -1) {
            int notTake = coinChangeMemoizationUtil(ind-1, coins, amount, dp);
            int take = 1000000000;
            if(amount >= coins[ind]) {
                take = 1 + coinChangeMemoizationUtil(ind, coins, amount-coins[ind], dp);
            }

            dp[ind][amount] = Math.min(notTake, take);
        }
        return dp[ind][amount];
    }
    
    private int coinChangeTabulationUtil(int N, int[] coins, int amount) {
        int[][] dp = new int[N][amount+1];
        
        for(int amt=0; amt<=amount; amt++) {
            if(amt%coins[0] == 0) dp[0][amt] = amt/coins[0];
            else dp[0][amt] = 1000000000;
        }
        
        for(int ind=1; ind<N; ind++) {
            for(int amt=0; amt<=amount; amt++) {
                int notTake = dp[ind-1][amt];
                int take = 1000000000;
                if(amt >= coins[ind]) {
                    take = 1 + dp[ind][amt-coins[ind]];
                }

                dp[ind][amt] = Math.min(notTake, take);
            }
        }
        return dp[N-1][amount];
    }
    
    public int coinChange(int[] coins, int amount) {
        int N = coins.length;
        
//         int[][] dp = new int[N][amount+1];
//         for(int[] row : dp) Arrays.fill(row, -1);
        
//         int ans = coinChangeMemoizationUtil(N-1, coins, amount, dp);
        
        int ans = coinChangeTabulationUtil(N, coins, amount);
        
        if(ans == 1000000000) return -1;
        return ans;
    }
    
}