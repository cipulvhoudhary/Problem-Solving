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
    
    public int change(int amount, int[] coins) {
        int N = coins.length;
        if(amount == 0) return 1;
        
        int[][] dp = new int[N][amount+1];
        for(int[] row : dp) Arrays.fill(row, -1);
        
        return changeUtil(N-1, amount, coins, dp);
    }
    
}