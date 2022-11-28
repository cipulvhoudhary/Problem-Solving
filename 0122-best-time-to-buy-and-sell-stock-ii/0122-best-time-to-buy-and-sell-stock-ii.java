class Solution {
    // canBuy --> true (can buy) || canBuy --> false (already bought)
    private int maxProfitUtil(int ind, int canBuy, int[] prices, int[][] dp) {
        // Base - case
        if(ind == prices.length) return 0;
        
        // Main - logic
        if(dp[ind][canBuy] == -1) {
            int profit = 0;
            if(canBuy == 1) {
                int buy = -prices[ind] + maxProfitUtil(ind+1, 0, prices, dp);
                int notBuy = 0 +  maxProfitUtil(ind+1, 1, prices, dp);
                profit = Math.max(buy, notBuy);
            }
            else {
                int sell = prices[ind] +  maxProfitUtil(ind+1, 1, prices, dp);
                int notSell = 0 +  maxProfitUtil(ind+1, 0, prices, dp);
                profit = Math.max(sell, notSell);
            }
            dp[ind][canBuy] = profit;
        }
        return dp[ind][canBuy];
    }
    
    public int maxProfit(int[] prices) {
        int N = prices.length;
        
        int[][] dp = new int[N][2];
        for(int[] row : dp) Arrays.fill(row, -1);
        
        return maxProfitUtil(0, 1, prices, dp);
    }
}