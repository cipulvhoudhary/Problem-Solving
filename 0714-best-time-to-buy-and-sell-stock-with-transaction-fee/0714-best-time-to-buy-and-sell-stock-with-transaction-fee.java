class Solution {
    
    private int maxProfitUtil(int ind, int canBuy, int N, int[] prices, int fee, int[][] dp) {
        
        // Boundary - condition
        if(ind >= N) return 0;
        
        // Base - case
        if(ind == N-1) {
            if(canBuy == 1) {
                // no profit can be made, as we have to buy, 
                // but since there is no point in buying at last, we will not buy.    
                return 0; 
            }
            else {
                // As we have already bought stock, we need to square off 
                // to gain some profit atleast. But here we will have to pay transaction fee also
                // if profit made is negative, we will not sell 
                // sell only if profit made is positive
                return (prices[ind] - fee < 0) ? 0 : prices[ind] - fee;
            }
        }
        
        // Main - logic
        if(dp[ind][canBuy] == -1) {
            int profit = 0;
            if(canBuy == 1) {
                int buy = -prices[ind] + maxProfitUtil(ind+1, 0, N, prices, fee, dp);
                int notBuy = 0 + maxProfitUtil(ind+1, 1, N, prices, fee, dp);
                profit = Math.max(buy, notBuy);
            }
            else {
                int sell = (prices[ind] - fee) + maxProfitUtil(ind+1, 1, N, prices, fee, dp);
                int notSell = 0 + maxProfitUtil(ind+1, 0, N, prices, fee, dp);
                profit = Math.max(sell, notSell);
            }
            dp[ind][canBuy] = profit;
        }
        return dp[ind][canBuy];
    }
    
    public int maxProfit(int[] prices, int fee) {
        int N = prices.length;
        
        int[][] dp = new int[N][2];
        for(int[] row : dp) Arrays.fill(row, -1);
        
        int canBuy = 1;
        return maxProfitUtil(0, canBuy, N, prices, fee, dp);
    }
}