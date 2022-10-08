class Solution {
    
    private int coinChangeUtil(int ind, int[] coins, int amount, int[][] dp) {
        //  base - case
        if(ind == 0) {
            if(amount%coins[ind] == 0) return amount/coins[ind];
            else return 1000000000;
        }
        
        // Main - logic
        if(dp[ind][amount] == -1) {
            int notTake = coinChangeUtil(ind-1, coins, amount, dp);
            int take = 1000000000;
            if(amount >= coins[ind]) {
                take = 1 + coinChangeUtil(ind, coins, amount-coins[ind], dp);
            }

            dp[ind][amount] = Math.min(notTake, take);
        }
        return dp[ind][amount];
    }
    
    public int coinChange(int[] coins, int amount) {
        int N = coins.length;
        
        int[][] dp = new int[N][amount+1];
        for(int[] row : dp) Arrays.fill(row, -1);
        
        int ans = coinChangeUtil(N-1, coins, amount, dp);
        if(ans == 1000000000) return -1;
        return ans;
    }
    
}